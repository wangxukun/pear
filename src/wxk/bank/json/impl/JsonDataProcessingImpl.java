package wxk.bank.json.impl;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import wxk.bank.entity.Accrual;
import wxk.bank.json.JsonDataProcessing;
import wxk.bank.service.factory.ServiceFactory;

public class JsonDataProcessingImpl implements JsonDataProcessing {

	@Override
	public JSONObject getAccountDetail(int accountid, Date start, Date end) {
		JSONObject jo = new JSONObject();
		JSONArray ja = new JSONArray();
		try {
			//取得期初余额
			String initBalance = ServiceFactory.getDataProcessingServiceInstance().getInitialBalance(accountid, end, start);
			//取得本期发生额
			List<Accrual> accruals = ServiceFactory.getDataProcessingServiceInstance().getAccrualsOfsubAccount(accountid, start, end);
			Iterator<Accrual> iter = accruals.iterator();
			JSONObject first = new JSONObject();
			first.accumulate("id", 0);
			first.accumulate("occurdate", "");
			first.accumulate("month", "00期初");	//为了grid grop排序，增加了2个00
			first.accumulate("number", -1);
			first.accumulate("summary", "期初余额");
			first.accumulate("jie",0);
			first.accumulate("dai",0);
			first.accumulate("direction", 0);
			first.accumulate("balance", initBalance);
			ja.add(first);
			BigDecimal balance = new BigDecimal(initBalance);
			StringBuffer strMonth = new StringBuffer("");
			int n = 0; //用于存储编号
			int m = 0; //用于存储月份
			while(iter.hasNext()){
				Accrual accrual = null;
				JSONObject o = new JSONObject();
				accrual = iter.next();
				o.accumulate("id", accrual.getAccountdetailid());
				
				Date occurdate = accrual.getOccurdate();
				o.accumulate("occurdate", occurdate.toString());
				int month = occurdate.getMonth()+1;
				strMonth.append(month);
				if(strMonth.length()<2){	//月份数低于2位数，前面补0
					strMonth.insert(0, 0);
				}
				o.accumulate("month", strMonth.append("月").toString());
				strMonth.delete(0, strMonth.length());
				
				if(month != m){
					n = 0;
				}
				
				o.accumulate("number", ++n);
				o.accumulate("summary", accrual.getSummary());
				
				//生成本期发生额并计算余额
				BigDecimal a = new BigDecimal(accrual.getAmount());
				
				
				if(accrual.getDirection()==0){
					o.accumulate("jie",accrual.getAmount());
					o.accumulate("dai",0);
					balance = balance.add(a);
					o.accumulate("balance", balance.toString());
				}else{
					o.accumulate("dai",accrual.getAmount());
					o.accumulate("jie",0);
					balance = balance.subtract(a);
					o.accumulate("balance", balance.toString());
				}
				
				//计算期末余额方向,如果等于这个数的绝对值方向为借
				if(balance.toString().equals(balance.abs().toString())){
					o.accumulate("direction", 0);
				}else{
					o.accumulate("direction", 1);
				}
				
				ja.add(o);
				
				m = month;
			}
			jo.accumulate("accountdetail", ja);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jo;
	}
//{id: 1, month: '1月', occurdate:'01/24/2007',number: 1, summary: '收到补助收入', jie: 6, dai: 150},
	/**
	 * 此方法有待改进，其中小计、累计可以封装为一个方法
	 */
	@Override
	public ByteArrayOutputStream getAccountDetailXML(int accountid, Date start, Date end) {
		ByteArrayOutputStream xml = new ByteArrayOutputStream();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			//取得期初余额
			String initBalance = ServiceFactory.getDataProcessingServiceInstance().getInitialBalance(accountid, end, start);
			//取得本期发生额
			List<Accrual> accruals = ServiceFactory.getDataProcessingServiceInstance().getAccrualsOfsubAccount(accountid, start, end);
			
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.newDocument();
			
			Element account = doc.createElement("account");
			//生成期初余额子节点
			Element first_accrual = doc.createElement("accrual");
			Element first_id = doc.createElement("id");
			Element first_occurdate = doc.createElement("occurdate");
			Element first_number = doc.createElement("number");
			Element first_summary = doc.createElement("summary");
			Element first_jie = doc.createElement("jie");
			Element first_dai = doc.createElement("dai");
			Element first_direction = doc.createElement("direction");
			Element first_balance= doc.createElement("balance");
			
			first_id.appendChild(doc.createTextNode(""));
			first_occurdate.appendChild(doc.createTextNode(""));
			first_number.appendChild(doc.createTextNode(""));
			first_summary.appendChild(doc.createTextNode("期初余额"));
			first_jie.appendChild(doc.createTextNode(""));
			first_dai.appendChild(doc.createTextNode(""));
			first_direction.appendChild(doc.createTextNode("借"));
			first_balance.appendChild(doc.createTextNode(initBalance));
			
			first_accrual.appendChild(first_occurdate);
			first_accrual.appendChild(first_number);
			first_accrual.appendChild(first_summary);
			first_accrual.appendChild(first_jie);
			first_accrual.appendChild(first_dai);
			first_accrual.appendChild(first_direction);
			first_accrual.appendChild(first_balance);
			
			//增加XML下第一个子元素（期初余额）
			account.appendChild(first_accrual);
			Iterator<Accrual> iter = accruals.iterator();
			BigDecimal big_balance = new BigDecimal(initBalance); //保存余额
			int n = 0; //用于存储编号
			int m = -1; //用于存储月份
			BigDecimal subtotalJie = new BigDecimal("0.00");	//保存小计
			BigDecimal subtotalDai = new BigDecimal("0.00");	//保存小计
			BigDecimal totalJie = new BigDecimal("0.00");	//保存累计
			BigDecimal totalDai = new BigDecimal("0.00");	//保存累计
			while(iter.hasNext()){
				Accrual temp = null;
				temp = iter.next();
				Element accrual = doc.createElement("accrual");
				Element id = doc.createElement("id");
				Element occurdate = doc.createElement("occurdate");
				Element number = doc.createElement("number");
				Element summary = doc.createElement("summary");
				Element jie = doc.createElement("jie");
				Element dai = doc.createElement("dai");
				Element direction = doc.createElement("direction");
				Element balance= doc.createElement("balance");
				
				id.appendChild(doc.createTextNode(temp.getAccountdetailid()+""));
				
				
				Date d = temp.getOccurdate();
				occurdate.appendChild(doc.createTextNode(d.toString()));
				int month = d.getMonth();
				if(month != m){
					//初始化编号
					n = 0;
					
					//小计
					Element sub_accrual = doc.createElement("accrual");
					Element sub_id = doc.createElement("id");
					Element sub_occurdate = doc.createElement("occurdate");
					Element sub_number = doc.createElement("number");
					Element sub_summary = doc.createElement("summary");
					Element sub_jie = doc.createElement("jie");
					Element sub_dai = doc.createElement("dai");
					Element sub_direction = doc.createElement("direction");
					Element sub_balance= doc.createElement("balance");
					
					sub_id.appendChild(doc.createTextNode(""));
					sub_occurdate.appendChild(doc.createTextNode(""));
					sub_number.appendChild(doc.createTextNode(""));
					sub_summary.appendChild(doc.createTextNode("小计"));
					sub_jie.appendChild(doc.createTextNode(subtotalJie.toString()));
					sub_dai.appendChild(doc.createTextNode(subtotalDai.toString()));
					sub_balance.appendChild(doc.createTextNode(""));
					
					sub_accrual.appendChild(sub_id);
					sub_accrual.appendChild(sub_occurdate);
					sub_accrual.appendChild(sub_number);
					sub_accrual.appendChild(sub_summary);
					sub_accrual.appendChild(sub_jie);
					sub_accrual.appendChild(sub_dai);
					sub_accrual.appendChild(sub_direction);
					sub_accrual.appendChild(sub_balance);
					
					account.appendChild(sub_accrual);
					//累计
					//累加总计
					totalJie = totalJie.add(subtotalJie);
					totalDai = totalDai.add(subtotalDai);
					
					Element total_accrual = doc.createElement("accrual");
					Element total_id = doc.createElement("id");
					Element total_occurdate = doc.createElement("occurdate");
					Element total_number = doc.createElement("number");
					Element total_summary = doc.createElement("summary");
					Element total_jie = doc.createElement("jie");
					Element total_dai = doc.createElement("dai");
					Element total_direction = doc.createElement("direction");
					Element total_balance= doc.createElement("balance");
					
					total_id.appendChild(doc.createTextNode(""));
					total_occurdate.appendChild(doc.createTextNode(""));
					total_number.appendChild(doc.createTextNode(""));
					total_summary.appendChild(doc.createTextNode("累计"));
					total_jie.appendChild(doc.createTextNode(totalJie.toString()));
					total_dai.appendChild(doc.createTextNode(totalDai.toString()));
					total_balance.appendChild(doc.createTextNode(""));
					
					total_accrual.appendChild(total_id);
					total_accrual.appendChild(total_occurdate);
					total_accrual.appendChild(total_number);
					total_accrual.appendChild(total_summary);
					total_accrual.appendChild(total_jie);
					total_accrual.appendChild(total_dai);
					total_accrual.appendChild(total_direction);
					total_accrual.appendChild(total_balance);
					
					account.appendChild(total_accrual);
					
					subtotalJie = subtotalJie.abs().subtract(subtotalJie.abs()); //一个数的绝对值减己身的绝对值为0
					subtotalDai = subtotalDai.abs().subtract(subtotalDai.abs()); //一个数的绝对值减己身的绝对值为0
				}
				number.appendChild(doc.createTextNode(++n+""));
				
				summary.appendChild(doc.createTextNode(temp.getSummary()));
				
				
				
				//生成本期发生额并计算余额
				BigDecimal a = new BigDecimal(temp.getAmount());
				
				
				if(temp.getDirection()==0){
					jie.appendChild(doc.createTextNode(temp.getAmount()));
					dai.appendChild(doc.createTextNode(""));
					big_balance = big_balance.add(a);
					balance.appendChild(doc.createTextNode(big_balance.toString()));
					
					//累加小计
					subtotalJie = subtotalJie.add(new BigDecimal(temp.getAmount()));
				}else{
					dai.appendChild(doc.createTextNode(temp.getAmount()));
					jie.appendChild(doc.createTextNode(""));
					big_balance = big_balance.subtract(a);
					balance.appendChild(doc.createTextNode(big_balance.toString()));
					
					subtotalDai = subtotalDai.add(new BigDecimal(temp.getAmount()));
				}
				
				//计算期末余额方向,如果等于这个数的绝对值方向为借
				if(big_balance.toString().equals(big_balance.abs().toString())){
					direction.appendChild(doc.createTextNode("借"));
				}else{
					direction.appendChild(doc.createTextNode("贷"));
				}
				
				accrual.appendChild(occurdate);
				accrual.appendChild(number);
				accrual.appendChild(summary);
				accrual.appendChild(jie);
				accrual.appendChild(dai);
				accrual.appendChild(direction);
				accrual.appendChild(balance);
				
				account.appendChild(accrual);
				
				m = month;
			}
			
			
			//增加最后一个月份的小计及累计
			//小计
			Element sub_accrual = doc.createElement("accrual");
			Element sub_id = doc.createElement("id");
			Element sub_occurdate = doc.createElement("occurdate");
			Element sub_number = doc.createElement("number");
			Element sub_summary = doc.createElement("summary");
			Element sub_jie = doc.createElement("jie");
			Element sub_dai = doc.createElement("dai");
			Element sub_direction = doc.createElement("direction");
			Element sub_balance= doc.createElement("balance");
			
			sub_id.appendChild(doc.createTextNode(""));
			sub_occurdate.appendChild(doc.createTextNode(""));
			sub_number.appendChild(doc.createTextNode(""));
			sub_summary.appendChild(doc.createTextNode("小计"));
			sub_jie.appendChild(doc.createTextNode(subtotalJie.toString()));
			sub_dai.appendChild(doc.createTextNode(subtotalDai.toString()));
			sub_balance.appendChild(doc.createTextNode(""));
			
			sub_accrual.appendChild(sub_id);
			sub_accrual.appendChild(sub_occurdate);
			sub_accrual.appendChild(sub_number);
			sub_accrual.appendChild(sub_summary);
			sub_accrual.appendChild(sub_jie);
			sub_accrual.appendChild(sub_dai);
			sub_accrual.appendChild(sub_direction);
			sub_accrual.appendChild(sub_balance);
			
			account.appendChild(sub_accrual);
			//累计
			//累加总计
			totalJie = totalJie.add(subtotalJie);
			totalDai = totalDai.add(subtotalDai);
			
			Element total_accrual = doc.createElement("accrual");
			Element total_id = doc.createElement("id");
			Element total_occurdate = doc.createElement("occurdate");
			Element total_number = doc.createElement("number");
			Element total_summary = doc.createElement("summary");
			Element total_jie = doc.createElement("jie");
			Element total_dai = doc.createElement("dai");
			Element total_direction = doc.createElement("direction");
			Element total_balance= doc.createElement("balance");
			
			total_id.appendChild(doc.createTextNode(""));
			total_occurdate.appendChild(doc.createTextNode(""));
			total_number.appendChild(doc.createTextNode(""));
			total_summary.appendChild(doc.createTextNode("累计"));
			total_jie.appendChild(doc.createTextNode(totalJie.toString()));
			total_dai.appendChild(doc.createTextNode(totalDai.toString()));
			total_balance.appendChild(doc.createTextNode(""));
			
			total_accrual.appendChild(total_id);
			total_accrual.appendChild(total_occurdate);
			total_accrual.appendChild(total_number);
			total_accrual.appendChild(total_summary);
			total_accrual.appendChild(total_jie);
			total_accrual.appendChild(total_dai);
			total_accrual.appendChild(total_direction);
			total_accrual.appendChild(total_balance);
			
			account.appendChild(total_accrual);
			
			
			doc.appendChild(account);
			
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer t = tf.newTransformer();
			t.setOutputProperty(OutputKeys.ENCODING, "gbk");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(xml);
			t.transform(source, result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return xml;
	}
}

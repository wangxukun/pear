package wxk.bank.json.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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
			ja.add(first);
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
				if(accrual.getDirection()==0){
					o.accumulate("jie",accrual.getAmount());
					o.accumulate("dai",0);
				}else{
					o.accumulate("dai",accrual.getAmount());
					o.accumulate("jie",0);
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
}

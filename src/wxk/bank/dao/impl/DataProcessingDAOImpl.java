package wxk.bank.dao.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import wxk.bank.dao.DataProcessingDAO;
import wxk.bank.entity.Accrual;
import wxk.bank.entity.InitAccount;
import wxk.bank.jdbc.JdbcUtils;

public class DataProcessingDAOImpl implements DataProcessingDAO {
	private JdbcUtils jdbc;
	
	public DataProcessingDAOImpl(JdbcUtils jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public InitAccount getInitAccountByAccountId(int accountid) throws SQLException {
		InitAccount initAccount = new InitAccount();
		String sql = "select accountid,initdate,summary,direction,amount from initaccount where accountid=?";
		List<Object> params = new ArrayList<Object>();
		params.add(accountid);
		Map<String,Object> map = this.jdbc.findSingleByPreparedStatement(sql, params);
		if(!map.isEmpty()){
			initAccount.setAccountid(Integer.parseInt(map.get("accountid").toString()));
			initAccount.setInitdate((Date)map.get("initdate"));
			initAccount.setSummary(map.get("summary").toString());
			initAccount.setDirection(Integer.parseInt(map.get("direction").toString()));
			initAccount.setAmount(map.get("amount").toString());
		}
		
		return initAccount;
	}

	@Override
	public List<Accrual> getAccrualsByAccountId(int accountid,Date start,Date end) throws SQLException {
		List<Accrual> accruals = new ArrayList<Accrual>();
		String sql = "select accountdetailid,occurdate,number,summary,direction,amount,accountid,groupid,freeze,updatetime from accrual where groupid=? and occurdate>=? and occurdate<=? order by occurdate asc";
		List<Object> params = new ArrayList<Object>();
		params.add(accountid);
		params.add(start);
		params.add(end);
		List<Map<String,Object>> list = this.jdbc.findMoreByPreparedStatement(sql, params);
		Iterator<Map<String,Object>> iter = list.iterator();
		while(iter.hasNext()){
			Map<String,Object> map;
			map = iter.next();
			Accrual accrual = new Accrual();
			accrual.setAccountdetailid(Integer.parseInt(map.get("accountdetailid").toString()));
			accrual.setOccurdate((Date)map.get("occurdate"));
			accrual.setNumber(Integer.parseInt(map.get("number").toString()));
			accrual.setSummary(map.get("summary").toString());
			accrual.setDirection(Integer.parseInt(map.get("direction").toString()));
			accrual.setAmount(map.get("amount").toString());
			accrual.setAccountid(Integer.parseInt(map.get("accountid").toString()));
			accrual.setGroupid(Integer.parseInt(map.get("groupid").toString()));
			accrual.setFreeze(Integer.parseInt(map.get("freeze").toString()));
			accrual.setEnterdate((Date)map.get("updatetime"));
			
			accruals.add(accrual);
		}
		return accruals;
	}

	@Override
	public String getInitAmount(int accountid,Date end) throws SQLException {
		String amount = null;
		String sql = "select amount,direction from initaccount where accountid=? and initdate <= ?";
		List<Object> params = new ArrayList<Object>();
		params.add(accountid);
		params.add(end);
		Map<String,Object> map = this.jdbc.findSingleByPreparedStatement(sql, params);
		if(!map.isEmpty()){
			amount = map.get("amount").toString();
			int d = Integer.parseInt(map.get("direction").toString());
			if(d != 0){
				BigDecimal a = new BigDecimal(amount);
				//取相反数
				amount = a.negate().toString();
			}
		}
		return amount;
	}

	@Override
	public String getJieSum(int accountid, Date before) throws SQLException {
		String amount = null;
		String sql = "select sum(amount) as jie from accrual where groupid=? and direction=0 and occurdate<?";
		List<Object> params = new ArrayList<Object>();
		params.add(accountid);
		params.add(before);
		Map<String,Object> map = this.jdbc.findSingleByPreparedStatement(sql, params);
		if(!map.isEmpty()){
			amount = map.get("jie").toString();
		}
		return amount;
	}

	@Override
	public String getDaiSum(int accountid, Date before) throws SQLException {
		String amount = null;
		String sql = "select sum(amount) as dai from accrual where groupid=? and direction=1 and occurdate<?";
		List<Object> params = new ArrayList<Object>();
		params.add(accountid);
		params.add(before);
		Map<String,Object> map = this.jdbc.findSingleByPreparedStatement(sql, params);
		if(!map.isEmpty()){
			amount = map.get("dai").toString();
		}
		return amount;
	}

}

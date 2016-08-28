package wxk.bank.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import wxk.bank.dao.AccountManagementDAO;
import wxk.bank.entity.Account;
import wxk.bank.jdbc.JdbcUtils;

public class AccountManagementDAOImpl implements AccountManagementDAO {
	private JdbcUtils jdbc;
	
	public AccountManagementDAOImpl(JdbcUtils jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public boolean createAccount(Account account) throws SQLException {
		boolean flag = false;
		String sql = "insert into account(accountname,parentid,responsible,contactphone) values(?,?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(account.getAccountname());
		params.add(account.getParentid());
		params.add(account.getResponsible());
		params.add(account.getContactphone());
		flag = this.jdbc.updateByPreparedStatement(sql, params);
		return flag;
	}

	@Override
	public Set<Account> getAccounts() throws SQLException {
		Set<Account> accounts = new TreeSet<Account>();
		String sql = "select accountid,accountname,parentid,responsible,contactphone from account";
		List<Map<String, Object>> list = this.jdbc.findMoreByPreparedStatement(sql, null);
		if(!list.isEmpty()){
			Iterator<Map<String,Object>> iter = list.iterator();
			while(iter.hasNext()){
				Map<String,Object> map = null;
				map = iter.next();
				Account account = new Account();
				account.setAccountid(Integer.parseInt(map.get("accountid").toString()));
				account.setParentid(Integer.parseInt(map.get("parentid").toString()));
				account.setAccountname(map.get("accountname").toString());
				account.setResponsible(map.get("responsible").toString());
				account.setContactphone(map.get("contactphone").toString());
				
				accounts.add(account);
			}
		}else{
			accounts = null;
		}
		return accounts;
	}

	@Override
	public Account getAccountByAccountid(int accountid) throws SQLException {
		Account account = new Account();
		String sql = "select accountid,accountname,parentid,responsible,contactphone from account where accountid=?";
		List<Object> params = new ArrayList<Object>();
		params.add(accountid);
		Map<String,Object> map = this.jdbc.findSingleByPreparedStatement(sql, params);
		if(!map.isEmpty()){
			account.setAccountid(accountid);
			account.setAccountname(map.get("accountname").toString());
			account.setContactphone(map.get("contactphone").toString());
			account.setParentid(Integer.parseInt(map.get("parentid").toString()));
			account.setResponsible(map.get("responsible").toString());
		}else{
			account = null;
		}
		return account;
	}

}

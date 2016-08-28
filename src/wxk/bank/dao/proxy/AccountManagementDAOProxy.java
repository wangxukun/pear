package wxk.bank.dao.proxy;

import java.sql.SQLException;
import java.util.Set;

import wxk.bank.dao.AccountManagementDAO;
import wxk.bank.dao.impl.AccountManagementDAOImpl;
import wxk.bank.entity.Account;
import wxk.bank.jdbc.JdbcUtils;

public class AccountManagementDAOProxy implements AccountManagementDAO {
	private JdbcUtils jdbc;
	private AccountManagementDAO dao;
	
	public AccountManagementDAOProxy() {
		this.jdbc = new JdbcUtils();
		this.dao = new AccountManagementDAOImpl(this.jdbc);
	}

	@Override
	public boolean createAccount(Account account) throws SQLException {
		boolean flag = false;
		try {
			this.jdbc.getConnection();
			flag = this.dao.createAccount(account);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			this.jdbc.releaseConnection();
		}
		return flag;
	}

	@Override
	public Set<Account> getAccounts() throws SQLException {
		Set<Account> accounts = null;
		try{
			this.jdbc.getConnection();
			accounts = this.dao.getAccounts();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.jdbc.releaseConnection();
		}
		return accounts;
	}

	@Override
	public Account getAccountByAccountid(int accountid) throws SQLException {
		Account account = null;
		try {
			this.jdbc.getConnection();
			account = this.dao.getAccountByAccountid(accountid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			this.jdbc.releaseConnection();
		}
		return account;
	}

}

package wxk.bank.service.impl;

import java.sql.SQLException;
import java.util.Set;

import wxk.bank.dao.factory.DAOFactory;
import wxk.bank.entity.Account;
import wxk.bank.service.AccountManagementService;

public class AccountManagementServiceImpl implements AccountManagementService {

	@Override
	public boolean create(Account account) throws SQLException {
		boolean flag = false;
		flag = DAOFactory.getAccountManagementDAOInstance().createAccount(account);
		return flag;
	}

	@Override
	public Set<Account> getAll() throws SQLException {
		Set<Account> accounts = null;
		accounts = DAOFactory.getAccountManagementDAOInstance().getAccounts();
		return accounts;
	}

	@Override
	public Account getAccountByAccountid(int accountid) throws SQLException {
		Account account = null;
		account = DAOFactory.getAccountManagementDAOInstance().getAccountByAccountid(accountid);
		return account;
	}

}

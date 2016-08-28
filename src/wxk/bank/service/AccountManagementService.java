package wxk.bank.service;

import java.sql.SQLException;
import java.util.Set;

import wxk.bank.entity.Account;

public interface AccountManagementService {
	/**
	 * 创建账户
	 * @param account
	 * @return
	 * @throws SQLException
	 */
	boolean create(Account account) throws SQLException;
	
	/**
	 * 取得所有账户
	 * @return
	 * @throws SQLException
	 */
	Set<Account> getAll() throws SQLException;
	
	/**
	 * 取得指定ID的账户
	 * @param accountid
	 * @return
	 */
	Account getAccountByAccountid(int accountid) throws SQLException ;
}

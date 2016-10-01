package wxk.bank.dao;

import java.sql.SQLException;
import java.util.Set;

import wxk.bank.entity.Account;

public interface AccountManagementDAO {
	/**
	 * 创建账户
	 * @param account
	 * @return
	 * @throws SQLException
	 */
	boolean createAccount(Account account) throws SQLException;
	
	/**
	 * 取得所有账户
	 * @return
	 * @throws SQLException
	 */
	Set<Account> getAccounts() throws SQLException;
}

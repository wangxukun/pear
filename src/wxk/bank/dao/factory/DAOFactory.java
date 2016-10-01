/**
 * 
 */
package wxk.bank.dao.factory;

import wxk.bank.dao.AccountManagementDAO;
import wxk.bank.dao.SysmgrDAO;
import wxk.bank.dao.UserManagementDAO;
import wxk.bank.dao.proxy.AccountManagementDAOProxy;
import wxk.bank.dao.proxy.SysmgrDAOProxy;
import wxk.bank.dao.proxy.UserManagementDAOProxy;

/**
 * @author Administrator
 *
 */
public class DAOFactory {
	/**
	 * 用户管理
	 * @return
	 */
	static public UserManagementDAO getUserManagementDAOInstance(){
		return new UserManagementDAOProxy();
	}
	/**
	 * 系统管理
	 * @return
	 */
	static public SysmgrDAO getSysmgrDAOInstance(){
		return new SysmgrDAOProxy();
	}
	/**
	 * 账户管理
	 * @return
	 */
	static public AccountManagementDAO getAccountManagementDAOInstance(){
		return new AccountManagementDAOProxy();
	}
}

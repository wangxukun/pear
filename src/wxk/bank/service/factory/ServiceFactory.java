/**
 * 
 */
package wxk.bank.service.factory;

import wxk.bank.service.AccountManagementService;
import wxk.bank.service.DataProcessingService;
import wxk.bank.service.SysmgrService;
import wxk.bank.service.UserManagementService;
import wxk.bank.service.impl.AccountManagementServiceImpl;
import wxk.bank.service.impl.DataProcessingServiceImpl;
import wxk.bank.service.impl.SysmgrServiceImpl;
import wxk.bank.service.impl.UserManagementServiceImpl;

/**
 * @author Administrator
 *
 */
public class ServiceFactory {
	public static UserManagementService getUserManagementServiceInstance(){
		return new UserManagementServiceImpl();
	}
	public static SysmgrService getSysmgrServiceInstance(){
		return new SysmgrServiceImpl();
	}
	public static AccountManagementService getAccountManagementServiceInstance(){
		return new AccountManagementServiceImpl();
	}
	public static DataProcessingService getDataProcessingServiceInstance(){
		return new DataProcessingServiceImpl();
	}
}

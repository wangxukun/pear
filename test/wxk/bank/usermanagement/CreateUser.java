package wxk.bank.usermanagement;

import java.sql.SQLException;

import wxk.bank.entity.User;
import wxk.bank.service.factory.ServiceFactory;

public class CreateUser {

	public static void main(String[] args) {
		User user = new User();
		user.setUsername("wangxukun");
		user.setFullname("王旭昆");
		user.setPassword("wxlwxk");
		user.setContactphone("15912006301");
		user.setEmail("wangxukun@yahoo.com");
		user.setOrganization("三岔河经管站");
		user.setUserscope(0);
		user.setUserstate(1);
		user.setUsertype(1);
		boolean flag = false;
		
		try {
			flag = ServiceFactory.getUserManagementServiceInstance().create(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(flag){
			System.out.println("success");
		}else{
			System.out.println("failed");
		}
	}

}

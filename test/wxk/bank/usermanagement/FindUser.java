package wxk.bank.usermanagement;

import java.sql.SQLException;
import java.util.List;


import wxk.bank.dao.factory.DAOFactory;
import wxk.bank.entity.User;

public class FindUser {

	public static void main(String[] args) {
		List<User> users = null;
		
		try {
			users = DAOFactory.getUserManagementDAOInstance().findUsers();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(users != null){
			System.out.println(users);
		}else{
			System.out.println("不存在或出错！");
		}
	}

}

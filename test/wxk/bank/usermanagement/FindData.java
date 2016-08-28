package wxk.bank.usermanagement;

import java.sql.SQLException;


import wxk.bank.dao.factory.DAOFactory;
import wxk.bank.entity.InitAccount;

public class FindData {

	public static void main(String[] args) {
		InitAccount initAccount= null;
		
		try {
			initAccount = DAOFactory.getDataProcessingDAOInstance().getInitAccountByAccountId(21);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(initAccount != null){
			System.out.println(initAccount);
		}else{
			System.out.println("不存在或出错！");
		}
	}

}

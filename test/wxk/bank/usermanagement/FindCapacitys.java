package wxk.bank.usermanagement;

import java.sql.SQLException;
import java.util.Set;

import wxk.bank.entity.Account;
import wxk.bank.service.factory.ServiceFactory;

public class FindCapacitys {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Account> capacitys = null;
		try {
			capacitys = ServiceFactory.getAccountManagementServiceInstance().getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(capacitys.toString());
	}

}

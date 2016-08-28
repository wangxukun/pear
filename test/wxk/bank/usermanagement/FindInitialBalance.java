package wxk.bank.usermanagement;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import wxk.bank.service.factory.ServiceFactory;

public class FindInitialBalance {

	public static void main(String[] args) {
		String initBalance = null;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd",Locale.CHINESE);
		Date start = null;
		try {
			start = dateFormat.parse("2014-01-09");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Date end = null;
		try {
			end = dateFormat.parse("2014-12-31");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			initBalance = ServiceFactory.getDataProcessingServiceInstance().getInitialBalance(21, end, start);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(initBalance != null){
			System.out.println(initBalance);
		}else{
			System.out.println("不存在或出错！");
		}
	}

}

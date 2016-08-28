package wxk.bank.usermanagement;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import wxk.bank.dao.factory.DAOFactory;

public class FindInitAmount {

	public static void main(String[] args) {
		String amount= null;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd",Locale.CHINESE);
		Date end = null;
		try {
			end = dateFormat.parse("2014-01-31");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			amount = DAOFactory.getDataProcessingDAOInstance().getInitAmount(21, end);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(amount != null){
			System.out.println(amount);
		}else{
			System.out.println("不存在或出错！");
		}
	}

}

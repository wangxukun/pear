package wxk.bank.usermanagement;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import wxk.bank.dao.factory.DAOFactory;

public class FindJieSum {

	public static void main(String[] args) {
		String amount= null;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd",Locale.CHINESE);
		Date before = null;
		try {
			before = dateFormat.parse("2015-01-31");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			amount = DAOFactory.getDataProcessingDAOInstance().getJieSum(21, before);
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

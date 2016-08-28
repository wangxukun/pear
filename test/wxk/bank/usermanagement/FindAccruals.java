package wxk.bank.usermanagement;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import wxk.bank.dao.factory.DAOFactory;
import wxk.bank.entity.Accrual;

public class FindAccruals {

	public static void main(String[] args) {
		List<Accrual> accruals = null;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd",Locale.CHINESE);
		Date start = null;
		try {
			start = dateFormat.parse("2014-01-01");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Date end = null;
		try {
			end = dateFormat.parse("2014-01-31");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			accruals = DAOFactory.getDataProcessingDAOInstance().getAccrualsByAccountId(21,start,end);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(accruals != null){
			System.out.println(accruals);
		}else{
			System.out.println("不存在或出错！");
		}
	}

}

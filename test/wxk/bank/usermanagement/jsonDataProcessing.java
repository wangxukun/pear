package wxk.bank.usermanagement;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import net.sf.json.JSONObject;
import wxk.bank.json.factory.JsonFactory;

public class jsonDataProcessing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JSONObject ja = null;
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
		ja = JsonFactory.getJsonDataProcessInstance().getAccountDetail(21, start, end);
		System.out.println(ja);
	}

}

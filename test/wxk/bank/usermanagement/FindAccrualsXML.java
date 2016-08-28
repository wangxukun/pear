package wxk.bank.usermanagement;

import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import wxk.bank.json.factory.JsonFactory;

public class FindAccrualsXML {

	public static void main(String[] args) {
		ByteArrayOutputStream xml = null;
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
			xml = JsonFactory.getJsonDataProcessInstance().getAccountDetailXML(21, start, end);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(xml != null){
			System.out.println(xml);
		}else{
			System.out.println("不存在或出错！");
		}
	}

}

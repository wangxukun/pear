package wxk.bank.usermanagement;

import net.sf.json.JSONObject;
import wxk.bank.json.factory.JsonFactory;

public class JsonCapacitys {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JSONObject jo = null;
		jo = JsonFactory.getJsonSysmgrInstance().getTopFunction();
		
		System.out.println(jo.toString());
	}

}

package wxk.bank.usermanagement;

import net.sf.json.JSONObject;
import wxk.bank.json.factory.JsonFactory;

public class JsonUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JSONObject ja = null;
		ja = JsonFactory.getJsonUserManageInstance().getUsers();
		System.out.println(ja);
	}

}

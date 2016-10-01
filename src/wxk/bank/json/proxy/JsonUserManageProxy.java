package wxk.bank.json.proxy;

import net.sf.json.JSONObject;
import wxk.bank.json.JsonUserManage;
import wxk.bank.json.impl.JsonUserManageImpl;

public class JsonUserManageProxy implements JsonUserManage {
	JsonUserManage dao;
	public JsonUserManageProxy(){
		this.dao = new JsonUserManageImpl();
	}
	@Override
	public JSONObject getUsers() {
		// TODO Auto-generated method stub
		return this.dao.getUsers();
	}
	@Override
	public JSONObject getLoginUser(String username, String password) {
		// TODO Auto-generated method stub
		return this.dao.getLoginUser(username, password);
	}

}

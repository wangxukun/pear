package wxk.bank.json.proxy;

import net.sf.json.JSONObject;
import wxk.bank.json.JsonAccountManage;
import wxk.bank.json.impl.JsonAccountManageImpl;

public class JsonAccountManageProxy implements JsonAccountManage {

	private JsonAccountManage dao;
	public JsonAccountManageProxy(){
		this.dao = new JsonAccountManageImpl();
	}
	@Override
	public JSONObject getAccountTree(int parentid) {
		// TODO Auto-generated method stub
		return this.dao.getAccountTree(parentid);
	}

}

package wxk.bank.json.proxy;

import net.sf.json.JSONObject;
import wxk.bank.json.JsonSysmgr;
import wxk.bank.json.impl.JsonSysmgrImpl;

public class JsonSysmgrProxy implements JsonSysmgr{
	JsonSysmgr dao;
	public JsonSysmgrProxy(){
		this.dao = new JsonSysmgrImpl();
	}
	@Override
	public JSONObject getTopFunction() {
		JSONObject jo = null;
		jo = this.dao.getTopFunction();
		return jo;
	}
	@Override
	public JSONObject getMenuItems(int parentid) {
		JSONObject jo = null;
		jo = this.dao.getMenuItems(parentid);
		return jo;
	}
	@Override
	public JSONObject getNavTree(int parentid) {
		// TODO Auto-generated method stub
		return this.dao.getNavTree(parentid);
	}
}

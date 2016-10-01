package wxk.bank.json.factory;

import wxk.bank.json.JsonAccountManage;
import wxk.bank.json.JsonSysmgr;
import wxk.bank.json.JsonUserManage;
import wxk.bank.json.proxy.JsonAccountManageProxy;
import wxk.bank.json.proxy.JsonSysmgrProxy;
import wxk.bank.json.proxy.JsonUserManageProxy;

public class JsonFactory {
	static public JsonUserManage getJsonUserManageInstance(){
		return new JsonUserManageProxy();
	}
	static public JsonSysmgr getJsonSysmgrInstance(){
		return new JsonSysmgrProxy();
	}
	static public JsonAccountManage getJsonAccountManageInstaqnce(){
		return new JsonAccountManageProxy();
	}
}

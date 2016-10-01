package wxk.bank.json.impl;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import wxk.bank.entity.Account;
import wxk.bank.json.JsonAccountManage;
import wxk.bank.service.factory.ServiceFactory;

public class JsonAccountManageImpl implements JsonAccountManage {

	@Override
	public JSONObject getAccountTree(int parentid) {
		JSONObject o = new JSONObject();
		JSONArray ja = new JSONArray();
		Set<Account> accounts = null;
		try {
			accounts = ServiceFactory.getAccountManagementServiceInstance().getAll();
			if(!accounts.isEmpty()){
				Iterator<Account> iter = accounts.iterator();
				while(iter.hasNext()){
					Account temp = null;
					temp = iter.next();
					if(temp.getParentid() == parentid){
						JSONObject jo = new JSONObject();
						jo.accumulate("id", temp.getAccountid());
						jo.accumulate("text", temp.getAccountname());
						if(isLeaf(accounts,temp.getAccountid())){
							jo.accumulate("leaf", true);
						}else{
							jo.accumulate("leaf", false);
						}
						jo.accumulate("parentid", temp.getParentid());
						jo.accumulate("responsible", temp.getResponsible());
						jo.accumulate("contactphone",temp.getContactphone());
						ja.add(jo);
					}
				}
				o.accumulate("accounttree", ja);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}
	
	/**
	 * 指定accountid的账户在accounts集合中是否是叶子节点
	 * @param accounts
	 * @param accountid
	 * @return
	 */
	public boolean isLeaf(Set<Account> accounts,int accountid){
		boolean flag = true;
		if(!accounts.isEmpty()){
			Iterator<Account> iter = accounts.iterator();
			while(iter.hasNext()){
				Account temp = null;
				temp = iter.next();
				if(temp.getParentid() == accountid){
					flag = false;
					break;
				}
			}
		}
		return flag;
	}
}


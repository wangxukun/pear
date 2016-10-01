package wxk.bank.json.impl;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import wxk.bank.entity.User;
import wxk.bank.json.JsonUserManage;
import wxk.bank.service.factory.ServiceFactory;

public class JsonUserManageImpl implements JsonUserManage {

	@Override
	public JSONObject getUsers() {
		JSONObject jo = new JSONObject();
		JSONArray ja = new JSONArray();
		List<User> users = null;
		try {
			users = ServiceFactory.getUserManagementServiceInstance().find();
			Iterator<User> iter = users.iterator();
			while(iter.hasNext()){
				User user = null;
				user = iter.next();
				JSONObject o = new JSONObject();
				o.accumulate("id", user.getUserid());
				o.accumulate("username", user.getUsername());
				o.accumulate("fullname", user.getFullname());
		//		o.accumulate("password", user.getPassword());
				o.accumulate("contactphone", user.getContactphone());
				o.accumulate("email", user.getEmail());
				o.accumulate("organization", user.getOrganization());
				o.accumulate("usertype", user.getUsertype());
				o.accumulate("userstate", user.getUserstate());
				o.accumulate("creationdate", user.getCreationdate().toString());
				o.accumulate("updateddate", user.getUpdateddate().toString());
				ja.add(o);
			}
			jo.accumulate("users", ja);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jo;
	}

	@Override
	public JSONObject getLoginUser(String username, String password) {
		JSONObject jo = new JSONObject();
		JSONObject o = new JSONObject();
		User user = null;
		try {
			user = ServiceFactory.getUserManagementServiceInstance().find(username, password);
			
			o.accumulate("userid", user.getUserid());
			o.accumulate("username", user.getUsername());
			o.accumulate("fullname", user.getFullname());
			o.accumulate("password", user.getPassword());
			o.accumulate("contactphone", user.getContactphone());
			o.accumulate("email", user.getEmail());
			o.accumulate("organization", user.getOrganization());
			o.accumulate("usertype", user.getUsertype());
			o.accumulate("userstate", user.getUserstate());
			o.accumulate("creationdate", user.getCreationdate());
			o.accumulate("updateddate", user.getUpdateddate());
			
			jo.accumulate("user", o);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jo;
	}
}

package wxk.bank.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import wxk.bank.dao.UserManagementDAO;
import wxk.bank.entity.User;
import wxk.bank.jdbc.JdbcUtils;

public class UserManagementDAOImpl implements UserManagementDAO {
	private JdbcUtils jdbc;
	public UserManagementDAOImpl(JdbcUtils jdbc){
		this.jdbc = jdbc;
	}
	@Override
	public boolean createUser(User user) throws SQLException {
		boolean flag = false;
		String sql = "insert into user(username,fullname,password,contactphone,email,organization,usertype,userstate,userscope) values(?,?,MD5(?),?,?,?,?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(user.getUsername());
		params.add(user.getFullname());
		params.add(user.getPassword());
		params.add(user.getContactphone());
		params.add(user.getEmail());
		params.add(user.getOrganization());
		params.add(user.getUsertype());
		params.add(user.getUserstate());
		params.add(user.getUserscope());
		flag = this.jdbc.updateByPreparedStatement(sql, params);
		return flag;
	}
	@Override
	public User findUser(String username, String password) throws SQLException {
		User user = new User();
		String sql = "select userid,username,fullname,password,contactphone,email,organization,usertype,userstate,userscope,creationdate,updateddate from user where username=? and password=MD5(?)";
		List<Object> params = new ArrayList<Object>();
		params.add(username);
		params.add(password);
		Map<String,Object> map = this.jdbc.findSingleByPreparedStatement(sql, params);
		if(!map.isEmpty()){
			user.setUserid(Integer.parseInt(map.get("userid").toString()));
			user.setUsername(map.get("username").toString());
			user.setFullname(map.get("fullname").toString());
			user.setPassword(map.get("password").toString());
			user.setContactphone(map.get("contactphone").toString());
			user.setEmail(map.get("email").toString());
			user.setOrganization(map.get("organization").toString());
			user.setUsertype(Integer.parseInt(map.get("usertype").toString()));
			user.setUserstate(Integer.parseInt(map.get("userstate").toString()));
			user.setUserscope(Integer.parseInt(map.get("userscope").toString()));
			user.setCreationdate((Date)map.get("creationdate"));
			user.setUpdateddate((Date)map.get("updateddate"));
			return user;
		}else{
			return null;
		}
	}
	@Override
	public boolean findUser(String username) throws SQLException {
		boolean flag = false;
		String sql = "select userid from user where username=?";
		List<Object> params = new ArrayList<Object>();
		params.add(username);
		Map<String,Object> map = this.jdbc.findSingleByPreparedStatement(sql, params);
		if(!map.isEmpty()){
			flag = true;
		}
		return flag;
	}
	@Override
	public List<User> findUsers() throws SQLException {
		List<User> users = new ArrayList<User>();
		String sql = "select userid,username,fullname,password,contactphone,email,organization,usertype,userstate,userscope,creationdate,updateddate from user";
		List<Map<String, Object>> list = this.jdbc.findMoreByPreparedStatement(sql, null);
		Iterator<Map<String,Object>> iter = list.iterator();
		while(iter.hasNext()){
			Map<String,Object> map = null;
			User user = new User();
			map= iter.next();
			user.setUserid(Integer.parseInt(map.get("userid").toString()));
			user.setUsername(map.get("username").toString());
			user.setFullname(map.get("fullname").toString());
			user.setPassword(map.get("password").toString());
			user.setContactphone(map.get("contactphone").toString());
			user.setEmail(map.get("email").toString());
			user.setOrganization(map.get("organization").toString());
			user.setUsertype(Integer.parseInt(map.get("usertype").toString()));
			user.setUserstate(Integer.parseInt(map.get("userstate").toString()));
			user.setUserscope(Integer.parseInt(map.get("userscope").toString()));
			user.setCreationdate((Date)map.get("creationdate"));
			user.setUpdateddate((Date)map.get("updateddate"));
			users.add(user);
		}
		return users;
	}
	@Override
	public boolean deleteUser(int userid) throws SQLException {
		boolean flag = false;
		String sql = "delete from user where userid=?";
		List<Object> params = new ArrayList<Object>();
		params.add(userid);
		flag = this.jdbc.updateByPreparedStatement(sql, params);
		return flag;
	}

}

package wxk.bank.dao.proxy;

import java.sql.SQLException;
import java.util.List;

import wxk.bank.dao.UserManagementDAO;
import wxk.bank.dao.impl.UserManagementDAOImpl;
import wxk.bank.entity.User;
import wxk.bank.jdbc.JdbcUtils;

public class UserManagementDAOProxy implements UserManagementDAO {
	private JdbcUtils jdbc;
	private UserManagementDAO dao;
	public UserManagementDAOProxy(){
		this.jdbc = new JdbcUtils();
		this.dao = new UserManagementDAOImpl(this.jdbc);
	}
	@Override
	public boolean createUser(User user) throws SQLException {
		boolean flag = false;
		try {
			this.jdbc.getConnection();
			flag = this.dao.createUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			this.jdbc.releaseConnection();
		}
		return flag;
	}
	@Override
	public User findUser(String username, String password) throws SQLException {
		User user = null;
		try {
			this.jdbc.getConnection();
			user = this.dao.findUser(username, password);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			this.jdbc.releaseConnection();
		}
		return user;
	}
	@Override
	public boolean findUser(String username) throws SQLException {
		boolean flag = false;
		try {
			this.jdbc.getConnection();
			flag = this.dao.findUser(username);
		} catch (SQLException e){
			e.printStackTrace();
		}finally {
			this.jdbc.releaseConnection();
		}
		return flag;
	}
	@Override
	public List<User> findUsers() throws SQLException {
		List<User> user = null;
		try {
			this.jdbc.getConnection();
			user = this.dao.findUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.jdbc.releaseConnection();
		}
		return user;
	}
	@Override
	public boolean deleteUser(int userid) throws SQLException {
		boolean flag = false;
		try {
			this.jdbc.getConnection();
			flag = this.dao.deleteUser(userid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			this.jdbc.releaseConnection();
		}
		return flag;
	}
	@Override
	public User findUserByUserid(int userid) throws SQLException {
		// TODO Auto-generated method stub
		User user = null;
		try {
			this.jdbc.getConnection();
			user = this.dao.findUserByUserid(userid);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
			this.jdbc.releaseConnection();
		}
		return user;
	}
}

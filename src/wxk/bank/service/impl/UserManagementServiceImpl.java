package wxk.bank.service.impl;

import java.sql.SQLException;
import java.util.List;

import wxk.bank.dao.factory.DAOFactory;
import wxk.bank.entity.User;
import wxk.bank.service.UserManagementService;

public class UserManagementServiceImpl implements UserManagementService {

	@Override
	public boolean create(User user) throws SQLException {
		boolean flag = false;
		//如果所指定的用户名不存在，则创建此用户
		if(!DAOFactory.getUserManagementDAOInstance().findUser(user.getUsername())){
			flag = DAOFactory.getUserManagementDAOInstance().createUser(user);
		}
		return flag;
	}

	@Override
	public User find(String username, String password) throws SQLException {
		User user = null;
		user = DAOFactory.getUserManagementDAOInstance().findUser(username, password);
		return user;
	}

	@Override
	public List<User> find() throws SQLException {
		List<User> users = null;
		users = DAOFactory.getUserManagementDAOInstance().findUsers();
		return users;
	}

	@Override
	public boolean delete(int userid) throws SQLException {
		boolean flag = false;
		flag = DAOFactory.getUserManagementDAOInstance().deleteUser(userid);
		return flag;
	}

	@Override
	public User find(int userid) throws SQLException {
		User user = null;
		user = DAOFactory.getUserManagementDAOInstance().findUserByUserid(userid);
		return user;
	}

}

/**
 * 
 */
package wxk.bank.service;

import java.sql.SQLException;
import java.util.List;

import wxk.bank.entity.User;

/**
 * @author Administrator
 *
 */
public interface UserManagementService {
	/**
	 * 创建用户
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	boolean create(User user) throws SQLException;
	
	/**
	 * 根据用户名和密码查找并返回用户
	 * @param user
	 * @param password
	 * @return 成功返回对应的用户，失败返回null
	 * @throws SQLException
	 */
	User find(String username, String password) throws SQLException;
	
	/**
	 * 查找出所有用户
	 * @return
	 * @throws SQLException
	 */
	List<User> find() throws SQLException;
	
	/**
	 * 根据用户ID删除用户
	 * @param userid
	 * @return
	 * @throws SQLException
	 */
	boolean delete(int userid) throws SQLException;
}

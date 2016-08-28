/**
 * 
 */
package wxk.bank.dao;

import java.sql.SQLException;
import java.util.List;

import wxk.bank.entity.User;

/**
 * @author Administrator
 *
 */
public interface UserManagementDAO {
	/**
	 * 创建用户
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	boolean createUser(User user) throws SQLException;
	
	/**
	 * 根据用户名和密码查找用户
	 * @param username
	 * @param password
	 * @return	成功返回对应的用户，失败返回null
	 * @throws SQLException
	 */
	User findUser(String username,String password) throws SQLException;
	
	/**
	 * 根据用户名查找用户是否存在
	 * @param username
	 * @return
	 * @throws SQLException
	 */
	boolean findUser(String username) throws SQLException;
	
	/**
	 * 查找出所有用户
	 * @return
	 * @throws SQLException
	 */
	List<User> findUsers() throws SQLException;
	
	/**
	 * 删除指定用户ID的用户
	 * @param userid
	 * @return
	 * @throws SQLException
	 */
	boolean deleteUser(int userid) throws SQLException;
	
	
	User findUserByUserid(int userid) throws SQLException;
}

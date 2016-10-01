/**
 * 
 */
package wxk.bank.dao;

import java.sql.SQLException;
import java.util.Set;

import wxk.bank.entity.Capacity;

/**
 * @author Administrator
 *
 */
public interface SysmgrDAO {
	/**
	 * 增加一个功能菜单
	 * @param capacity
	 * @return
	 * @throws SQLException
	 */
	boolean addCapacity(Capacity capacity) throws SQLException;
	
	/**
	 * 取得所有功能菜单
	 * @return
	 * @throws SQLException
	 */
	Set<Capacity> getCapacitys() throws SQLException;
}

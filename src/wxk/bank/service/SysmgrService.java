package wxk.bank.service;

import java.sql.SQLException;
import java.util.Set;

import wxk.bank.entity.Capacity;

public interface SysmgrService {
	/**
	 * 增加功能菜单
	 * @param capacity 功能菜单实体
	 * @return
	 * @throws SQLException
	 */
	boolean addFunction(Capacity capacity) throws SQLException;
	
	/**
	 * 取得所有功能菜单
	 * @return
	 * @throws SQLException
	 */
	Set<Capacity> findFunctions() throws SQLException;
}

package wxk.bank.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import wxk.bank.entity.Accrual;
import wxk.bank.entity.InitAccount;

public interface DataProcessingDAO {
	/**
	 * 根据账户ID查询账户的初始化数据
	 * @param accountid
	 * @return
	 * @throws SQLException
	 */
	public InitAccount getInitAccountByAccountId(int accountid) throws SQLException;
	
	/**
	 * 根据账户ID，时间段，查询账户下的所有发生额（注：不能跨年度查询）
	 * @param accountid
	 * @param start '2015-01-07'
	 * @param end  '2015-12-12' 	
	 * @return
	 * @throws SQLException
	 */
	public List<Accrual> getAccrualsByAccountId(int accountid,Date start,Date end) throws SQLException;
}

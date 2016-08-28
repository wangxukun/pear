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
	
	/**
	 * 取得特定账户初始化金额
	 * @param accountid
	 * @param end	如果查询的日期在end之前，说明查询的时间段，账户还未初始化
	 * @return
	 * @throws SQLException
	 */
	public String getInitAmount(int accountid,Date end) throws SQLException;
	
	/**
	 * 取得指定账户，特定日期前发生额的借方合计
	 * @param accountid
	 * @param before
	 * @return
	 * @throws SQLException
	 */
	public String getJieSum(int accountid,Date before) throws SQLException;
	
	/**
	 * 取得指定账户，特定日期前发生额的贷方合计
	 * @param accountid
	 * @param before
	 * @return
	 * @throws SQLException
	 */
	public String getDaiSum(int accountid,Date before) throws SQLException;
}

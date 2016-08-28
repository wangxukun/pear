package wxk.bank.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import wxk.bank.entity.Accrual;

public interface DataProcessingService {
	/**
	 * 取得子账户的本期发生额
	 * @param accountid
	 * @param start
	 * @param end
	 * @return
	 * @throws SQLException
	 */
	List<Accrual> getAccrualsOfsubAccount(int accountid,Date start,Date end) throws SQLException;
	
	/**
	 * 取得选定日期的期初余额
	 * @param accountid 账户ID
	 * @param end 用于判断这个日期时或之前是否已初始化账户
	 * @param before 此日期时的期初余额
	 * @return 返回期初余额金额
	 * @throws SQLException
	 */
	String getInitialBalance(int accountid,Date end,Date before) throws SQLException;
}

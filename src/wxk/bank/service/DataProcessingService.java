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
}

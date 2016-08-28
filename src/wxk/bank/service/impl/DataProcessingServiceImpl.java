package wxk.bank.service.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import wxk.bank.dao.factory.DAOFactory;
import wxk.bank.entity.Accrual;
import wxk.bank.service.DataProcessingService;

public class DataProcessingServiceImpl implements DataProcessingService {

	@Override
	public List<Accrual> getAccrualsOfsubAccount(int accountid, Date start, Date end) throws SQLException {
		List<Accrual> accruals = null;
		accruals = DAOFactory.getDataProcessingDAOInstance().getAccrualsByAccountId(accountid, start, end);
		return accruals;
	}

}

package wxk.bank.service.impl;

import java.math.BigDecimal;
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

	@Override
	public String getInitialBalance(int accountid, Date end, Date before) throws SQLException {
		String amount = null;
		String init = DAOFactory.getDataProcessingDAOInstance().getInitAmount(accountid, end);
		if("".equals(init)){
			init = "0";
		}
		String jie = DAOFactory.getDataProcessingDAOInstance().getJieSum(accountid, before);
		if("".equals(jie)){
			jie = "0";
		}
		String dai = DAOFactory.getDataProcessingDAOInstance().getDaiSum(accountid, before);
		if("".equals(dai)){
			dai = "0";
		}
		BigDecimal bInit = new BigDecimal(init);
		BigDecimal bJie = new BigDecimal(jie);
		BigDecimal bDai = new BigDecimal(dai);
		bInit = bInit.add(bJie);
		bInit = bInit.subtract(bDai);
		amount = bInit.toString();
		return amount;
	}

}

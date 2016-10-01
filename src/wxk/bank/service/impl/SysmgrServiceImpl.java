package wxk.bank.service.impl;

import java.sql.SQLException;
import java.util.Set;

import wxk.bank.dao.factory.DAOFactory;
import wxk.bank.entity.Capacity;
import wxk.bank.service.SysmgrService;

public class SysmgrServiceImpl implements SysmgrService {

	@Override
	public boolean addFunction(Capacity capacity) throws SQLException {
		boolean flag = false;
		flag = DAOFactory.getSysmgrDAOInstance().addCapacity(capacity);
		return flag;
	}

	@Override
	public Set<Capacity> findFunctions() throws SQLException {
		Set<Capacity> capacitys = null;
		capacitys = DAOFactory.getSysmgrDAOInstance().getCapacitys();
		return capacitys;
	}

}

package wxk.bank.dao.proxy;

import java.sql.SQLException;
import java.util.Set;

import wxk.bank.dao.SysmgrDAO;
import wxk.bank.dao.impl.SysmgrDAOImpl;
import wxk.bank.entity.Capacity;
import wxk.bank.jdbc.JdbcUtils;

public class SysmgrDAOProxy implements SysmgrDAO {
	private SysmgrDAO dao;
	private JdbcUtils jdbc;
	public SysmgrDAOProxy(){
		this.jdbc = new JdbcUtils();
		this.dao = new SysmgrDAOImpl(this.jdbc);
	}
	@Override
	public boolean addCapacity(Capacity capacity) throws SQLException {
		boolean flag = false;
		try {
			this.jdbc.getConnection();
			flag = this.dao.addCapacity(capacity);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			this.jdbc.releaseConnection();
		}
		return flag;
	}
	@Override
	public Set<Capacity> getCapacitys() throws SQLException {
		Set<Capacity> capacitys = null;
		try {
			this.jdbc.getConnection();
			capacitys = this.dao.getCapacitys();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			this.jdbc.releaseConnection();
		}
		return capacitys;
	}

}

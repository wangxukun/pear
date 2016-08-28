package wxk.bank.dao.proxy;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import wxk.bank.dao.DataProcessingDAO;
import wxk.bank.dao.impl.DataProcessingDAOImpl;
import wxk.bank.entity.Accrual;
import wxk.bank.entity.InitAccount;
import wxk.bank.jdbc.JdbcUtils;

public class DataProcessingDAOProxy implements DataProcessingDAO {
	private DataProcessingDAO dao;
	private JdbcUtils jdbc;
	public DataProcessingDAOProxy(){
		this.jdbc = new JdbcUtils();
		this.dao = new DataProcessingDAOImpl(this.jdbc);
	}
	@Override
	public InitAccount getInitAccountByAccountId(int accountid) throws SQLException {
		InitAccount initAccount  = null;
		try {
			this.jdbc.getConnection();
			initAccount = this.dao.getInitAccountByAccountId(accountid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			this.jdbc.releaseConnection();
		}
		return initAccount;
	}

	@Override
	public List<Accrual> getAccrualsByAccountId(int accountid,Date start,Date end) throws SQLException {
		List<Accrual> accruals = null;
		try {
			this.jdbc.getConnection();
			accruals = this.dao.getAccrualsByAccountId(accountid, start, end);
		} catch (Exception e) {
			e.getSuppressed();
		}finally{
			this.jdbc.releaseConnection();
		}
		return accruals;
	}
	@Override
	public String getInitAmount(int accountid, Date end) throws SQLException {
		String amount = null;
		try {
			this.jdbc.getConnection();
			amount = this.dao.getInitAmount(accountid, end);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.jdbc.releaseConnection();
		}
		return amount;
	}
	@Override
	public String getJieSum(int accountid, Date before) throws SQLException {
		String amount = null;
		try {
			this.jdbc.getConnection();
			amount = this.dao.getJieSum(accountid, before);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.jdbc.releaseConnection();
		}
		return amount;
	}
	@Override
	public String getDaiSum(int accountid, Date before) throws SQLException {
		String amount = null;
		try {
			this.jdbc.getConnection();
			amount = this.dao.getDaiSum(accountid, before);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.jdbc.releaseConnection();
		}
		return amount;
	}

}

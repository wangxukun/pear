package wxk.bank.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import wxk.bank.dao.SysmgrDAO;
import wxk.bank.entity.Capacity;
import wxk.bank.jdbc.JdbcUtils;

public class SysmgrDAOImpl implements SysmgrDAO {

	private JdbcUtils jdbc;
	public SysmgrDAOImpl(JdbcUtils jdbc){
		this.jdbc = jdbc;
	}
	@Override
	public boolean addCapacity(Capacity capacity) throws SQLException {
		boolean flag = false;
		String sql = "insert into capacity(capacityname,parentid,url,icon,serialnum,accordion,status) values(?,?,?,?,?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(capacity.getCapacityname());
		params.add(capacity.getParentid());
		params.add(capacity.getUrl());
		params.add(capacity.getIcon());
		params.add(capacity.getSerialnum());
		params.add(capacity.getAccordion());
		params.add(capacity.getStatus());
		flag = this.jdbc.updateByPreparedStatement(sql, params);
		return flag;
	}
	@Override
	public Set<Capacity> getCapacitys() throws SQLException {
		Set<Capacity> capacitys = new TreeSet<Capacity>();
		String sql = "select capacityid,capacityname,parentid,url,icon,serialnum,accordion,status from capacity";
		List<Map<String, Object>> list = this.jdbc.findMoreByPreparedStatement(sql, null);
		if(!list.isEmpty()){
			Iterator<Map<String,Object>> iter = list.iterator();
			while(iter.hasNext()){
				Map<String,Object> map = null;
				map = iter.next();
				Capacity capacity = new Capacity();
				capacity.setCapacityid(Integer.parseInt(map.get("capacityid").toString()));
				capacity.setCapacityname(map.get("capacityname").toString());
				capacity.setParentid(Integer.parseInt(map.get("parentid").toString()));
				capacity.setUrl(map.get("url").toString());
				capacity.setIcon(map.get("icon").toString());
				capacity.setSerialnum(Integer.parseInt(map.get("serialnum").toString()));
				capacity.setAccordion(Integer.parseInt(map.get("accordion").toString()));
				capacity.setStatus(Integer.parseInt(map.get("status").toString()));
				capacitys.add(capacity);
			}
		}else{
			capacitys = null;
		}
		return capacitys;
	}

}

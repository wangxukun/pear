package wxk.bank.json.impl;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import wxk.bank.entity.Capacity;
import wxk.bank.json.JsonSysmgr;
import wxk.bank.service.factory.ServiceFactory;

public class JsonSysmgrImpl implements JsonSysmgr {

	@Override
	public JSONObject getTopFunction() {
		JSONObject o = new JSONObject();
		JSONArray ja = new JSONArray();
		Set<Capacity> capacitys = null;
		try {
			capacitys = ServiceFactory.getSysmgrServiceInstance().findFunctions();
			if(!capacitys.isEmpty()){
				Iterator<Capacity> iter = capacitys.iterator();
				while(iter.hasNext()){
					Capacity temp = null;
					temp = iter.next();
					if(temp.getAccordion() == 0){
						JSONObject jo = new JSONObject();
						jo.accumulate("id", temp.getCapacityid());
						jo.accumulate("capacityname", temp.getCapacityname());
						jo.accumulate("parentid", temp.getParentid());
						jo.accumulate("url", temp.getUrl());
						jo.accumulate("icon", temp.getIcon());
						jo.accumulate("serialnum", temp.getSerialnum());
						jo.accumulate("accordion", temp.getAccordion());
						jo.accumulate("status", temp.getStatus());
						ja.add(jo);
					}
				}
				o.accumulate("topcapacitys", ja);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}

	@Override
	public JSONObject getMenuItems(int parentid) {
		JSONObject o = new JSONObject();
		JSONArray ja = new JSONArray();
		Set<Capacity> capacitys = null;
		try {
			capacitys = ServiceFactory.getSysmgrServiceInstance().findFunctions();
			if(!capacitys.isEmpty()){
				Iterator<Capacity> iter = capacitys.iterator();
				while(iter.hasNext()){
					Capacity temp = null;
					temp = iter.next();
					if(temp.getAccordion() != 0 && temp.getParentid() == parentid){
						JSONObject jo = new JSONObject();
						jo.accumulate("id", temp.getCapacityid());
						jo.accumulate("capacityname", temp.getCapacityname());
						jo.accumulate("parentid", temp.getParentid());
						jo.accumulate("url", temp.getUrl());
						jo.accumulate("icon", temp.getIcon());
						jo.accumulate("serialnum", temp.getSerialnum());
						jo.accumulate("accordion", temp.getAccordion());
						jo.accumulate("status", temp.getStatus());
						ja.add(jo);
					}
				}
				o.accumulate("menuitem", ja);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}

	@Override
	public JSONObject getNavTree(int parentid) {
		JSONObject o = new JSONObject();
		JSONArray ja = new JSONArray();
		Set<Capacity> capacitys = null;
		try {
			capacitys = ServiceFactory.getSysmgrServiceInstance().findFunctions();
			if(!capacitys.isEmpty()){
				Iterator<Capacity> iter = capacitys.iterator();
				while(iter.hasNext()){
					Capacity temp = null;
					temp = iter.next();
					if(temp.getParentid() == parentid){
						JSONObject jo = new JSONObject();
						jo.accumulate("id", temp.getCapacityid());
						jo.accumulate("text", temp.getCapacityname());
						jo.accumulate("iconCls", temp.getIcon());
						if(temp.getAccordion() == 0){
							jo.accumulate("leaf", false);
						}else{
							jo.accumulate("leaf", true);
						}
						jo.accumulate("parentid", temp.getParentid());
						jo.accumulate("url", temp.getUrl());
						jo.accumulate("serialnum", temp.getSerialnum());
						jo.accumulate("accordion", temp.getAccordion());
						jo.accumulate("status", temp.getStatus());
						ja.add(jo);
					}
				}
				o.accumulate("navtree", ja);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}
}

package wxk.bank.json;

import net.sf.json.JSONObject;

public interface JsonUserManage {
	/**
	 * 生成所有用户组成的JSON对象
	 * @return
	 */
	public JSONObject getUsers();
	
	/**
	 * 生成登录用户信息JSON
	 * @param username
	 * @param password
	 * @return
	 */
	public JSONObject getLoginUser(String username, String password);
}

/**
 * 
 */
package wxk.bank.json;

import net.sf.json.JSONObject;

/**
 * @author Administrator
 *
 */
public interface JsonSysmgr {
	/**
	 * 取得顶级功能菜单组成的JSON对象数组
	 * @return
	 */
	public JSONObject getTopFunction();
	
	/**
	 * 取得指定菜单下的二级功能菜单项组成的JSON对象数组
	 * @param parentid
	 * @return
	 */
	public JSONObject getMenuItems(int parentid);
	
	/**
	 * 取得导航功能树
	 * @return
	 */
	public JSONObject getNavTree(int parentid);
}

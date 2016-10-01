package wxk.bank.json;

import net.sf.json.JSONObject;

public interface JsonAccountManage {
	/**
	 *  取得账户树
	 * @param parentid
	 * @return
	 */
	JSONObject getAccountTree(int parentid);
}

package wxk.bank.json;

import java.io.ByteArrayOutputStream;
import java.util.Date;

import net.sf.json.JSONObject;

public interface JsonDataProcessing {
	/**
	 * 取得账户明细JSON
	 * @param accountid
	 * @param start
	 * @param end
	 * @return
	 */
	JSONObject getAccountDetail(int accountid,Date start,Date end);
	
	/**
	 * 取得账户明细XML
	 * @param accountid
	 * @param start
	 * @param end
	 * @return
	 */
	ByteArrayOutputStream getAccountDetailXML(int accountid,Date start,Date end);
}

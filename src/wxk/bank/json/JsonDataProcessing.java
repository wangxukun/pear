package wxk.bank.json;

import java.util.Date;

import net.sf.json.JSONObject;

public interface JsonDataProcessing {
	JSONObject getAccountDetail(int accountid,Date start,Date end);
}

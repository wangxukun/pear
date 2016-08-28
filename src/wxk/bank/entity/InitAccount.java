package wxk.bank.entity;

import java.util.Date;

public class InitAccount {
	private int accountid;
	private Date initdate;
	private int direction;
	private String summary;
	private String amount;
	
	public InitAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getAccountid() {
		return accountid;
	}
	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}
	public Date getInitdate() {
		return initdate;
	}
	public void setInitdate(Date initdate) {
		this.initdate = initdate;
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "InitAccount [accountid=" + accountid + ", initdate=" + initdate + ", direction=" + direction
				+ ", summary=" + summary + ", amount=" + amount + "]";
	}
}

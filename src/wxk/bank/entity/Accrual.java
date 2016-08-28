package wxk.bank.entity;

import java.util.Date;

/**
 * 发生额
 * @author Administrator
 *
 */
public class Accrual {
	private int accountdetailid;	//帐户祥情ID
	private int accountid;	//总帐户ID
	private int number;	//凭证编号
	private int direction;	//借贷方向
	private String amount;	//金额
	private Date occurdate;	//发生日期
	private Date enterdate; //录入时间，在数据表中也指的是更新时间
	private String summary;	//摘要
	private String balance;	//余额，数据库中没有这个字段
	private int groupid;	//分类账户ID
	private int freeze;	//是否已冻结(0表示未冻结，1表示冻结)
	public Accrual() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getAccountdetailid() {
		return accountdetailid;
	}
	public void setAccountdetailid(int accountdetailid) {
		this.accountdetailid = accountdetailid;
	}
	public int getAccountid() {
		return accountid;
	}
	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public Date getOccurdate() {
		return occurdate;
	}
	public void setOccurdate(Date occurdate) {
		this.occurdate = occurdate;
	}
	public Date getEnterdate() {
		return enterdate;
	}
	public void setEnterdate(Date enterdate) {
		this.enterdate = enterdate;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public int getGroupid() {
		return groupid;
	}
	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}
	public int getFreeze() {
		return freeze;
	}
	public void setFreeze(int freeze) {
		this.freeze = freeze;
	}
	@Override
	public String toString() {
		return "Accrual [accountdetailid=" + accountdetailid + ", accountid=" + accountid + ", number=" + number
				+ ", direction=" + direction + ", amount=" + amount + ", occurdate=" + occurdate + ", enterdate="
				+ enterdate + ", summary=" + summary + ", balance=" + balance + ", groupid=" + groupid + ", freeze="
				+ freeze + "]";
	}
}

package wxk.bank.entity;

public class Account  implements Comparable<Account>{
	private int accountid;
	private String accountname;
	private int parentid;
	private String responsible;
	private String contactphone;
	public Account() {
		super();
	}
	public int getAccountid() {
		return accountid;
	}
	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}
	public String getAccountname() {
		return accountname;
	}
	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	public String getResponsible() {
		return responsible;
	}
	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}
	public String getContactphone() {
		return contactphone;
	}
	public void setContactphone(String contactphone) {
		this.contactphone = contactphone;
	}
	@Override
	public String toString() {
		return "Account [accountid=" + accountid + ", accountname=" + accountname + ", parentid=" + parentid
				+ ", responsible=" + responsible + ", contactphone=" + contactphone + "]";
	}
	@Override
	public int compareTo(Account o) {
		if(this.accountid > o.accountid){
			return 1;
		}else if(this.accountid < o.accountid){
			return -1;
		}else{
			if(this.parentid > o.parentid){
				return 1;
			}else if(this.parentid < o.parentid){
				return -1;
			}else{
				return this.accountname.compareTo(o.accountname);
			}
		}
	}
	
}

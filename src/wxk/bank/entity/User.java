/**
 * 
 */
package wxk.bank.entity;

import java.util.Date;

/**
 * @author Administrator
 *
 */
public class User {
	private int userid;
	private String username; 
	private String fullname; //用户真实姓名
	private String password; 
	private String contactphone; 
	private String email; 
	private String organization; //用户所在机关组织֯
	private int usertype; //用户类型
	private int userstate; //用户状态״̬
	private int userscope; //用户管理域
	private Date creationdate; //用户创建日期
	private Date updateddate; //用户更新日期
	public User() {
		super();
	}
	
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContactphone() {
		return contactphone;
	}
	public void setContactphone(String contactphone) {
		this.contactphone = contactphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public int getUsertype() {
		return usertype;
	}
	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}
	public int getUserstate() {
		return userstate;
	}
	public void setUserstate(int userstate) {
		this.userstate = userstate;
	}
	public int getUserscope() {
		return userscope;
	}
	public void setUserscope(int userscope) {
		this.userscope = userscope;
	}
	public Date getCreationdate() {
		return creationdate;
	}
	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}
	public Date getUpdateddate() {
		return updateddate;
	}
	public void setUpdateddate(Date updateddate) {
		this.updateddate = updateddate;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", fullname=" + fullname + ", password=" + password
				+ ", contactphone=" + contactphone + ", email=" + email + ", organization=" + organization
				+ ", usertype=" + usertype + ", userstate=" + userstate + ", userscope=" + userscope + ", creationdate="
				+ creationdate + ", updateddate=" + updateddate + "]";
	}
}

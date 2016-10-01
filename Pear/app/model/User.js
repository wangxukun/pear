/**
 * Created by Administrator on 9/20/2016.
 */
Ext.define('Pear.model.User', {
    
	extend: 'Pear.model.Base',
	
	/*
	 *  private int userid;
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
	 */
	
	fields: [
	     { name: 'userid', type: 'int'},
	     { name: 'username', type: 'string'},
	     { name: 'fullname', type: 'string'},
	     { name: 'password', type: 'string'},
	     { name: 'contactphone', type: 'string'},
	     { name: 'email', type: 'string'},
	     { name: 'organization', type: 'string'},
	     { name: 'usertype', type: 'int'},
	     { name: 'userstate', type: 'boolean'},
	     { name: 'userscope', type: 'int'},
	     { name: 'creationdate', type: 'string'},
	     { name: 'updateddate', type: 'string'}
	]
});
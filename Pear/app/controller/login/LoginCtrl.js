/**
 * Created by Administrator on 9/9/2016.
 */
Ext.define('Pear.controller.login.LoginCtrl', {
	extend : 'Ext.app.ViewController',
	alias : 'controller.loginCtrl',

	requires : [ 'Pear.view.main.Main' ],
	init : function() {
		this.sendCount = 0;
	},

	onLoginClick : function(btn) {
		this.login();
	},

	onFieldSpecialKey : function(field, e) {
		if (e.getKey() === e.ENTER) {
			this.login();
		}
	},

	login : function() {
		var form = this.lookupReference('form');
		var view = this.getView();
		var error = this.lookupReference('error').hide();
		if (form.isValid()) {
			// Server responded...

			// Submit the Ajax request and handle the response
			form.submit({
				success : function(form, action) {
					new Ext.util.LocalStorage({
			    		id: 'loginSession',
			    		session: true
			    	});
					localStorage.setItem("PearLoggedIn", true);
					// Remove Login Window
					view.destroy();
					if (Ext.getCmp("login") !== undefined) {
						Ext.getCmp("login").destroy();
						Ext.create({
							xtype : 'app-main'
						});
					}
				},
				failure : function(form, action) {
					var errorMsg = '';
					switch (action.failureType) {
					case Ext.form.action.Action.CLIENT_INVALID:
						errorMsg = 'Form fields may not be submitted with invalid values';
						break;
					case Ext.form.action.Action.CONNECT_FAILURE:
						errorMsg = 'Ajax通信失败';
						break;
					case Ext.form.action.Action.SERVER_INVALID:
						errorMsg = action.result.msg;
					}
					
					error.update(errorMsg);
					error.show();
				}
			});

			/*
			 * var username =
			 * this.lookupReference('username').getValue(); var
			 * password =
			 * this.lookupReference('password').getValue(); if
			 * (username=="wangxukun" && password=="wxlwxk") {
			 * this.onServerSuccess(); } else {
			 * this.onServerFailure(); }
			 */
		}
	}
});
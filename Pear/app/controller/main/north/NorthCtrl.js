/**
 * Created by Administrator on 9/11/2016.
 */
Ext.define('Pear.controller.main.north.NorthCtrl', {
	extend : 'Ext.app.ViewController',

	alias : 'controller.northCtrl',
	requires: [
	      'Pear.store.User'
	],
	control : {
		
	},
	init:function(){
		//实例化控制器
		var view = this.getView();
		//获取Toolbar
		var toolbar = view.getComponent("logininfotoolbar");
		//获取Toolbar下的itemId为userinfo的tbtext组件
		var userinfo = toolbar.queryById("userinfo");
		
		var store = Ext.create('Pear.store.User');
		store.load({
		    callback:function(){
		        var first_name = this.first().get('updateddate');
		        var user = this.first().get('fullname');
		        var organization = this.first().get('organization');
		         userinfo.setConfig({
		 			html: '<ul><li>角色：'+first_name+'<li>用户：'+user+'<li>单位：'+organization+'</ul>'
		 		});
		    }
		});
	},

	onExit : function() {
		alert('退出系统');
	},

	onChangeUser : function() {
		alert('切换用户');
	},

	onShowHelp : function() {
		var tabs = Ext.getCmp('tabs');
		var tab = tabs.getComponent('tab-help');
		if (typeof tab === 'undefined') {
			tab = tabs.add({
				itemId : 'tab-help',
				title : '操作流程',
				closable : true,
				glyph : 'xf02d@FontAwesome',
				items:[{
					xtype: 'image',
					src: 'resources/images/stream.gif',
					alt: '操作流程图',
					width: 350,
					height: 700,
					margin: '20 0 20 200'
				}]
			});
		}
		tabs.setActiveTab(tab);
	},
	
	onChangeAccount: function(){
		alert('切换账套');
	}
});
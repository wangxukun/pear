/**
 * Created by Administrator on 9/9/2016.
 */
Ext.define('Pear.view.login.Login', {
	extend : 'Ext.container.Viewport',
	
	requires: ['Pear.controller.login.LoginCtrl'],
	id: 'login',
	layout: {
	    type: 'vbox',
	    align: 'middle'
	},
	xtype: 'login',
	style:{
		backgroundColor: '#FFF'
	},
    items: [{
    	xtype: 'box',
    	renderTpl: [
            '<h1 id="{id}-title" data-ref="title">{title}</h1>',
            '<p id="{id}-msg" data-ref="msg">{msg}</p>'
        ],
        renderData: {
            title: "银行存款账户管理系统",
            msg: "三岔河镇农业综合服务中心"
        },
        childEls: ["title","msg"],
        listeners: {
            afterrender: function(cmp){
                // After rendering the component will have a title property
                cmp.title.setStyle({
                	color: "#999",
                	fontSize: '40px',
                	fontFamily: '黑体',
                    paddingTop: '150px'
                });
                cmp.msg.setStyle({
                	color: "#999",
                	fontSize: '16px',
                	fontFamily: '黑体',
                	paddingRight: '60px',
                	textAlign: 'right'
                });
            }
        }
    },{
        xtype: 'loginDialog',
        autoShow: true
    }]
});
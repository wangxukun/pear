/**
 * Created by Administrator on 9/9/2016.
 */
Ext.define('Pear.view.main.north.North', {
	extend: 'Ext.panel.Panel',
	requires: [
	       'Pear.controller.main.north.NorthCtrl'
	],
	controller: 'northCtrl',
	xtype: 'north',
	layout: {
		type: 'hbox'
	},
	bodyStyle:{
		background: '#317040'
	},
	scrollable: 'x',
	items: [{
		xtype : 'header',
		glyph : 'xf24e@FontAwesome',
		height : 80,
		width : 60,
		style : {
			fontSize : '40px',
			color : '#999',
			marginLeft : '10px'
		}
	},{
		xtype : 'component',
		height : 80,
		width : 600,
		renderTpl : [ '<h1 id="{id}-title" data-ref="title">{title}</h1>' ],
		renderData : {
			title : '银行存款账户管理系统'
		},
		childEls : [ 'title' ],
		listeners : {
			afterrender : function(cmp) {
				cmp.title.setStyle({
					color : '#FFF',
					fontSize : '40px',
					fontFamily : '黑体',
					height : 80,
					lineHeight : '25px'
				});
			}
		}
	},{
		xtype : 'container',
		height : 80,
		width : 450,
		style:{
		//	background: '#abcdef',
			paddingTop: '10px'
		},
		layout : 'column',
		items : [ {
			xtype : 'button',
			scale : 'large',
			glyph : 'xf0ec@FontAwesome',
			iconAlign : 'top',
			text : '切换账套',
			columnWidth : 0.25,
			style : {
				margin : '4px',
				border : 0
			},
			handler : 'onChangeAccount'
		}, {
			xtype : 'button',
			scale : 'large',
			glyph : 'xf0c0@FontAwesome',
			iconAlign : 'top',
			text : '切换用户',
			columnWidth : 0.25,
			style : {
				margin : '4px',
				border : 0
			},
			handler : 'onChangeUser'
		}, {
			xtype : 'button',
			scale : 'large',
			glyph : 'xf011@FontAwesome',
			iconAlign : 'top',
			text : '退出系统',
			columnWidth : 0.25,
			style : {
				margin : '4px',
				border : 0
			},
			handler : 'onExit'
		}, {
			xtype : 'button',
			scale : 'large',
			glyph : 'xf02d@FontAwesome',
			iconAlign : 'top',
			text : '操作流程',
			columnWidth : 0.25,
			style : {
				margin : '4px',
				border : 0
			},
			handler : 'onShowHelp'
		} ]
	},{
		xtype: 'toolbar',
		itemId: 'logininfotoolbar',
		width: 750,
		height: 78,
		marginTop:'10 0 0 0',
		border: false,
		style:{
			backgroundColor: "#317040",
			color: "#ffffff"
		},
		items:[{ 
			xtype: 'tbfill' 
		},{
			xtype : 'tbtext',
			itemId: 'userinfo',
			style:{
				color: "#ffffff"
			}
		}, {
			xtype : 'tbtext',
			itemId: 'accountinfo',
			html : '<ul><li>账户：三岔河镇农业综合服务中心<li>日期：2016年9月31日<li>当前时间：</ul>',
			style:{
				color: "#ffffff"
			}
		}]
	}]
});
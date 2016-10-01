/**
 * Created by Administrator on 10/1/2016.
 */
Ext.define('Pear.view.main.west.dataQuery.QueryDetail', {
	extend : 'Ext.grid.Panel',

	requires : [ 'Ext.ux.TreePicker', 'Pear.store.AccountTreeStore' ],

	xtype : 'queryDetail',
	layout : 'fit',
	ui : 'highlight-framed',
	border : true,
	height : 840,
	padding : 20,
	scrollable : true,
	sortableColumns : false, // 不能排序
	enableColumnHide : false, // 不能隐藏列
	initComponent : function() {
		this.header = {
			title: '<center>三岔河镇农业综合服务中心</center>'
		};
		this.tbar = [ {
			xtype : 'treepicker',
//			id : 'accountTree',
			name : 'parentid',
			fieldLabel : '查询账户',
			width : 300,
			labelWidth : 60,
			displayField : 'text',
			emptyText : '请选择要查询的账户',
			allowBlank : false,
			blankText : '不能是空',
			store : Ext.create('Pear.store.AccountTreeStore')
		}, {
			xtype : 'datefield',
			fieldLabel : '起止日期',
			width : 250,
			labelWidth : 60,
			name : 'start'
		}, {
			xtype : 'datefield',
			width : 200,
			labelWidth : 10,
			labelSeparator: '',
			fieldLabel : '-',
			name : 'end'
		}, {
	        xtype: 'button',
	        text: '查询'
	    }, '->', {
	        xtype: 'button',
	        text: '打印'
	    }, {
	        xtype: 'button',
	        text: '导出'
	    }];
		this.columns = [ {
			text : '<center>2016年</center>',
			sortable : false,
			columns : [ {
				text : '<center>月</center>',
				dataIndex : 'month',
				width : 75
			}, {
				text : '<center>日</center>',
				dataIndex : 'day',
				sortable : false,
				width : 75
			} ]
		}, {
			text : '<center>编号</center>',
			dataIndex : 'number',
			width : 80
		}, {
			text : '<center>摘要</center>',
			dataIndex : 'summary',
			flex : 1
		}, {
			text : '<center>收入</center>',
			dataIndex : 'earning',
			width : 200
		}, {
			text : '<center>支出</center>',
			dataIndex : 'expenditure',
			width : 200
		}, {
			text : '<center>方向</center>',
			dataIndex : 'direction',
			width : 80
		}, {
			text : '<center>余额</center>',
			dataIndex : 'balance',
			width : 200
		} ];
		this.callParent();
	}
});
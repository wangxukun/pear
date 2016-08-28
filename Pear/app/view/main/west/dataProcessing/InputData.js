/**
 * Created by Administrator on 10/1/2016.
 */
Ext.define('Pear.view.main.west.dataProcessing.InputData', {
	extend: 'Ext.grid.Panel',
	
	xtype: 'inputData',
	
	requires:[
		'Ext.grid.*',
	    'Ext.data.*',
	    'Ext.form.field.Number',
	    'Ext.form.field.Date',
	    'Pear.store.AccountDetail'
	],
	
	width: '100%',
	height : 840,
	padding : 20,
	initComponent: function(){
		Ext.apply(this,{
			frame: true,
//			title: '录入数据',
			ui : 'highlight-framed',
			iconCls: 'icon-grid',
			sortableColumns : false, // 不能排序
        	enableColumnHide : false, // 不能隐藏列
			store: Ext.create('Pear.store.AccountDetail'),
		    //停靠项
		    dockedItems: [{
		        dock: 'top',
		        xtype: 'toolbar',
		        items: [{
		            text: 'Toggle Summary',
		            enableToggle: true,
		            pressed: true,
		            scope: this,
		            handler: function() {
		            	this.getView().getFeature('group').toggleSummaryRow();
		            }
		        }]
		    }],
		    //特征
		    features: [{
		        id: 'group',
		        ftype: 'groupingsummary',
		        groupHeaderTpl: '{name}',
		        hideGroupedHeader: true,
		        enableGroupingMenu: false
		    }],
		    columns: [{
		    	header: '日期',
		    	dataIndex: 'occurdate',
		    	renderer: Ext.util.Format.dateRenderer('m/d/Y'),
		    	field: {
	                xtype: 'datefield'
	            }
		    }, {
		        header: 'project',
		        width: 180,
		        dataIndex: 'project'
		    },{
		    	text: '编号',
		    	dataIndex: 'number'
		    },{
		    	text: '所属账户',
		    	dataIndex: 'accountname'
		    },{
		        text: '摘要',
		        flex: 1,
		      //  tdCls: 'task',
		        dataIndex: 'summary',
		        hideable: false,
		        summaryType: 'count',
		        summaryRenderer: function(value, summaryData, dataIndex) {
		         //   return ((value === 0 || value > 1) ? '(' + value + ' Tasks)' : '(1 Task)');
		        	return "<div style='color:red'><center>合计</center></div>"
		        }
		    }, {
		        header: '借方',
		        width: 136,
		        dataIndex: 'jie',
		        summaryType: 'sum',
		        summaryRenderer: function(value) {
//		            return value + ' hours';
		            return "<div style='color:red'>"+value+"</div>"
		        }
		    }, {
		        header: '贷方',
		        width: 100,
		        dataIndex: 'dai',
		        summaryType: 'sum',
		        summaryRenderer: function(value, dataIndex) {
//		            return value + ' hours';
		            return "<div style='color:red'>"+value+" </div>"
		        }
		    }, {
		        header: '方向',
		        width: 120,
		//        summaryRenderer: Ext.util.Format.usMoney,
		        dataIndex: 'direction',
		//        summaryType: 'average',
		        field: {
		            xtype: 'numberfield'
		        }
		    }, {
		        id: 'balance',
		        header: '余额',
		        width: 100,
		        dataIndex: 'balance',
		       /* summaryType: function(records, values) {
		            var i = 0,
		                length = records.length,
		                total = 0,
		                record;

		            for (; i < length; ++i) {
		                record = records[i];
		                total += record.get('dai') * record.get('direction');
		            }
		            return total;
		        },
		        summaryRenderer: Ext.util.Format.usMoney*/
		    }]
		});
		this.callParent();
	}
});
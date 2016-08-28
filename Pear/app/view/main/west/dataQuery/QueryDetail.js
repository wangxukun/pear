/**
 * Created by Administrator on 10/1/2016.
 */
Ext.define('Pear.view.main.west.dataQuery.QueryDetail', {
	extend : 'Ext.container.Container',

	requires : [ 
		'Ext.grid.*',
		'Ext.ux.TreePicker', 
		'Ext.layout.container.HBox',
        'Ext.layout.container.VBox',
        'Ext.data.*',
	    'Ext.form.field.Number',
	    'Ext.form.field.Date',
		'Pear.store.AccountTreeStore',
	    'Pear.store.AccountDetail',
	    'Pear.controller.main.west.dataQuery.QueryDetail'
	],

	xtype : 'queryDetail',
	layout: {
		//水平布局
        type: 'vbox',
        align: 'stretch'
    },
    controller: 'queryDetail',
    width: '100%',
	height : 840,
	padding : 20,
	
	//=======初始化组件--Ext.container.Container，这个任何组件的基类。
	initComponent: function(){
		//拷贝第二个参数到this对象中
        Ext.apply(this, {
            items: [
            	//=============水平布局中的第一个组件--toolbar===========
            	{
                xtype: 'toolbar',
                items: [ {
        			xtype : 'treepicker',
//        			id : 'accountTree',
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
        			itemId: 'startDate',
        			fieldLabel : '起止日期',
        			width : 250,
        			labelWidth : 60,
        			name : 'start'
        		}, {
        			xtype : 'datefield',
        			itemId: 'endDate',
        			width : 200,
        			labelWidth : 10,
        			labelSeparator: '',
        			fieldLabel : '-',
        			name : 'end'
        		}, {
        	        xtype: 'button',
        	        itemId: 'showAccountDetail',
        	        text: '明细查询',
                    scope: this,
                    handler: this.onShowAccountDetailClick
        	    }, '->', {
        	        xtype: 'button',
        	        text: '打印',
   //     	        scope: this,
        	        handler: 'onPrintClick'
        	    }, {
        	        xtype: 'button',
        	        text: '导出'
        	    }]
                
            },
            //=============水平布局中的第一个组件--grid===========
            {
                margin: '10 0 0 0',
                xtype: 'grid',
                ui : 'highlight-framed',
                frame: true,
                scrollable : true,
            	sortableColumns : false, // 不能排序
            	enableColumnHide : false, // 不能隐藏列
            	columnLines: true,
                border : true,
                flex: 1,
                columns: [],
              //停靠项
    		    /*dockedItems: [{
    		        dock: 'top',
    		        xtype: 'toolbar',
    		        items: [{
    		            text: '关闭显示合计',
    		            enableToggle: true,
    		            pressed: true,
    		            handler: function() {
    		            	this.up('grid').getView().getFeature('group').toggleSummaryRow();
    		            	this.setTitle("开启显示合计");
    		            }
    		        }]
    		    }],*/
    		    //特征
    		    features: [{
    		        id: 'group',
    		        ftype: 'groupingsummary',
    		        groupHeaderTpl: '{name}',
    		        hideGroupedHeader: true,
    		        enableNoGroups: false,
    		        enableGroupingMenu: false,
    		        collapsible:true
    		    }],
                viewConfig: {
                    emptyText: '点击查询后在此查询账户明细',
                    deferEmptyText: false
                }
            }]    
        });
        this.callParent();
    },
    
    //查询并显示子账户明细
    showAccountDetail: function(accountId,startDate,endDate){
        var grid = this.down('grid');
        
        Ext.suspendLayouts();
 //        grid.setTitle('某某村委会或某某小组');
        grid.reconfigure(this.createDetailAccountStore(accountId,startDate,endDate), [{
            header: '日期',
            width: 136,
            sortable: true,
            dataIndex: 'occurdate',
 //           summaryType: 'max',
            renderer: Ext.util.Format.dateRenderer('Y-m-d'),
 //           summaryRenderer: Ext.util.Format.dateRenderer('m/d/Y'),
            field: {
                xtype: 'datefield'
            }
        },{
        	header: '编号',
        	width: 80,
        	dataIndex: 'number',
        	renderer: function(value){
        		if(value == "-1"){
        			return "";
        		}else{
        			return value;
        		}
        	},
            field: {
                xtype: 'numberfield'
            }
        },{
            text: '摘要',
            flex: 1,
            tdCls: 'task',
            sortable: true,
            dataIndex: 'summary',
            hideable: false,
            summaryType: 'count',
            summaryRenderer: function(value, summaryData, dataIndex) {
//                return ((value === 0 || value > 1) ? '(' + value + ' Tasks)' : '(1 Task)');
            	  return "<div style='text-align:center;color:red'>小计</div>";
            }
        }, {
            header: '月份',
            width: 180,
            hidden: true,
            dataIndex: 'month',
            renderer: function(value){
            	if(value == "00期初"){
            		return "期初";
            	}{
            		return value;
            	}
            }
        },  {
            header: '借方',
            width: 180,
            dataIndex: 'jie',
            summaryType: 'sum',
            renderer: function(value, metaData, record, rowIdx, colIdx, store, view){
        		if(value == 0){
            		return "";
            	}else{
            		return Ext.util.Format.number(value,"0,000.00");
            	}
            	
            },
            summaryRenderer: function(value, summaryData, dataIndex) {
            	return "<div style='color:red'>"+Ext.util.Format.number(value,"0,000.00")+"</div>";
            },
            field: {
                xtype: 'numberfield'
            }
        }, {
            header: '贷方',
            width: 180,
            dataIndex: 'dai',
            summaryType: 'sum',
            renderer: function(value, metaData, record, rowIdx, colIdx, store, view){
            	if(value == 0){
            		return "";
            	}else{
            		return Ext.util.Format.number(value,"0,000.00");
            	}
            },
            summaryRenderer: function(value, summaryData, dataIndex) {
            	return "<div style='color:red'>"+Ext.util.Format.number(value,"0,000.00")+"</div>";
            },
            field: {
                xtype: 'numberfield'
            }
        },{
        	header: '方向',
        	width: 80,
        	dataIndex: 'direction',
        	renderer: function(value){
        		if(value == 0){
        			return "借";
        		}else{
        			return "<div style='color:red'>贷</div>";
        		}
        	}
        },{
            id: 'balance',
            header: '余额',
            width: 180,
            sortable: false,
            groupable: false,
            renderer: function(value, metaData, record, rowIdx, colIdx, store, view) {
            	return value;
                
            },
            dataIndex: 'balance'
        }]);
        Ext.resumeLayouts(true);  
    },
    
    createDetailAccountStore: function(accountId,startDate,endDate){
        return Ext.create('Pear.store.AccountDetail',{
        	proxy: {
				extraParams:{
					accountId:accountId,
					startDate: startDate,
					endDate:endDate
				}
			}
        });
    },
    
    onShowAccountDetailClick: function(){
    	var toolbar = this.down('toolbar');
    	var accountTree = toolbar.down('treepicker');
    	var accountStartDate = toolbar.getComponent('startDate');
    	var accountEndDate = toolbar.getComponent('endDate');
    	console.info("账户ID："+accountTree.getValue()+"，开始日期："+accountStartDate.getValue()+"，结束日期："+accountEndDate.getValue());
    	var accountId = accountTree.getValue();
    	var startDate = accountStartDate.getValue();
    	var endDate = accountEndDate.getValue();
    	
    	this.showAccountDetail(accountId,startDate,endDate);
    }
});
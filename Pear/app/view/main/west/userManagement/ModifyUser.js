/**
 * Created by Administrator on 10/1/2016.
 */
Ext.define('Pear.view.main.west.userManagement.ModifyUser', {
	extend: 'Ext.form.Panel',
    xtype: 'modifyUser',
    
    requires: [
           'Pear.model.ModifyUserModel',
           'Pear.data.DataSets'
    ],
    //应用一个框架到这个panel
    frame: true,
    //框架标题
    title: 'Company data',
    bodyPadding: 5,
    //这个panel中直接子items的排列方式，使用列布局
    layout: 'column',
    
    // In this example, configuration is applied at initComponent time
    // because it depends on profileInfo object that is generated for the
    // FormGrid instance.
    // 在这个例子中,配置应用initComponent时候因为它取决于profileInfo modifyUser生成的对象实例。
    initComponent: function() {
    	/**
    	 * Ext.apply(object,config,[defaults])
    	 * 拷贝config的所有属性到指定的object，有两种默认的支持标准：
    	 * Ext.apply(obj,{a:1},{a:2}); // obj.a === 1
    	 * Ext.apply(obj,{},{a:}); // obj.a === 2
    	 */
        Ext.apply(this, {
            width: 880,
        	style: {
        		// 设置此panel居中
        		margin: '100px auto'
        		
        	},
            fieldDefaults: {
                labelAlign: 'left',
                labelWidth: 90,
                anchor: '100%',
                msgTarget: 'side'
            },

            items: [{
                //这个子组件占panel宽度的65%
            	columnWidth: 0.65,
            	//这个子组件为Ext.grid.Panel组件
                xtype: 'gridpanel',
                //填充这个网格面板的store
                store: new Ext.data.Store({
                	//填充这个网格面板的store的model
                    model: Pear.model.ModifyUserModel,
                    //代理设置
                    proxy: {
                        //内存代理
                    	type: 'memory',
                    	//读数据的方式，也就是数据的存储格式
                        reader: {
                            //数据的存储格式为数组形式
                        	type: 'array'
                        }
                    },
                    //内联加载数据，store转化每一个对象存储在数据模型实例中
                    data: Pear.data.DataSets.company
                }),
                height: 400,
                columns: [{
                	text: 'Id',
                	flex: 1,
                	dataIndex: 'id'
                },{
                    text: 'Company',
                    sortable: true,
                    dataIndex: 'name'
                }, {
                    text: 'Price',
                    width: 75,
                    sortable: true,
                    dataIndex: 'price'
                }, {
                    text: 'Change',
                    width: 80,
                    sortable: true,
                    renderer: this.changeRenderer,
                    dataIndex: 'change'
                }, {
                    text: '% Change',
                    width: 100,
                    sortable: true,
                    renderer: this.pctChangeRenderer,
                    dataIndex: 'pctChange'
                }, {
                    text: 'Last Updated',
                    width: 115,
                    sortable: true,
                    formatter: 'date("m/d/Y")',
                    dataIndex: 'lastChange'
                }, {
                    text: 'Rating',
                    width: 60,
                    sortable: true,
                    renderer: this.renderRating,
                    dataIndex: 'rating'
                }],
                listeners: {
                    scope: this,
                    selectionchange: this.onSelectionChange
                }
            }, {
                columnWidth: 0.35,
                margin: '0 0 0 10',
                xtype: 'fieldset',
                title:'Company details',
                layout: 'anchor',
                defaultType: 'textfield',
                items: [{
                    fieldLabel: 'Name',
                    name: 'name'
                },{
                    fieldLabel: 'Price',
                    name: 'price'
                },{
                    fieldLabel: '% Change',
                    name: 'pctChange'
                },{
                    xtype: 'datefield',
                    fieldLabel: 'Last Updated',
                    name: 'lastChange'
                }, {
                    xtype: 'radiogroup',
                    fieldLabel: 'Rating',
                    columns: 3,
                    defaults: {
                        name: 'rating' //Each radio has the same name so the browser will make sure only one is checked at once
                    },
                    items: [{
                        inputValue: '0',
                        boxLabel: 'A'
                    }, {
                        inputValue: '1',
                        boxLabel: 'B'
                    }, {
                        inputValue: '2',
                        boxLabel: 'C'
                    }]
                }]
            }]
        });
        //确保父类的initComponent方法也被调用
        this.callParent();
    },
    
    changeRenderer: function(val) {
        if (val > 0) {
            return '<span style="color:green;">' + val + '</span>';
        } else if(val < 0) {
            return '<span style="color:red;">' + val + '</span>';
        }
        return val;
    },
    
    pctChangeRenderer: function(val){
        if (val > 0) {
            return '<span style="color:green;">' + val + '%</span>';
        } else if(val < 0) {
            return '<span style="color:red;">' + val + '%</span>';
        }
        return val;
    },
    
    renderRating: function(val){
        switch (val) {
            case 0:
                return 'A';
            case 1:
                return 'B';
            case 2:
                return 'C';
        }
    },
    
    onSelectionChange: function(model, records) {
        var rec = records[0];
        if (rec) {
            this.getForm().loadRecord(rec);
        }
    }
});
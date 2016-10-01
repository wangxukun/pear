/**
 * Created by Administrator on 10/1/2016.
 */
Ext.define('Pear.view.main.west.userManagement.DelmodUser', {
	extend: 'Ext.form.Panel',
    xtype: 'delmodUser',
    
    requires: [
           'Pear.model.DelmodUserModel',
           'Pear.store.DelmodUserStore',
           'Pear.controller.main.west.usermgr.DelmodUserController'
    ],
    //应用一个框架到这个panel
    frame: true,
    //框架标题
    title: '<center>修改或删除用户</center>',
    bodyPadding: 5,
    //这个panel中直接子items的排列方式，使用列布局
    layout: 'column',
    controller: 'delmodUser',
    // In this example, configuration is applied at initComponent time
    // because it depends on profileInfo object that is generated for the
    // FormGrid instance.
    // 在这个例子中,配置应用initComponent时候因为它取决于profileInfo delmodUser生成的对象实例。
    initComponent: function() {
    	/**
    	 * Ext.apply(object,config,[defaults])
    	 * 拷贝config的所有属性到指定的object，有两种默认的支持标准：
    	 * Ext.apply(obj,{a:1},{a:2}); // obj.a === 1
    	 * Ext.apply(obj,{},{a:}); // obj.a === 2
    	 */
        Ext.apply(this, {
            width: 1520,
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
            	columnWidth: 0.76,
            	//这个子组件为Ext.grid.Panel组件
                xtype: 'gridpanel',
                //填充这个网格面板的store
                /*store: new Ext.data.Store({
                	//填充这个网格面板的store的model
                    model: Pear.model.DelmodUserModel,
                    //代理设置
                    proxy: {
                        //内存代理
                    	type: 'memory',
                    	//读数据的方式，也就是数据的存储格式
                        reader: {
                            //数据的存储格式为数组形式
                        	type: 'json'
                        }
                    },
                    //内联加载数据，store转化每一个对象存储在数据模型实例中
                    data: Pear.data.DataSets.users
                }),*/
                store: {
            		type: 'delmodUserStore'
            	},
                height: 400,
                layout: 'fit',
                columns: [{
                	text: '<center>ID</center>',
                	width: 40,
                	dataIndex: 'id'
                },{
                    text: '<center>账号</center>',
                    width: 100,
                    sortable: true,
                    dataIndex: 'username'
                }, {
                    text: '<center>姓名</center>',
                    width: 80,
                    sortable: true,
                    dataIndex: 'fullname'
                }, {
                    text: '<center>电话</center>',
                    width: 110,
                    sortable: true,
                    dataIndex: 'contactphone'
                }, {
                    text: '<center>邮箱</center>',
                    flex: 1,
                    sortable: true,
                    dataIndex: 'email'
                }, {
                    text: '<center>单位</center>',
                    width: 220,
                    sortable: true,
                    dataIndex: 'organization'
                }, {
                    text: '类型',
                    width: 50,
                    align: 'center',
                    sortable: true,
                    dataIndex: 'usertype'
                }, {
                    text: '状态',
                    width: 50,
                    align: 'center',
                    sortable: true,
                    dataIndex: 'userstate'
                }, {
                    text: '范围',
                    width: 50,
                    align: 'center',
                    sortable: true,
                    dataIndex: 'userscope'
                }, {
                    text: '创建日期',
                    width: 100,
                    align: 'center',
                    sortable: true,
                    formatter: 'date("Y-m-d")',
                    dataIndex: 'creationdate'
                }, {
                    text: '更新日期',
                    width: 100,
                    align: 'center',
                    sortable: true,
                    formatter: 'date("Y-m-d")',
                    dataIndex: 'updateddate'
                },{
                	text: '删除',
                	xtype: 'actioncolumn',
                	align: 'center',
                	width:50,
                    items: [{
                    	iconCls: 'x-fa fa-minus-circle',
                        tooltip: '删除用户',
                        handler: 'delectUser'
                    }]
                }],
                listeners: {
                    scope: this,
                    selectionchange: this.onSelectionChange
                }
            }, {
                columnWidth: 0.24,
                margin: '0 0 0 10',
                xtype: 'fieldset',
                title:'修改用户',
                layout: 'anchor',
                defaultType: 'textfield',
              //字段的默认配置
                fieldDefaults: {
                	//表单的标签左对齐
                	labelAlign: 'left',
                	//在整个表单中标签列所占的宽度
                	labelWidth: 80,
                	//错误提示信息显示的位置
                	msgTarget: 'under'
                },
                items: [{
                    fieldLabel: '账号',
                    readOnly: true,
                    name: 'username'
                },{
                    fieldLabel: '姓名',
                    name: 'fullname'
                },{
                    fieldLabel: '电话',
                    name: 'contactphone'
                },{
                    fieldLabel: '邮箱',
                    name: 'email'
                },{
                    fieldLabel: '单位',
                    name: 'organization'
                }, {
                    xtype: 'radiogroup',
                    fieldLabel: '类型',
                    columns: 3,
                    defaults: {
                        name: 'usertype' //Each radio has the same name so the browser will make sure only one is checked at once
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
                },{
                    xtype: 'radiogroup',
                    fieldLabel: '状态',
                    columns: 3,
                    defaults: {
                        name: 'userstate' //Each radio has the same name so the browser will make sure only one is checked at once
                    },
                    items: [{
                        inputValue: '0',
                        boxLabel: 'A'
                    }, {
                        inputValue: '1',
                        boxLabel: 'B'
                    }]
                },{
                    xtype: 'radiogroup',
                    fieldLabel: '范围',
                    columns: 3,
                    defaults: {
                        name: 'userscope' //Each radio has the same name so the browser will make sure only one is checked at once
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
            }],
         // Reset and Submit buttons
            buttons: [{
                text: '重置',
                handler: function() {
                    this.up('form').getForm().reset();
                }
            }, {
                text: '提交',
                formBind: true, //only enabled once the form is valid
                disabled: true,
                handler: function() {
                    var form = this.up('form').getForm();
                    if (form.isValid()) {
                        form.submit({
                            success: function(form, action) {
                               Ext.Msg.alert('成功', action.result.msg);
                               form.reset();
                            },
                            failure: function(form, action) {
                                Ext.Msg.alert('失败', action.result.msg);
                                form.reset();
                            }
                        });
                    }
                }
            }]
        });
        //确保父类的initComponent方法也被调用
        this.callParent();
    },
    
    onSelectionChange: function(model, records) {
        var rec = records[0];
        if (rec) {
            this.getForm().loadRecord(rec);
        }
    }
});
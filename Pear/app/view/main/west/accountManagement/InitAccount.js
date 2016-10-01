/**
 * Created by Administrator on 10/1/2016.
 */
Ext.define('Pear.view.main.west.accountManagement.InitAccount', {
	extend: 'Ext.form.Panel',
    xtype: 'initAccount',
    
    requires: [
 	   'Pear.store.AccountTreeStore'
 	],
    //应用一个框架到这个panel
    frame: true,
    //框架标题
    title: '<center>初始化账户</center>',
    bodyPadding: 5,
    //这个panel中直接子items的排列方式，使用列布局
    layout: 'column',
//    controller: 'initAccount',
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
            width: 600,
            height: 420,
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
            	columnWidth: 0.45,
            	//这个子组件为Ext.grid.Panel组件
                xtype: 'treepanel',
                scrollable: true,
      //          rootVisible: false,
                displayField : 'text',
                width: 150,
                height: 320,
                store: Ext.create('Pear.store.AccountTreeStore')
            }, {
                columnWidth: 0.55,
                margin: '0 0 0 10',
                xtype: 'fieldset',
                title:'初始化',
                layout: 'anchor',
                defaultType: 'textfield',
              //字段的默认配置
                fieldDefaults: {
                	//表单的标签左对齐
                	labelAlign: 'left',
                	//在整个表单中标签列所占的宽度
                	labelWidth: 80
                },
                items: [{
                    fieldLabel: '账户名',
                    readOnly: true,
                    name: 'accountname'
                },{
                    fieldLabel: '账户ID',
                    name: 'accountid'
                },{
                	xtype: 'datefield',
                	fieldLabel: '初始化日期',
                    name: 'initdate'
                },{
                    fieldLabel: '金额',
                    name: 'amount'
                },{
                    fieldLabel: '摘要',
                    name: 'summary'
                }, {
                    xtype: 'radiogroup',
                    fieldLabel: '账户方向',
                    columns: 3,
                    defaults: {
                        name: 'direction' //Each radio has the same name so the browser will make sure only one is checked at once
                    },
                    items: [{
                        inputValue: '0',
                        boxLabel: '借'
                    }, {
                        inputValue: '1',
                        boxLabel: '贷'
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
    }
});
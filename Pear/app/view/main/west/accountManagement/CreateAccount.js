/**
 * Created by Administrator on 10/1/2016.
 */
Ext.define('Pear.view.main.west.accountManagement.CreateAccount', {
	extend: 'Ext.form.Panel',
	xtype: 'createAccount',
	
	requires: [
	   'Ext.ux.TreePicker',
	   'Pear.store.AccountTreeStore'
	],
	bodyPadding: 10,
	style: {
		margin: '100px auto'
		
	},
    width: 350,

    // The form will submit an AJAX request to this URL when submitted
    url: 'CreateAccount',

    // Fields will be arranged vertically, stretched to full width
    layout: 'anchor',
    defaults: {
        anchor: '100%',
        bodyStyle:{
        	backgroundColor: '#333666'
        }
    },

    // The fields
    defaultType: 'textfield',
    items: [{
        fieldLabel: '账户名称',
        name: 'accountname',
        allowBlank: false
    },{
        fieldLabel: '责任人',
        name: 'responsible',
        allowBlank: false
    },{
        fieldLabel: '责任人电话',
        name: 'contactphone',
        allowBlank: false,
        validator: function(val){
        	var tn = val.replace(/[^0-9]/g,'');
        	var errMsg = "必须是一个11位数字的电话号码";
        	return (tn.length === 11) ? true : errMsg;
        }
    },{
    	xtype: 'treepicker',
  //  	id: 'accountTree',
    	name: 'parentid',
    	fieldLabel: '上级账户',
    	displayField: 'text',
    	emptyText: '请选择上级账户',
    	allowBlank: false,
    	blankText: '不能是空',
    	store: Ext.create('Pear.store.AccountTreeStore')
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
/**
 * Created by Administrator on 10/1/2016.
 */
Ext.define('Pear.view.main.west.userManagement.CreateUser', {
	extend: 'Ext.form.Panel',
	xtype: 'createUser',
	
	requires: [
	           'Ext.form.RadioGroup'
	],
	
//	title: '增加功能菜单',
	bodyPadding: 10,
	
	style: {
		// 设置此panel居中
		margin: '100px auto'
		
	},
	//整个form表单的宽度
    width: 350,

    // The form will submit an AJAX request to this URL when submitted
    url: 'CreateUser',

    // Fields will be arranged vertically, stretched to full width
    layout: 'anchor',
    //这个配置选项表示应用默认的设置到所有增加的items中，不论是通过items配置还是经由add或insert方法增加的
    defaults: {
    	//每一行填充所有的宽度，在这里是350
        anchor: '100%',
        bodyStyle:{
        	backgroundColor: '#333666'
        }
    },

    // 放入到这个容器中的子组件的默认类型（xtype），默认是"panel"，在这里设置为'textfield'
    defaultType: 'textfield',
    //字段的默认配置
    fieldDefaults: {
    	//表单的标签左对齐
    	labelAlign: 'left',
    	//在整个表单中标签列所占的宽度
    	labelWidth: 100,
    	//错误提示信息显示的位置
    	msgTarget: 'under'
    },
    items: [{
        fieldLabel: '用户名',
        name: 'username',
        allowBlank: false
    },{
        fieldLabel: '密码',
        name: 'password',
        inputType : 'password',
        allowBlank: false
    },{
    	fieldLabel: '确认密码',
        name: 'repassword',
        inputType : 'password',
        allowBlank: false
    },{
        fieldLabel: '姓名',
        name: 'fullname',
        allowBlank: false
    },{
        fieldLabel: '电话',
        name: 'contactphone',
        allowBlank: false,
        validator: function(val){
        	var tn = val.replace(/[^0-9]/g,'');
        	var errMsg = "必须是一个11位数字的电话号码";
        	return (tn.length === 11) ? true : errMsg;
        }
    },{
    	fieldLabel: 'Email',
        name: 'email',
        vtype: 'email',
        allowBlank: true
    },{
    	fieldLabel: '单位',
        name: 'organization',
        allowBlank: false
    },{
	   	 xtype: 'radiogroup',
	     fieldLabel: '用户类型',
	     columns: 2,
	     vertical: true,
	     items: [
	         { boxLabel: '可用', name: 'usertype', inputValue: '1', checked: true },
	         { boxLabel: '禁用', name: 'usertype', inputValue: '0'}
	     ]
	},{
	   	 xtype: 'radiogroup',
	     fieldLabel: '用户状态',
	     columns: 2,
	     vertical: true,
	     items: [
	         { boxLabel: '可用', name: 'userstate', inputValue: '1', checked: true },
	         { boxLabel: '禁用', name: 'userstate', inputValue: '0'}
	     ]
	},{
		 xtype: 'radiogroup',
		 fieldLabel: '用户范围',
		 columns: 2,
		 vertical: true,
		 items: [
		    { boxLabel: '范围一', name: 'userscope', inputValue: '1'},    
		    { boxLabel: '范围一', name: 'userscope', inputValue: '0', checked: true}    
		 ]
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
                    },
                    failure: function(form, action) {
                        Ext.Msg.alert('失败', action.result.msg);
                    }
                });
            }
        }
    }]
});
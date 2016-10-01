/**
 * Created by Administrator on 9/9/2016.
 */
Ext.define('Pear.view.login.Dialog', {
	extend : 'Ext.window.Window',
    controller : 'login',
    referenceHolder: true,
    xtype: 'loginDialog',
    requires: ['Ext.form.Panel'],
    controller: 'loginCtrl',
    title : '系统登录',
    modal: false,
    width : 400,
    closable: true,
    items : [{
        xtype : 'form',
        reference : 'form',
        border : false,
        bodyPadding : 10,
        defaultType : 'textfield',
        url: 'UserLogin',
        defaults : {
            anchor : '90%',
            allowBlank : false,
            enableKeyEvents : true
        },
        items : [{
            xtype: 'component',
            reference: 'error',
            hidden: true,
            margin: '0 0 10 0',
            style: 'color: red;'
        }, {
            name : 'username',
            fieldLabel : '用户',
            reference : 'username',
            /*validator: function (val) {
                // remove non-numeric characters
                var tn = val.replace(/[^0-9]/g,''),
                    errMsg = "Must be a 10 digit telephone number";
                // if the numeric value is not 10 digits return an error message
                return (tn.length === 10) ? true : errMsg;
            },*/
            listeners : {
                specialkey : 'onFieldSpecialKey'
            }
        }, {
            name : 'password',
            fieldLabel : '密码',
            reference : 'password',
            inputType : 'password',
            listeners : {
                specialkey : 'onFieldSpecialKey'
            }
        }],
        buttons : ['->', {
            text : '登录',
            formBind: true,
             listeners : {
                 click : 'onLoginClick'
             }
         }]
    }]
});
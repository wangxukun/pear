/**
 * Created by Administrator on 9/30/2016.
 */
Ext.define('Pear.view.main.west.sysmgr.AddFunction', {
	extend: 'Ext.form.Panel',
	xtype: 'addFunction',
	
	requires: [
	           'Ext.form.RadioGroup'
	],
	
//	title: '增加功能菜单',
	bodyPadding: 10,
	style: {
		margin: '100px auto'
		
	},
    width: 350,

    // The form will submit an AJAX request to this URL when submitted
    url: 'AddFunction',

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
        fieldLabel: '功能菜单名称',
        name: 'capacityname',
        allowBlank: false
    },{
        fieldLabel: '功能菜单URL',
        name: 'url',
        allowBlank: false
    },{
    	fieldLabel: '功能菜单Icon',
        name: 'icon',
        allowBlank: false
    },{
	   	 xtype: 'radiogroup',
	     fieldLabel: '功能菜单状态',
	     columns: 1,
	     vertical: true,
	     items: [
	         { boxLabel: '可用', name: 'status', inputValue: '1', checked: true },
	         { boxLabel: '禁用', name: 'status', inputValue: '0'}
	     ]
	},{
    	 xtype: 'radiogroup',
         fieldLabel: '是否为顶级菜单',
         columns: 1,
         vertical: true,
         items: [
             { boxLabel: '是', name: 'accordion', inputValue: '0' },
             { boxLabel: '否', name: 'accordion', inputValue: '1', checked: true}
         ],
         listeners:{
        	 change: function(own,newValue,oldValue,eOpts){
        		 var cmp = Ext.getCmp('topFunction');
        		 if(newValue.accordion == '0'){
        			 cmp.setValue(['顶级菜单','0']);
        			 cmp.disable(true);
        		 }else{
        			 cmp.setValue(['','']);
        			 cmp.enable(true);
        		 }
        	 }
         }
    },{
    	fieldLabel: '显示位置',
    	name: 'serialnum',
    	emptyText: '需要换成tree或下拉列表'
    },{
    	xtype: 'combobox',
    	id: 'topFunction',
    	publishes: 'value',
    	fieldLabel: '上级菜单',
    	displayField: 'capacityname',
    	valueField: 'id',
    	store: {
    		type: 'topCapacitys'
    	},
    	minChars: 0,
//    	queryParam: 'query',
//    	queryMode: 'remote',
    	editable: false,
    	emptyText: '请选择一个功能菜单...',
    	triggerAction: 'all',
    	name: 'parentid'
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
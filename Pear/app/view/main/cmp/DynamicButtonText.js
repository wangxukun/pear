/**
 * Created by Administrator on 10/1/2016.
 */
Ext.define('Pear.view.main.cmp.DynamicButtonText', {
	extend: 'Ext.button.Button',
	
	initComponent: function(){
		this.text = new Date();
		this.renderTo = Ext.getBody();
		this.callParent();
	}
});
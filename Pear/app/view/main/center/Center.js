/**
 * Created by Administrator on 10/3/2016.
 */
Ext.define('Pear.view.main.center.Center', {
	extend: 'Ext.tab.Panel',
	
	xtype: 'centertab',
	
	requires: ['Pear.controller.main.center.CenterController'],
	
	id: 'tabs',
	activeTab: 0,      // First tab active by default
    items: {
        title: '开始页',
        glyph: 'xf015@FontAwesome',
        html: '各单位银行账户余额'//,
    //    items: Ext.create('Pear.view.main.cmp.DynamicButtonText')
    }
});
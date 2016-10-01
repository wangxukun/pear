/**
 * Created by Administrator on 10/1/2016.
 */
Ext.define('Pear.view.main.west.TreeList', {
	extend : 'Ext.panel.Panel',
	requires : [
	      'Pear.controller.main.west.TreeListController',
	      'Pear.store.TreeListStore',
	      'Pear.store.NavMenu'
	],
	xtype : 'tree-list',
	width : 250,
	layout : 'fit',
	controller : 'tree-list',

	cls : 'treelist-with-nav',
	scrollable : 'y',
	items : [ {
		xtype : 'treelist',
		reference : 'treelist',
		expanderOnly: false,
		selectOnExpander: true,
		singleExpand: true,
		ui : 'nav',
		store : Ext.create('Pear.store.TreeListStore'),
		listeners: {
			itemclick: 'onSelectNavItem'
		}
	} ]
});
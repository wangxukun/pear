/**
 * Created by Administrator on 10/1/2016.
 */
Ext.define('Pear.controller.main.west.TreeListController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.tree-list',
    
    requires: [
        'Pear.store.TopCapacitys',
        'Pear.store.TreeListStore',
        'Pear.store.NavMenu',
	    'Pear.view.main.west.sysmgr.AddFunction',
	    'Pear.view.main.west.userManagement.CreateUser',
	    'Pear.view.main.west.accountManagement.CreateAccount',
	    'Pear.view.main.west.userManagement.ModifyUser',
	    'Pear.view.main.west.userManagement.DelmodUser',
	    'Pear.view.main.west.accountManagement.InitAccount',
	    'Pear.view.main.west.dataQuery.QueryDetail',
	    'Pear.view.main.west.dataProcessing.InputData'
    ],

    init: function(){
    	var treelist = this.lookupReference('treelist');
    	//配置tree的三角箭头不在最前面，而在后面
    	treelist.setExpanderFirst(false);
    	treelist.setHighlightPath(true);
    	if (Ext.isIE8) {
            this.repaintList(treelist);
        }
    },
    repaintList: function(treelist, microMode) {
        treelist.getStore().getRoot().cascadeBy(function(node) {
            var item, toolElement;
            
            item = treelist.getItem(node);
            
            if (item && item.isTreeListItem) {
                if (microMode) {
                    toolElement = item.getToolElement();
                    
                    if (toolElement && toolElement.isVisible(true)) {
                        toolElement.syncRepaint();
                    }
                }
                else {
                    if (item.element.isVisible(true)) {
                        item.iconElement.syncRepaint();
                        item.expanderElement.syncRepaint();
                    }
                }
            }
        });
    },
    
    onSelectNavItem: function(sender,info,eOpts){
    	var model = info.item.getNode();
    	var id = model.get('id');
    	var parentid = model.get('parentid');
    	var text = model.get('text');
    	var url = model.get('url');
    	var icon = model.get('iconCls');
    	
    	console.log("ID ： "+id+" , 功能 ："+text+" , url："+url);
    	
    	var tabs = Ext.getCmp('tabs');
		var tab = tabs.getComponent(url);
		if (typeof tab === 'undefined' && parentid != 0) {
			tab = tabs.add({
				itemId : url,
				title : text,
				closable : true,
				iconCls : icon,
				items:[{
					xtype: url
				}]
			});
		}
		tabs.setActiveTab(tab);
    	
	}
});
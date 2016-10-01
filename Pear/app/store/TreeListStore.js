/**
 * Created by Administrator on 10/1/2016.
 */
Ext.define('Pear.store.TreeListStore', {
    extend: 'Ext.data.TreeStore',
    alias: 'store.treeliststore',
//    requires: ['Pear.model.TreeListModel'],
    model: 'Pear.model.TreeListModel',
    
    //	根节点的参数是parentId
    nodeParam: 'parentId',
    //	根节点的参数值是0
    defaultRootId: 0,
    root: {
    	expanded: true,
    	text: 'Nav Tree'
    }
});
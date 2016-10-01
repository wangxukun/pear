/**
 * Created by Administrator on 10/1/2016.
 */
Ext.define('Pear.store.AccountTreeStore', {
	extend : 'Ext.data.TreeStore',
	alias : 'store.accounttreestore',
	storeId : 'accounttreestore',
	requires: ['Pear.model.AccountTreeModel'],
	model: 'Pear.model.AccountTreeModel',

	// 根节点的参数是parentId
	nodeParam : 'parentId',
	// 根节点的参数值是0
	defaultRootId : 0,
	root : {
		expanded : true,
		text : '顶级账户'
	}
});
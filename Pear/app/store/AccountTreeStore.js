/**
 * Created by Administrator on 10/1/2016.
 */
Ext.define('Pear.store.AccountTreeStore', {
	extend : 'Ext.data.TreeStore',
	alias : 'store.accounttreestore',
	storeId : 'accounttreestore',
	requires: ['Pear.model.AccountTreeModel'],
	model: 'Pear.model.AccountTreeModel',

	// 节点的参数是名称parentId
	nodeParam : 'parentId',
	// 根节点发送的parentId参数值是1，这个属性有点问题
	//defaultRootId : 1,
	root : {
		id: 1,	//这个参数应该动态指定
		expanded : true,
		text : '三岔河镇农业综合服务中心'	//这个参数应该动态指定
	}
});
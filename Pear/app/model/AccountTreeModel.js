/**
 * Created by Administrator on 10/1/2016.
 */
Ext.define('Pear.model.AccountTreeModel', {
	extend : 'Ext.data.TreeModel',
	
	// 对应account表中accountid字段
	idProperty : 'id',
	/*identifier : {
		type : 'sequential',
		seed : 0
	},*/
	// 属性域
	fields : [
	{
		// 对应account表中accountname字段
		name : 'text',
		type : 'string'
	},{
    	//是否是叶子节点
		name: 'leaf',
    	type: 'boolean'
    }, {
		name : 'parentid',
		type : 'int'
	}, {
		//责任人
		name : 'responsible',
		type : 'string'
	}, {
		//电话
		name : 'contactphone',
		type : 'string'
	} ],
    proxy: {
		type: 'ajax',
		url: 'JsonAccountTree',
		reader: {
			type: 'json',
			rootProperty: 'accounttree'
		}
	}
});
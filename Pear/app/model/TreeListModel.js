/**
 * Created by Administrator on 10/1/2016.
 */
Ext.define('Pear.model.TreeListModel', {
    extend: 'Ext.data.TreeModel',
    
    idProperty: 'id',
    identifier: {
    	type: 'sequential',
    	seed: 0
    },
    //	属性域
    fields: [{
    	//对应capacity表中capacityname字段
    	name: 'text',
    	type: 'string'
    },{
    	name: 'iconCls',
    	type: 'string'
    },{
    	name: 'leaf',
    	type: 'boolean'
    },{
    	name: 'parentid',
    	type: 'int'
    },{
    	name: 'url',
    	type: 'string'
    },{
    	name: 'serialnum',
    	type: 'int'
    },{
    	name: 'accordion',
    	type: 'int'
    },{
    	name: 'status',
    	type: 'int'
    }],
    proxy: {
		type: 'ajax',
		url: 'JsonNavTree',
		reader: {
			type: 'json',
			rootProperty: 'navtree'
		}
	}
});
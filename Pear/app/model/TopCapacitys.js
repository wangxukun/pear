/**
 * Created by Administrator on 10/3/2016.
 * 
 * 用于在增加功能表单下的显示顶级功能菜单下拉列表中使用
 */
Ext.define('Pear.model.TopCapacitys', {

	extend : 'Pear.model.Base',
	requires: ['Pear.store.MenuItem'],
	fields: [
	         {
	         	name: 'capacityname',
	         	type: 'string'
	         },{
	         	name: 'parentid',
	         	type: 'int'
	         },{
	         	name: 'url',
	         	type: 'string'
	         },{
	         	name: 'icon',
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
	         }
	     ]
});
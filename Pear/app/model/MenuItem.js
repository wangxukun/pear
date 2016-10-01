/**
 * Created by Administrator on 10/5/2016.
 */
Ext.define('Pear.model.MenuItem', {
	extend : 'Pear.model.Base',

	fields : [ 
	    {
	    	name: 'topcapacitysId',
	    	reference: 'TopCapacitys',
	    	type: 'int'
	    }, {
			name : 'capacityname',
			type : 'string'
		}, {
			name : 'parentid',
			type : 'int'
		}, {
			name : 'url',
			type : 'string'
		}, {
			name : 'icon',
			type : 'string'
		}, {
			name : 'serialnum',
			type : 'int'
		}, {
			name : 'accordion',
			type : 'int'
		}, {
			name : 'status',
			type : 'int'
		} 
	]
});
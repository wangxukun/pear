/**
 * Created by Administrator on 10/1/2016.
 */
Ext.define('Pear.model.DelmodUserModel', {
    extend: 'Ext.data.Model',

    fields : [{
		name : 'username',
		type : 'string'
	}, {
		name : 'fullname',
		type : 'string'
	}, {
		name : 'contactphone',
		type : 'string'
	}, {
		name : 'email',
		type : 'string'
	}, {
		name : 'organization',
		type : 'string'
	}, {
		name : 'usertype',
		type : 'int'
	},{
		name : 'userstate',
		type : 'int'
	},{
		name : 'userscope',
		type : 'int'
	},{
		name : 'creationdate',
		type : 'date',
		dateFormat : 'Y-m-d H:i:s.u'
	},{
		name : 'updateddate',
		type : 'date',
		dateFormat : 'Y-m-d H:i:s.u'
	}],
    proxy: {
		type: 'ajax',
		url: 'JsonUsers',
		reader: {
			type: 'json',
			rootProperty: 'users'
		}
	}
});
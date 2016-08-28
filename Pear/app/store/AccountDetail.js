/**
 * Created by Administrator on 8/28/2016.
 */
Ext.define('Pear.store.AccountDetail', {
    extend: 'Ext.data.Store',

    model: 'Pear.model.AccountDetail',
    autoLoad: true,
    
  //  sorters: {property: 'occurdate', direction: 'ASC'},
    proxy: {	//Ext.util.ObjectTemplate
		type: 'ajax',
		url: 'JsonAccountDetail',
		reader: {
			type: 'json',
			rootProperty: 'accountdetail'
		}
	},
    groupDir: 'ASC',
    groupField: 'month'
});
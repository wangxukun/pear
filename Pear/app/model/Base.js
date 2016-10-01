/**
 * Created by Administrator on 9/20/2016.
 */
Ext.define('Pear.model.Base', {
    extend: 'Ext.data.Model',

    fields: [{
    	name: 'id',
        type: 'int'
    }],
    
    schema: {
    	namespace: 'Pear.model',	//generate auto entityName
    	
    	proxy: {	//Ext.util.ObjectTemplate
    		type: 'ajax',
    		url: 'Json{entityName}',
    		reader: {
    			type: 'json',
    			rootProperty: '{entityName:lowercase}'
    		}
    	}
    }
});
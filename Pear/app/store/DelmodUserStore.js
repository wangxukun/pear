/**
 * Created by Administrator on 10/1/2016.
 */
Ext.define('Pear.store.DelmodUserStore', {
    extend: 'Ext.data.Store',

    alias: 'store.delmodUserStore',
    
    model: 'Pear.model.DelmodUserModel',
    
    storeId: 'delmodUserStore',
    
    autoLoad: true
});
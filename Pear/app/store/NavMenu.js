/**
 * Created by Administrator on 10/1/2016.
 */
Ext.define('Pear.store.NavMenu', {
    extend: 'Ext.data.TreeStore',

    alias: 'store.navMenu',
    model: 'Pear.model.NavMenu',
    storeId: 'navMenu',
    
    data:[
       {id: 1, capacityname: 'ffffffff'},
       {id: 2, capacityname: 'bbbbbbbb'},
       {id: 3, capacityname: 'vvvvvvvv'}
    ]
});
/**
 * Created by Administrator on 8/28/2016.
 */
Ext.define('Pear.model.AccountDetail', {
    extend: 'Ext.data.Model',

    idProperty: 'id',
    fields: [
        {name: 'id', type: 'int'},
        {name: 'month', type: 'string'},
        {name: 'occurdate', type: 'date', dateFormat:'Y-m-d'},
        {name: 'number', type: 'int'},
        {name: 'summary', type: 'string'},
        {name: 'jie', type: 'float'},
        {name: 'dai', type: 'float'},
        {name: 'direction', type: 'int'},
        {name: 'balance', type: 'float'}
    ]
});
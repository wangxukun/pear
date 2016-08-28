/**
 * Created by Administrator on 8/28/2016.
 */
Ext.define('Pear.model.AccountDetail', {
    extend: 'Pear.model.Base',

    idProperty: 'id',
    fields: [
 //       {name: 'id', type: 'int'},
        {name: 'month', type: 'string'},
        {name: 'occurdate', type: 'date', dateFormat:'Y-m-d'},
        {name: 'number', type: 'int'},
        {name: 'summary', type: 'string'},
        {name: 'jie', type: 'float'},
        {name: 'dai', type: 'float'},
        {name: 'balance', type: 'float'}
    ]
});
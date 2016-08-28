/**
 * Created by Administrator on 8/28/2016.
 */
Ext.define('Pear.store.AccountDetail', {
    extend: 'Ext.data.Store',

    model: 'Pear.model.AccountDetail',
    autoLoad: true,
    
   /* data: [
        {id: 0, month: '0期初', occurdate:'',number: 0, summary: '期初余额', jie: 0, dai: 0},
        {id: 1, month: '1月', occurdate:'01/24/2007',number: 1, summary: '收到补助收入', jie: 6, dai: 150},
        {id: 2, month: '1月', occurdate:'01/25/2007', number: 2, summary: '收到补助收入', jie: 4, dai: 150},
        {id: 3, month: '1月', occurdate:'01/27/2007', number: 3, summary: '收到补助收入', jie: 4, dai: 150},
        {id: 4, month: '1月', occurdate:'01/29/2007', number: 4, summary: '收到补助收入', jie: 8, dai: 0},
        {id: 5, month: '2月', occurdate:'02/01/2007', number: 1, summary: '收到补助收入', jie: 6, dai: 100},
        {id: 6, month: '2月', occurdate:'02/03/2007', number: 2, summary: '收到补助收入', jie: 6, dai: 100},
        {id: 7, month: '2月', occurdate:'02/04/2007', number: 3, summary: '收到补助收入', jie: 4, dai: 100},
        {id: 8, month: '2月', occurdate:'02/05/2007', number: 4, summary: '收到补助收入', jie: 2, dai: 100},
        {id: 9, month: '2月', occurdate:'02/06/2007', number: 5, summary: '收到补助收入', jie: 6, dai: 100},
        {id: 10, month: '3月', occurdate:'03/01/2007', number: 1, summary: '收到补助收入', jie: 4, dai: 125},
        {id: 11, month: '3月', occurdate:'03/02/2007', number: 2, summary: '收到补助收入', jie: 4, dai: 125},
        {id: 12, month: '3月', occurdate:'03/05/2007', number: 3, summary: '收到补助收入', jie: 6, dai: 125},
        {id: 13, month: '3月', occurdate:'03/05/2007', number: 4, summary: '收到补助收入', jie: 4, dai: 125},
        {id: 14, month: '3月', occurdate:'03/06/2007', number: 5, summary: '收到补助收入', jie: 4, dai: 125},
        {id: 15, month: '3月', occurdate:'03/11/2007', number: 6, summary: '收到补助收入', jie: 10, dai: 125},
        {id: 16, month: '3月', occurdate:'03/15/2007', number: 7, summary: '收到补助收入', jie: 8, dai: 125}
    ],*/
  //  sorters: {property: 'occurdate', direction: 'ASC'},
    groupDir: 'ASC',
    groupField: 'month'
});
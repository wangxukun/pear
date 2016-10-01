/**
 * Created by Administrator on 10/1/2016.
 */
Ext.define('Pear.controller.main.west.usermgr.DelmodUserController', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.delmodUser',
    requires: ['Pear.store.DelmodUserStore'],
    config: {
        /*
        Uncomment to add references to view components
        refs: [{
            ref: 'list',
            selector: 'grid'
        }],
        */

        /*
        Uncomment to listen for events from view components
        control: {
            'useredit button[action=save]': {
                click: 'updateUser'
            }
        }
        */
    },

    /**
     * Called when the view is created
     */
    init: function() {
    	
    },
    // 删除用户处理函数
    delectUser: function(grid, rowIndex, colIndex) {
    	var rec = grid.getStore().getAt(rowIndex);
//      alert("删除 " + rec.get('fullname') + '--' + rec.get('username'));
    	Ext.Msg.show({
    	    title:'删除用户?',
    	    message: '你确定删除'+rec.get('organization')+'的'+rec.get('fullname')+'用户？',
    	    buttons: Ext.Msg.YESNO,
    	    icon: Ext.Msg.QUESTION,
    	    fn: function(btn) {
    	        if (btn === 'yes') {
    	        	Ext.Ajax.request({
    	          	  url: 'DeleteUser',
    	          	  params: 'userid='+rec.get('id'),
    	          	  method : 'GET',
    	          	  success: function(response,opts){
    	          		 var obj = Ext.decode(response.responseText);
    	          	//	 console.dir(obj);
    	          	//	 console.info(opts);
    	          		 
    	          		 Ext.Msg.alert('成功', obj.msg);
    	          	  },
    	          	  failure: function(response,opts){
    	          		var obj = Ext.decode(response.responseText);
    	          		Ext.Msg.alert('失败', obj.msg);
    	          	  }
    	             });
    	        } else {
    	            console.log('No pressed');
    	        } 
    	    }
    	});
    } 
});
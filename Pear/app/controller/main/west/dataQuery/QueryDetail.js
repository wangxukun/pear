/**
 * Created by Administrator on 8/28/2016.
 */
Ext.define('Pear.controller.main.west.dataQuery.QueryDetail', {
    extend: 'Ext.app.ViewController',

    alias: "controller.queryDetail",
    
    requires: ["Pear.store.AccountDetail"],
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
    onPrintClick:function(){
    	
    	var LODOP = Pear.config.Runtime.getLodop().getLodop();
    	if((LODOP==null)||(typeof(LODOP.VERSION)=="undefined")){
    		//
    	}else{
    		LODOP.PRINT_INIT("打印明细账");
    		//设置横向打印
    		LODOP.SET_PRINT_PAGESIZE(2,0,0,"A4");
    		//横向打印的正向显示
    		LODOP.SET_SHOW_MODE("LANDSCAPE_DEFROTATED",1);
    		LODOP.SET_PRINT_STYLE("FontSize",18);
    		LODOP.SET_PRINT_STYLE("Bold",1);
 //   		LODOP.ADD_PRINT_TEXT(20,460,500,39,"银行存款日记账");
 //   		LODOP.SET_PRINT_STYLE("FontSize",10);
 //   		LODOP.ADD_PRINT_TEXT(80,80,500,20,"单位:水阁村委会");
 //   		LODOP.ADD_PRINT_TEXT(80,500,500,20,"年度：2014年");
 //   		LODOP.ADD_PRINT_TEXT(80,960,500,20,"货币单位:元");
    		LODOP.SET_PRINT_STYLE("FontSize",18);
    		LODOP.ADD_PRINT_TBURL(20,60,"100%","100%","HTMLAccountDetail");
    		LODOP.PREVIEW();
    	}
    }
});
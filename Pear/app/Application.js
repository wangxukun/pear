/**
 * The main application class. An instance of this class is created by app.js when it
 * calls Ext.application(). This is the ideal place to handle application launch and
 * initialization details.
 */
Ext.define('Pear.Application', {
    extend: 'Ext.app.Application',
    
    name: 'Pear',

    requires:[
              'Pear.view.main.Main',
              'Pear.view.login.Login',
              'Pear.view.login.Dialog',
              'Pear.store.TopCapacitys'
          ],
    stores: [
        // TODO: add global / shared stores here
    ],
    init: function(){
    	/**
    	 * 解决这个警告：
    	 * [W] Panel panel-1010 is a region section of the application, 
    	 * but it does not have a title. Per WAI-ARIA, 
    	 * all regions should have a heading element that contains region's title.
		 * [W] Panel tabs is a region section of the application, but it does not have a title.
		 *  Per WAI-ARIA, all regions should have a heading element that contains region's title.
		 * 
		 * Ext.enableAriaPanels 设置为 false
    	 */
    	Ext.enableAriaPanels= false;
    },
    launch: function () {
        // TODO - Launch the application
    	var loggedIn;
    	loggedIn = localStorage.getItem("PearLoggedIn");
    	Ext.create({
    		xtype: loggedIn ? 'app-main' : 'login'
    	});
    },

    onAppUpdate: function () {
        Ext.Msg.confirm('Application Update', 'This application has an update, reload?',
            function (choice) {
                if (choice === 'yes') {
                    window.location.reload();
                }
            }
        );
    }
});

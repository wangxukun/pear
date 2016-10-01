/**
 * This class is the main view for the application. It is specified in app.js as the
 * "mainView" property. That setting automatically applies the "viewport"
 * plugin causing this view to become the body element (i.e., the viewport).
 *
 * TODO - Replace this content of this view to suite the needs of your application.
 */
Ext.define('Pear.view.main.Main', {
	extend: 'Ext.container.Viewport',
	
	xtype: 'app-main',
	plugins: 'viewport',
	requires: [
	    'Ext.plugin.Viewport',
	    'Ext.window.MessageBox',
	    'Pear.view.main.west.TreeList',
	    'Pear.view.main.north.North',
	    'Pear.view.main.center.Center'
	],
	layout: 'border',
    items: [{
        region: 'north',
        height: 80,
        border: false,
        margin: '0 0 5 0',
        items:[{
        	xtype: 'north'
        }]
    }, {
        region: 'west',
        collapsible: true,
        layout: 'fit',
        title: '导航',
        width: 250,
        // could use a TreePanel or AccordionLayout for navigational items
        items:[{
        	xtype: 'tree-list'
        }]
    }, {
        region: 'center',
        xtype: 'centertab' // TabPanel itself has no title
    }]
});

/**
 * Created by Administrator on 9/21/2016.
 * 所有的全局变量在此定义为此类的属性，需要使用时，使用setter和getter调用
 */
Ext.define('Pear.config.Runtime', {
	singleton: true,
	config: {
		//	在此定义全局变量并初始化
		navTreeRoot : {}
	},
	constructor: function(config){
		this.initConfig(config);
	}
});
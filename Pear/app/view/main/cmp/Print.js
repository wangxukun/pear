/**
 * Created by Administrator on 10/1/2016.
 */
Ext.define('Pear.view.main.cmp.Print', {
	name: 'Printer',
	
	constructor: function(name){
		this.name = name;
	},
	
	createdOKLodop7766: null,

	//====获取LODOP对象的主过程：====
	getLodop: function(oOBJECT,oEMBED){
	    var strHtmInstall="<br><font color='#FF00FF'>打印控件未安装!点击这里<a href='install_lodop32.exe' target='_self'>执行安装</a>,安装后请刷新页面或重新进入。</font>";
	    var strHtmUpdate="<br><font color='#FF00FF'>打印控件需要升级!点击这里<a href='install_lodop32.exe' target='_self'>执行升级</a>,升级后请重新进入。</font>";
	    var strHtm64_Install="<br><font color='#FF00FF'>打印控件未安装!点击这里<a href='install_lodop64.exe' target='_self'>执行安装</a>,安装后请刷新页面或重新进入。</font>";
	    var strHtm64_Update="<br><font color='#FF00FF'>打印控件需要升级!点击这里<a href='install_lodop64.exe' target='_self'>执行升级</a>,升级后请重新进入。</font>";
	    var strHtmFireFox="<br><br><font color='#FF00FF'>（注意：如曾安装过Lodop旧版附件npActiveXPLugin,请在【工具】->【附加组件】->【扩展】中先卸它）</font>";
	    var strHtmChrome="<br><br><font color='#FF00FF'>Chrome浏览器不支持打印功能。</font>";
	    var strHtmEdge="<br><br><font color='#FF00FF'>Edge浏览器不支持打印功能。</font>";
	    var strHtm="";
	    var LODOP;
	    try{
	        var isIE = (navigator.userAgent.indexOf('MSIE')>=0) || (navigator.userAgent.indexOf('Trident')>=0);
            var is64IE  = isIE && (navigator.userAgent.indexOf('x64')>=0);
            //=====如果页面有Lodop就直接使用，没有则新建:==========
            if (oOBJECT!=undefined || oEMBED!=undefined) {
                if (isIE) 
                	LODOP=oOBJECT; 
                else  
                	LODOP=oEMBED;
            } else if (this.createdOKLodop7766==null){
            	LODOP=document.createElement("object");
            	LODOP.setAttribute("width",0);
            	LODOP.setAttribute("height",0);
            	LODOP.setAttribute("style","position:absolute;left:0px;top:-100px;width:0px;height:0px;");
                if (isIE) 
                	LODOP.setAttribute("classid","clsid:2105C259-1E0C-4534-8141-A753534CB4CA");
                else 
                	LODOP.setAttribute("type","application/x-print-lodop");
                document.documentElement.appendChild(LODOP);
                this.createdOKLodop7766=LODOP;
             } else{
            	 LODOP=this.createdOKLodop7766; 
             } 
            //=====Lodop插件未安装时提示下载地址:==========
            if ((LODOP==null)||(typeof(LODOP.VERSION)=="undefined")) {
            	 if (navigator.userAgent.indexOf('Chrome')>=0){
            		 strHtm += strHtmChrome;
//               	 document.documentElement.innerHTML=strHtmChrome+document.documentElement.innerHTML;
                 }
                 if (navigator.userAgent.indexOf('Firefox')>=0){
                	 strHtm += strHtmFireFox;
//                	 document.documentElement.innerHTML=strHtmFireFox+document.documentElement.innerHTML;
                 }
                 if (navigator.userAgent.match(/Edge\D?\d+/i) != null){
               	     strHtm += strHtmEdge;
//               	 document.documentElement.innerHTML=strHtmEdge+document.documentElement.innerHTML;
                 }
                     
                 if (is64IE){
                	 strHtm += strHtm64_Install;
//                	 document.write(strHtm64_Install);
                 } 
                 else if (isIE){
                	 strHtm += strHtmInstall;
//                	 document.write(strHtmInstall);
                 }   
                 else{
                	 strHtm += strHtmInstall;
//                	 document.documentElement.innerHTML=strHtmInstall+document.documentElement.innerHTML;
                	 Ext.toast({
	            	     html: strHtm,
	            	     title: '打印错误',
	            	     width: 400,
	            	     height: 200,
	            	     align: 'b'
	            	 });
                 }
                 return LODOP;
            };
	        if (LODOP.VERSION<"6.2.0.8") {
	            if (is64IE){
	            	strHtm += strHtm64_Update;
//	            	document.write(strHtm64_Update);
	            } 
	            else if (isIE){
	            	strHtm += strHtmUpdate;
//	            	document.write(strHtmUpdate);
	            } 
	            else{
	            	strHtm += strHtmUpdate;
//	            	document.documentElement.innerHTML=strHtmUpdate+document.documentElement.innerHTML;
	            }
	            return LODOP;
	        };
	        //===如下空白位置适合调用统一功能(如注册语句、语言选择等):===

	        //===========================================================
	        return LODOP;
	    } catch(err) {alert("getLodop出错:"+err);};
	},
	CheckIsInstall: function() {	 
		try{ 
		     var LODOP=this.getLodop(); 
			if (LODOP.VERSION) {
				 if (LODOP.CVERSION)
				 alert("当前有C-Lodop云打印可用!\n C-Lodop版本:"+LODOP.CVERSION+"(内含Lodop"+LODOP.VERSION+")"); 
				 else
				 alert("本机已成功安装了Lodop控件！\n 版本号:"+LODOP.VERSION); 

			};
		 }catch(err){ 
			 alert(err);
 		 } 
	}
});
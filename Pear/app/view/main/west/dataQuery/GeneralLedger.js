/**
 * Created by Administrator on 10/1/2016.
 */
Ext.define('Pear.view.main.west.dataQuery.GeneralLedger', {
	/**
	 * This example shows how a grid can have its store and columns reconfigured dynamically.
	 * By default, we start with no store or columns, we can define them later using the
	 * reconfigure method.
	 */
    extend: 'Ext.container.Container',
   
    requires: [
        'Ext.grid.*',
        'Ext.layout.container.HBox',
        'Ext.layout.container.VBox',
        'Pear.model.Office',
        'Pear.model.Employee'
    ], 
    xtype : 'generalLedger',
    
    
    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    
    width: '100%',
	height : 840,
	padding : 20,
    
    lastNames: ['Jones', 'Smith', 'Lee', 'Wilson', 'Black', 'Williams', 'Lewis', 'Johnson', 'Foot', 'Little', 'Vee', 'Train', 'Hot', 'Mutt'],
    firstNames: ['Fred', 'Julie', 'Bill', 'Ted', 'Jack', 'John', 'Mark', 'Mike', 'Chris', 'Bob', 'Travis', 'Kelly', 'Sara'],
    cities: ['New York', 'Los Angeles', 'Chicago', 'Houston', 'Philadelphia', 'Phoenix', 'San Antonio', 'San Diego', 'Dallas', 'San Jose'],
    departments: ['Development', 'QA', 'Marketing', 'Accounting', 'Sales'],
    
    initComponent: function(){
        Ext.apply(this, {
            items: [{
                xtype: 'toolbar',
                items: [ {
        			xtype : 'treepicker',
//        			id : 'accountTree',
        			name : 'parentid',
        			fieldLabel : '查询账户',
        			width : 300,
        			labelWidth : 60,
        			displayField : 'text',
        			emptyText : '请选择要查询的账户',
        			allowBlank : false,
        			blankText : '不能是空',
        			store : Ext.create('Pear.store.AccountTreeStore')
        		}, {
        			xtype : 'datefield',
        			fieldLabel : '起止日期',
        			width : 250,
        			labelWidth : 60,
        			name : 'start'
        		}, {
        			xtype : 'datefield',
        			width : 200,
        			labelWidth : 10,
        			labelSeparator: '',
        			fieldLabel : '-',
        			name : 'end'
        		}, {
        	        xtype: 'button',
        	        itemId: 'showEmployees',
        	        text: '明细查询',
        	        scope: this,
                    handler: this.onShowEmployeesClick
        	    },{
        	        xtype: 'button',
        	        itemId: 'showOffices',
        	        text: '总账查询',
                    scope: this,
                    handler: this.onShowOfficesClick
        	    }, '->', {
        	        xtype: 'button',
        	        text: '打印',
        	        scope: this,
        	        handler: this.onPrintClick
        	    }, {
        	        xtype: 'button',
        	        text: '导出'
        	    }]
                
            },{
                margin: '10 0 0 0',
                xtype: 'grid',
                ui : 'highlight-framed',
                border : true,
                flex: 1,
                columns: [],
                viewConfig: {
                    emptyText: 'Click a button to show a dataset',
                    deferEmptyText: false
                }
            }]    
        });
        this.callParent();
    },
    
    onShowOfficesClick: function(){
        var grid = this.down('grid');
        
        Ext.suspendLayouts();
        grid.setTitle('Offices');
        grid.reconfigure(this.createOfficeStore(), [{
            flex: 1,
            text: 'City',
            dataIndex: 'city'
        }, {
            text: 'Total Employees',
            dataIndex: 'totalEmployees',
            width: 140
        }, {
            text: 'Manager',
            dataIndex: 'manager',
            width: 120
        }]);
        this.down('#showEmployees').enable();
        this.down('#showOffices').disable();
        Ext.resumeLayouts(true);  
    },
    
    onShowEmployeesClick: function(){
        var grid = this.down('grid');
        
        Ext.suspendLayouts();
        grid.setTitle('Employees');
        grid.reconfigure(this.createEmployeeStore(), [{
            text: 'First Name',
            dataIndex: 'forename'
        }, {
            text: 'Last Name',
            dataIndex: 'surname'
        }, {
            width: 130,
            text: 'Employee No.',
            dataIndex: 'employeeNo'
        }, {
            flex: 1,
            text: 'Department',
            dataIndex: 'department'
        }]);
        this.down('#showOffices').enable();
        this.down('#showEmployees').disable();
        Ext.resumeLayouts(true);
    },
    
    onPrintClick:function(){
    	var LODOP = Pear.config.Runtime.getLodop().getLodop();
    	if((LODOP==null)||(typeof(LODOP.VERSION)=="undefined")){
    		//
    	}else{
    		LODOP.PRINT_INIT("打印控件功能演示_Lodop功能_表单一");
    		LODOP.SET_PRINT_STYLE("FontSize",18);
    		LODOP.SET_PRINT_STYLE("Bold",1);
    		LODOP.ADD_PRINT_TEXT(50,231,260,39,"打印页面部分内容");
    		LODOP.PREVIEW();
    	}
    },
    
    createEmployeeStore: function(){
        var data = [],
            i = 0,
            usedNames = {},
            name;
                
        for (; i < 20; ++i) {
            name = this.getUniqueName(usedNames);
            data.push({
                forename: name[0],
                surname: name[1],
                employeeNo: this.getEmployeeNo(),
                department: this.getDepartment()
            });
        }
        return new Ext.data.Store({
            model: Pear.model.Employee,
            data: data
        });
    },
    
    createOfficeStore: function(){
        var data = [],
            i = 0,
            usedNames = {},
            usedCities = {};
                
        for (; i < 7; ++i) {
            data.push({
                city: this.getUniqueCity(usedCities),
                manager: this.getUniqueName(usedNames).join(' '),
                totalEmployees: Ext.Number.randomInt(10, 25)
            });
        }
        return new Ext.data.Store({
            model: Pear.model.Office,
            data: data
        });
    },
    
    // Fake data generation functions
    generateName: function(){
        var lasts = this.lastNames,
            firsts = this.firstNames,
            lastLen = lasts.length,
            firstLen = firsts.length,
            getRandomInt = Ext.Number.randomInt,
            first = firsts[getRandomInt(0, firstLen - 1)],
            last = lasts[getRandomInt(0, lastLen - 1)];
        
        return [first, last];
    },
    
    getUniqueName: function(used) {
        var name = this.generateName(),
            key = name[0] + name[1];
            
        if (used[key]) {
            return this.getUniqueName(used);
        }
    
        used[key] = true;
        return name;
    },
    
    getCity: function(){
        var cities = this.cities,
            len = cities.length;
        
        return cities[Ext.Number.randomInt(0, len - 1)];
    },
    
    getUniqueCity: function(used){
        var city = this.getCity();
        if (used[city]) {
            return this.getUniqueCity(used);
        }
    
        used[city] = true;
        return city;
    },
    
    getEmployeeNo: function() {
        var out = '',
            i = 0;
        for (; i < 6; ++i) {
            out += Ext.Number.randomInt(0, 7);
        }
        return out;
    },
    
    getDepartment: function() {
        var departments = this.departments,
            len = departments.length;
        
        return departments[Ext.Number.randomInt(0, len - 1)];
    }
});
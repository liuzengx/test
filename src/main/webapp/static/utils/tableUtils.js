/**
 * Created by majunpeng on 2017/3/23.
 */
var tableUtils =  (function ($) {
    var tmp = {}                        //用来存储一些临时变量
    var obj = {
        excelExportUrl          :       tsUtils.getRootPath()+'/exportExcel',
        tableId                 :       '',
        printCurrentDataHtml    :       '',
        printSelectDataHtml     :       '',
        headers                 :       [],
        headerData              :       [],
        columnData              :       [],
        allData                 :       [],
        selectData              :       [],
        currentPageData         :       [],

        init                    :       init,
        popWindow               :       popWindow,
        doPrint                 :       doPrint,
        getHeaderData           :       getHeaderData,
        getColumnData           :       getColumnData,
        getAllData              :       getAllData,
        getSelectData           :       getSelectData,
        getCurrentPageData      :       getCurrentPageData,
        getPrintCurrentDataHtml :       getPrintCurrentDataHtml,
        getPrintSelectDataHtml  :       getPrintSelectDataHtml,
        exportTableToExcel      :       exportTableToExcel,
    };
    return obj;

    /**
     * 初始化table
     * @param tableId
     * 各项操作之前必须调用一次init(tableId),为了将tableId 赋值给 tableUtils对象供内部调用
     */
    function init(tableId) {
        /*初始化table Id*/
        tableUtils.tableId              = tableId;
        /*初始化headerData*/
        tableUtils.headerData           = tableUtils.getHeaderData();
        /*初始化columnData*/
        tableUtils.columnData           = tableUtils.getColumnData();
        /*初始化allData*/
        tableUtils.allData              = tableUtils.getAllData();
        /*初始化selectData*/
        tableUtils.selectData           = tableUtils.getSelectData();
        /*初始化currentPageData*/
        tableUtils.currentPageData      = tableUtils.getCurrentPageData();

        console.log('columnData');
        console.log(tableUtils.columnData);
        console.log('headerData');
        console.log(tableUtils.headerData);
        console.log('allData');
        console.log(tableUtils.allData);

    }

    /**
     * 获取头部的data
     * 一般外部不调用,调用之前必须调用tableUtils.init(tableId),调用一次即可
     * tableUtils.getHeaderData()
     */
    function getHeaderData() {
        var tableId = tableUtils.tableId;
        var headers = $('#'+tableId).bootstrapTable('getOptions').columns;
        var headerArray = [];
        for(var i = 0 ; i < headers.length ; i++){
            var rowArray = [];
            for(var j = 0 ; j < headers[i].length ; j ++){
                if(headers[i][j].field != 'state'){
                    var obj = headers[i][j];
                    var node = {};
                    node.align      = typeof (obj.align) == 'undefined'?'left':obj.align;
                    node.title      = obj.title;
                    node.colspan    = typeof (obj.colspan) == 'undefined'?1:obj.colspan;
                    node.field      = typeof (obj.field) == 'undefined'?'':obj.field;
                    rowArray.push(node);
                }
            }
            headerArray.push(rowArray);
        }

        // return headerArray;
        return headers;
    }

    /**
     * 获取表头的data
     * 一般外部不调用,调用之前必须调用tableUtils.init(tableId),调用一次即可
     * tableUtils.getColumnData()
     */
    function getColumnData() {
        var tableId = tableUtils.tableId;
        var columnData = $('#'+tableId).bootstrapTable('getVisibleColumns');

        var columnArray = [];
        for(var i = 0 ; i < columnData.length ; i++){

            var obj     = columnData[i];
			if(obj.visible == false){
				continue;
			}
            var column  = {};
			column.width    = obj.width;
			column.field    = obj.field;
			column.title    = obj.title;
			column.align    = typeof (obj.align) == 'undefined'?'left':obj.align;
			column.colspan  = typeof (obj.colspan) == 'undefined'?1:obj.colspan;
			tableUtils.headers.push(obj.field);
			columnArray.push(column);
        }
        return columnArray;
        
    }

    /**
     * 获取所有数据
     * 一般外部不调用,调用之前必须调用tableUtils.init(tableId),调用一次即可
     * tableUtils.getAllData()
     */
    function getAllData(){
        var tableId     = tableUtils.tableId;
        var data        = $('#'+tableId).bootstrapTable('getData',false);
        var dataArray   = [];

        for(var i = 0 ; i < data.length ; i++){
            var obj     = data[i];
            var node    = {};
            var headers = tableUtils.headers;
            for(var j = 0 ; j < headers.length ; j ++){
                var key     = headers[j];
                node[key]   = obj[key];
            }
            dataArray.push(node);
        }
        return dataArray;

    }

    /**
     * 获取选中的数据
     * 一般外部不调用,调用之前必须调用tableUtils.init(tableId),调用一次即可
     * tableUtils.getSelectData()
     */
    function getSelectData() {
        var tableId     = tableUtils.tableId;
        var data        = $('#'+tableId).bootstrapTable('getSelections');
        var dataArray   = [];

        for(var i = 0 ; i < data.length ; i++){
            var obj     = data[i];
            var node    = {};
            var headers = tableUtils.headers;
            for(var j = 0 ; j < headers.length ; j ++){
                var key     = headers[j];
                node[key]   = obj[key];
            }
            dataArray.push(node);
        }
        return dataArray;
    }

    /**
     * 获取当前页的数据
     * 一般外部不调用,调用之前必须调用tableUtils.init(tableId),调用一次即可
     * tabUtils.getCurrentPageData()
     */
    function getCurrentPageData() {
        var tableId     = tableUtils.tableId;
        var data        = $('#'+tableId).bootstrapTable('getData',true);
        var dataArray   = [];

        for(var i = 0 ; i < data.length ; i++){
            var obj     = data[i];
            var node    = {};
            var headers = tableUtils.headers;
            for(var j = 0 ; j < headers.length ; j ++){
                var key     = headers[j];
                node[key]   = obj[key];
            }
            dataArray.push(node);
        }
        return dataArray;
    }

    function getAllDataHtml() {

    }

    /**
     * 获取打印当前页的html
     * 一般外部不调用,调用之前必须调用tableUtils.init(tableId),多项操作前调用一次即可
     * tableUtils.getPrintCurrentDataHtml();
     */
    function getPrintCurrentDataHtml() {
        var allData         = tableUtils.allData;
        var columns         = tableUtils.columnData;
        var headerData      = tableUtils.headerData;
        var printHtml       = '';

        printHtml += '<table border="0" cellspacing="0" cellpadding="0" style="margin-left:auto;margin-right:auto;width: 90%;border:1px solid grey"><thead>';

        for(var i = 0 ; i < headerData.length ;  i ++ ){
            var headerArray = headerData[i];
			printHtml += '<tr>';
			for(var j = 0 ; j < headerArray.length ; j++ ){
				var obj = headerArray[j];
				printHtml += '<th colspan="'+obj.colspan+'" rowspan="'+obj.rowspan+'" style="text-align: '+obj.align+';border-right: 1px solid black;font-weight: bold;border-bottom: 1px solid black">'+obj.title+'</th>';
            }
			printHtml += '</tr>';
        }

        printHtml +='</thead><tbody>';


        for(var i = 0 ; i < allData.length ; i++ ){
            printHtml += '<tr>';
            for (var j = 0 ; j < columns.length ; j ++ ){
                if(columns[j].field == 'state' && allData[i][columns[j].field] == true ){
					printHtml+="<th colspan='"+columns[j].colspan+"' style='border-right: 1px solid black;border-bottom: 1px solid black;font-weight:normal;text-align: center'>" + '√' + '</th>'
                }else if(columns[j].field == 'state' && (typeof allData[i][columns[j].field] == 'undefined') || allData[i][columns[j].field] == false ){
					printHtml+="<th colspan='"+columns[j].colspan+"' style='border-right: 1px solid black;border-bottom: 1px solid black;font-weight:normal;text-align: center'>" + '' + '</th>'
                }else{
					printHtml+="<th colspan='"+columns[j].colspan+"' style='border-right: 1px solid black;border-bottom: 1px solid black;font-weight:normal;text-align: "+columns[j].align+"'>" + allData[i][columns[j].field] + '</th>'
                }
            }
            printHtml += '</tr>';
        }

        printHtml+='</tbody></table>';
        return printHtml;
    }

    /**
     * 获取打印选择项目的html
     * 一般外部不调用,调用之前必须调用tableUtils.init(tableId),多项操作前调用一次即可
     * tableUtils.getPrintSelectDataHtml();
     */
    function getPrintSelectDataHtml() {

        var selectData      = tableUtils.selectData;
        var columns         = tableUtils.columnData;
        var headerData      = tableUtils.headerData;
        var printHtml       = '';

        printHtml += '<table border="0" cellspacing="0" cellpadding="0" style="margin-left:auto;margin-right:auto;width: 90%;border:1px solid grey"><thead>';
		for(var i = 0 ; i < headerData.length ;  i ++ ){
			var headerArray = headerData[i];
			printHtml += '<tr>';
			for(var j = 0 ; j < headerArray.length ; j++ ){
				var obj = headerArray[j];
				printHtml += '<th colspan="'+obj.colspan+'" rowspan="'+obj.rowspan+'" style="text-align: '+obj.align+';border-right: 1px solid black;font-weight: bold;border-bottom: 1px solid black">'+obj.title+'</th>';
			}
			printHtml += '</tr>';
		}
        printHtml +='</thead><tbody>';


        for(var i = 0 ; i < selectData.length ; i++ ){
            printHtml += '<tr>';
            for (var j = 0 ; j < columns.length ; j ++ ){
				if(columns[j].field == 'state' && selectData[i][columns[j].field] == true ){
					printHtml+="<th colspan='"+columns[j].colspan+"' style='border-right: 1px solid black;border-bottom: 1px solid black;font-weight:normal;text-align: center'>" + '√' + '</th>'
				}else if(columns[j].field == 'state' && (typeof selectData[i][columns[j].field] == 'undefined') || selectData[i][columns[j].field] == false ){
					printHtml+="<th colspan='"+columns[j].colspan+"' style='border-right: 1px solid black;border-bottom: 1px solid black;font-weight:normal;text-align: center'>" + '' + '</th>'
				}else{
					printHtml+="<th colspan='"+columns[j].colspan+"' style='border-right: 1px solid black;border-bottom: 1px solid black;font-weight:normal;text-align: "+columns[j].align+"'>" + selectData[i][columns[j].field] + '</th>'
				}
            }
            printHtml += '</tr>';
        }

        printHtml+='</tbody></table>';
        return printHtml;
    }

    /**
     * 执行打印
     * @param type type表示打印的种类   打印当前页和打印选择的数据  分别为'select'和'current'
     * 执行该方法之前必须调用tableUtils.init(tableId)方法,调用一次即可
     * tableUtils.doPrint('select')或者 tableUtils.doPrint('current');
     */
    function doPrint(type) {
        if(typeof (type) == 'undefined'){
            var newWin      = window.open('about:blank');
            var printHtml   = tableUtils.getPrintCurrentDataHtml()
            newWin.document.write("<head><title>testTitle</title></head><body><span style='color:red;'>" + printHtml + "</span></body>");
            newWin.document.location.reload();
            newWin.print();
        }else if(type == 'select'){
            var newWin      = window.open('about:blank');
            var printHtml   = tableUtils.getPrintSelectDataHtml()
            newWin.document.write("<head><title>testTitle</title></head><body><span style='color:red;'>" + printHtml + "</span></body>");
            newWin.document.location.reload();
            newWin.print();
        }else{
            var printHtml = tableUtils.getPrintCurrentDataHtml();
            var newWin = window.open('about:blank');
            newWin.document.write("<head><title>testTitle</title></head><body><span>" + '<div style="width: 100%;text-align: center">testTitle</div>' + printHtml + "</span></body>");
            newWin.document.location.reload();
            newWin.print();
        }
        return
    }

    /**
     * 弹出操作框
     */
    function popWindow() {
        var printHtml = tableUtils.getPrintCurrentDataHtml();
        var type      = 'select';
        var layerHtml = '<div style="width: 100%;height: 100%">'+
            '<div style="padding-left: 30px;padding-top: 20px;padding-bottom: 20px">'+
            '<button style="float: left;margin: 5px;" class="btn btn-primary" onclick="tableUtils.exportTableToExcel(1)"><span class="glyphicon glyphicon-save"></span>导出</button>'+
            '<button style="float: left;margin: 5px;" class="btn btn-primary" onclick="tableUtils.doPrint()"><span class="glyphicon glyphicon-save"></span>打印</button>'+
            '<div style="clear: both"></div></div>'+printHtml+'</div>';

        layer.open({
            type: 1,
            title: false,
            area: ['700px', '530px'],
            closeBtn: 0,
            shadeClose: true,
            content: layerHtml
        });
    }

    /**
     * 导出table 为 excel
     * @param type 种类 0:获得所有的数据,1:获得当前页面的数据,2:获得选择的数据
     * tableUtils.exportTableToExcel(0);
     * 调用之前 必须调用 tableUtils.init(tableId);
     */
    function exportTableToExcel(type) {
        var exportHtml;

        switch (type){
            case 0:
                exportHtml = getAllDataHtml();
                break;
            case 1:
                exportHtml = getPrintCurrentDataHtml();
                break;
            case 2:
                exportHtml = getPrintSelectDataHtml();
        }

		//
        // if(tsUtils.getExplorer() == 'ie'){
        //     ieExportExcel(type);
        //     return
        // }
		ieExportExcel(type);
		return;
        
    }
    
    function ieExportExcel(type) {
        var exportData;
        var headerData = getHeaderData();
        var columnData = getColumnData();
        switch (type){
            case 0:
                exportData = getAllData();
                break;
            case 1:
                exportData = getCurrentPageData();
                break;
            case 2:
                exportData = getSelectData();
                break;
        }
        var postData = {
            headerData: headerData,
            columns:columnData,
            rows:exportData,
            footer:'testFooter',
            title:'testTitle'
        };

        exportExcel(tableUtils.excelExportUrl,'post',JSON.stringify(postData));

    }

    function exportExcel(url,method,data) {
        var form=$("<form>");//定义一个form表单
        form.attr("style","display:none");
        form.attr("accept-charset","UTF-8");
        form.attr("target","");
        form.attr("method","post");
        form.attr("action",url);
        var input1=$("<input>");
        input1.attr("type","hidden");
        input1.attr("name","fileData");
        input1.attr("value",data);
        $("body").append(form);//将表单放置在web中
        form.append(input1);
        form.submit();
    }
})(jQuery);
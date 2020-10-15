$(function(){
	var bar = echarts.init(document.getElementById('stockDataYKAnalysis_bar_echarts'),'macarons');
	var line2 = echarts.init(document.getElementById('stockDataYKAnalysis_line_echarts'),'macarons');
	
	var arg1 = 0;
	var arg2 = 0;
	var fCode = $("#stock_view_list_fcode").val();
	var fName = $("#stock_view_list_fname").combobox('getValue');
	//var arg2= $("input[name='radioOptionsExample1']:checked").val();
	
	loadbar(arg1,arg2,fCode,fName);
	loadline2(arg1,arg2,fCode,fName);
	
	window.onresize = function() {
		bar.resize();
		line2.resize();
	};
	
	//查询事件
	$("#stock_view_list_search").click(function(){
		var arg1 = 0;
		var arg2 = 0;
		var fCode = $("#stock_view_list_fcode").val();
		var fName = $("#stock_view_list_fname").combobox('getValue');
		loadbar(arg1,arg2,fCode,fName);
		loadline2(arg1,arg2,fCode,fName);
	});
	
	//加载柱形图
	function loadbar(arg1,arg2,fCode,fName){
		bar.setOption({
			title : {
		        text: '收益分析'
		    },
		    tooltip : {
		        trigger: 'axis'
		    },
		    legend: {
		        data:['收益']
		    },
		    toolbox: {
		        show : true,
		        feature : {
		            mark : {show: true},
		            dataView : {show: true, readOnly: false},
		            magicType : {show: true, type: ['line', 'bar']},
		            restore : {show: true},
		            saveAsImage : {show: true}
		        }
		    },
		    calculable : true,
		    xAxis : [
		        {
		            type : 'category',
		            data : ['1百','5百','1千','2千','3千','4千','5千']
		        }
		    ],
		    yAxis : [
		        {
		            type : 'value'
		        }
		    ],
		    series : [
		        {
		            name:'收益',
		            type:'bar',
		            data:[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6],
		            markPoint : {
		                data : [
		                    {type : 'max', name: '最大值'},
		                    {type : 'min', name: '最小值'}
		                ]
		            },
		            markLine : {
		                data : [
		                    {type : 'average', name: '平均值'}
		                ]
		            }
		        }
		    ]
		});
		$.ajax({
			url: 'crawler/stockDataYKAnalysis/getBarData.do',
			method: 'post',
			data:{
				arg1:arg1,
				arg2:arg2,
				fCode:fCode,
				fName:fName
			},
			success: function(result) {
				console.info(result);
				bar.setOption({
					series:[{
						data:result.data1
					}
					]
				});
			}
		});
	}
	
	//加载折线图
	function loadline2(arg1,arg2,fCode,fName){
		line2.setOption({
			tooltip : {
		        trigger: 'axis'
		    },
		    legend: {
		        data:['5百股','一千股','二千股','三千股','四千股','五千股']
		    },
		    toolbox: {
		        show : true,
		        feature : {
		            mark : {show: true},
		            dataView : {show: true, readOnly: false},
		            magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
		            restore : {show: true},
		            saveAsImage : {show: true}
		        }
		    },
		    calculable : true,
		    xAxis : [
		        {
		            type : 'category',
		            boundaryGap : false,
		            data : ['周一','周二','周三','周四','周五','周六','周日']
		        }
		    ],
		    yAxis : [
		        {
		            type : 'value'
		        }
		    ],
		    series : [
		        {
		            name:'5百股',
		            type:'line',
		            stack: '总量',
		            itemStyle: {normal: {areaStyle: {type: 'default'}}},
		            data:[120, 132, 101, 134, 90, 230, 210]
		        },
		        {
		            name:'一千股',
		            type:'line',
		            stack: '总量',
		            itemStyle: {normal: {areaStyle: {type: 'default'}}},
		            data:[220, 182, 191, 234, 290, 330, 310]
		        },
		        {
		            name:'二千股',
		            type:'line',
		            stack: '总量',
		            itemStyle: {normal: {areaStyle: {type: 'default'}}},
		            data:[150, 232, 201, 154, 190, 330, 410]
		        },
		        {
		            name:'三千股',
		            type:'line',
		            stack: '总量',
		            itemStyle: {normal: {areaStyle: {type: 'default'}}},
		            data:[320, 332, 301, 334, -390, 330, 320]
		        },
		        {
		            name:'四千股',
		            type:'line',
		            stack: '总量',
		            itemStyle: {normal: {areaStyle: {type: 'default'}}},
		            data:[820, 932, 901, 934, 1290, 1330, -1320]
		        },
		        {
		            name:'五千股',
		            type:'line',
		            stack: '总量',
		            itemStyle: {normal: {areaStyle: {type: 'default'}}},
		            data:[820, 932, 901, 934, 1290, 1330, -1320]
		        }
		        
		    ]
		});
		$.ajax({
			url: 'crawler/stockDataYKAnalysis/getLineData.do',
			method: 'post',
			data:{
				arg1:arg1,
				arg2:arg2,
				fCode:fCode,
				fName:fName
			},
			success: function(result) {
				//console.info(result);
				line2.setOption({
					xAxis:[{
						data:result.dataDate	
					}],
					series:[{
						data:result.data1
					},{
						data:result.data2
					}
					,{
						data:result.data3
					}
					,{
						data:result.data4
					}
					,{
						data:result.data5
					}
					,{
						data:result.data6
					}
					]
				});
			}
		});
	}
	
});


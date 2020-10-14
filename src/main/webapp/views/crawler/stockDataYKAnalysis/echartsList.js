$(function(){
	var line2 = echarts.init(document.getElementById('stockDataYKAnalysis_line_echarts'),'macarons');
	
	var arg1 = 0;
	var arg2 = 0;
	var clickOrgCode = 0;
	var phbType = 0;
	//var arg2= $("input[name='radioOptionsExample1']:checked").val();
	
	loadline2(arg1,arg2,clickOrgCode,phbType);
	
	window.onresize = function() {
		line2.resize();
	};
	
	//加载排行榜
	function loadline2(arg1,arg2,clickOrgCode,phbType){
		line2.setOption({
			tooltip : {
		        trigger: 'axis'
		    },
		    legend: {
		        data:['邮件营销','联盟广告','视频广告','直接访问','搜索引擎']
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
		            name:'邮件营销',
		            type:'line',
		            stack: '总量',
		            itemStyle: {normal: {areaStyle: {type: 'default'}}},
		            data:[120, 132, 101, 134, 90, 230, 210]
		        },
		        {
		            name:'联盟广告',
		            type:'line',
		            stack: '总量',
		            itemStyle: {normal: {areaStyle: {type: 'default'}}},
		            data:[220, 182, 191, 234, 290, 330, 310]
		        },
		        {
		            name:'视频广告',
		            type:'line',
		            stack: '总量',
		            itemStyle: {normal: {areaStyle: {type: 'default'}}},
		            data:[150, 232, 201, 154, 190, 330, 410]
		        },
		        {
		            name:'直接访问',
		            type:'line',
		            stack: '总量',
		            itemStyle: {normal: {areaStyle: {type: 'default'}}},
		            data:[320, 332, 301, 334, -390, 330, 320]
		        },
		        {
		            name:'搜索引擎',
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
				clickOrgCode:clickOrgCode,
				phbType:phbType
			},
			success: function(result) {
				console.info(result);
				line2.setOption({
					xAxis:[{
						data:result.dataDate	
					}],
					series:[{
						data:result.data1
					},{
						data:result.data2
					}]
				});
			}
		});
	}
	
});


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>

	.compositeQuery_InspectQuery_table, td{
		font:100% Arial,Helvetica,sans-serif;
	}
	.compositeQuery_InspectQuery_table{
		width:100%;border-collapse: collapse;margin:1em 0;
	}
	.Label{
		background: none repeat scroll 0 0 #9cc7f3;
		height: 100%;
		font-size: 14px;
		font-weight: bold;
		padding: 3px 0px 3px 5px;
	}
	.blueLabel{
		background: none repeat scroll 0 0 #EEF5FB;
		text-align: right;
		height: 20px;
		width:15%
	}

</style>

<table width="80%" height="100%" cellspacing="0" cellpadding="0" border="1" align="center" class="compositeQuery_InspectQuery_table" >
	<tbody>
    <tr>
		<td colspan="4"><div align="left" class="Label">纳税人税务登记信息采集_基本信息</div></td>
	</tr>
	<tr>
		<td class="blueLabel">纳税人识别号：</td>
		<td><span class="mySpan">${hm["fcode"]}</span></td>
		<td  class="blueLabel">纳税人名称：</td>
		<td><span class="mySpan">${hm['fname']}</span></td>
	</tr>
	<tr>
		<td class="blueLabel">登记注册类型：</td>
		<td><span class="mySpan">${hm["DJZCLXMC"]}</span></td>
		<td class="blueLabel">批准设立机关类型：</td>
		<td><span class="mySpan">${hm["PZSLJGLXMC"]}</span></td>
	</tr>
	<tr>
		<td class="blueLabel">批准设立机关：</td>
		<td><span class="mySpan">${hm["GSXZGLJGMC"]}</span></td>
		<td class="blueLabel">批准设立证明或文件号：</td>
		<td><span class="mySpan">${hm["PZZMHWJH"]}</span></td>
	</tr>
	<tr>
		<td class="blueLabel">组织机构代码：</td>
		<td><span class="mySpan">${hm["ZZJG_DM"]}</span></td>
		<td class="blueLabel">开业（设立）日期：</td>
		<td><span class="mySpan">${hm["KYSLRQ"]}</span></td>
	</tr>
	<tr>
		<td class="blueLabel">生产经营期限起：</td>
		<td><span class="mySpan">${hm["SCJYQXQ"]}</span></td>
		<td class="blueLabel">生产经营期限止：</td>
		<td><span class="mySpan">${hm["SCJYQXZ"]}</span></td>
	</tr>
	<tr>
		<td class="blueLabel">证照名称：</td>
		<td><span class="mySpan">${hm["ZZLXMC"]}</span></td>
		<td class="blueLabel">证照号码：</td>
		<td><span class="mySpan">${hm["ZZHM"]}</span></td>
	</tr>
	<tr>
		<td class="blueLabel">注册地址所在行政区划：</td>
		<td colspan="3"><span class="mySpan">${hm["XZQHMC"]}</span></td>
	</tr>
	<tr>
		<td class="blueLabel">注册地址：</td>
		<td colspan="3"><span class="mySpan">${hm["ZCDZ"]}</span></td>
	</tr>
	<tr>
		<td class="blueLabel">注册地邮编：</td>
		<td><span class="mySpan">${hm["ZCDYZBM"]}</span></td>
		<td class="blueLabel">注册地联系电话：</td>
		<td><span class="mySpan">${hm["ZCDLXDH"]}</span></td>
	</tr>
	<tr>
		<td class="blueLabel">生产经营地址：</td>
		<td colspan="3"><span class="mySpan">${hm["SCJYDZ"]}</span></td>
	</tr>
	<tr>
		<td class="blueLabel">生产经营地邮编：</td>
		<td><span class="mySpan">${hm["SCJYDYZBM"]}</span></td>
		<td class="blueLabel">生产经营地联系电话：</td>
		<td><span class="mySpan">${hm["SCJYDLXDH"]}</span></td>
	</tr>
	<tr>
		<td class="blueLabel">核算方式：</td>
		<td><span class="mySpan">${hm["HSFSMC"]}</span></td>
		<td class="blueLabel">从业人数：</td>
		<td><span class="mySpan">${hm["CYRS"]}</span></td>
	</tr>
	<tr>
		<td class="blueLabel">其中外籍人数：</td>
		<td><span class="mySpan">${hm["WJCYRS"]}</span></td>
		<td class="blueLabel">单位性质：</td>
		<td><span class="mySpan">${hm["ZZJGLXMC"]}</span></td>
	</tr>
	<tr>
		<td class="blueLabel">网站网址：</td>
		<td><span class="mySpan">${hm["WZ"]}</span></td>
		<td class="blueLabel">适用会计制度：</td>
		<td><span class="mySpan">${hm["KJZDZZMC"]}</span></td>
	</tr>
	<tr style="height: 100px">
		<td class="blueLabel">经营范围：</td>
		<td colspan="3"><textarea readonly="readonly" rows="10" cols="100" style="height:100%;width:100%">${hm["JYFW"]}</textarea></td>
	</tr>
	<tr>
		<td class="blueLabel">国标行业：</td>
		<td><span class="mySpan">${hm["TRADENAME"]}</span></td>
	</tr>
	
	<tr>
		<td colspan="4"><div align="left" class="Label">统计分析</div></td>
	</tr>
	<tr>
		<td class="blueLabel">总交易日数量：</td>
		<td><span class="mySpan">${hm["jyrCount"]}</span></td>
		<td class="blueLabel">日期区间：</td>
		<td><span class="mySpan">${hm["dateQj"]}</span></td>
	</tr>
	<tr>
		<td class="blueLabel">今开(>)昨收(正收益)：</td>
		<td><span class="mySpan">${hm["zsyCount"]}</span></td>
		<td class="blueLabel">收益率：</td>
		<td><span class="mySpan">${hm["zsyScale"]}</span></td>
	</tr>
	<tr>
		<td class="blueLabel">今开(<)昨收(负收益)：</td>
		<td><span class="mySpan">${hm["fsyCount"]}</span></td>
		<td class="blueLabel">亏损率：</td>
		<td><span class="mySpan">${hm["fsyScale"]}</span></td>
	</tr>
	<tr>
		<td class="blueLabel">今开(=)昨收(无收益)：</td>
		<td><span class="mySpan">${hm["wsyCount"]}</span></td>
		<td class="blueLabel">比例：</td>
		<td><span class="mySpan">${hm["wsyScale"]}</span></td>
	</tr>
	<tr>
		<td colspan="4"><div align="left" class="Label">收盘分析</div></td>
	</tr>
	<tr>
		<td class="blueLabel">总交易日数量：</td>
		<td><span class="mySpan">${hm["jyrCount"]}</span></td>
		<td class="blueLabel">日期区间：</td>
		<td><span class="mySpan">${hm["dateQj"]}</span></td>
	</tr>
	<tr>
		<td class="blueLabel">今收盘>今最低：</td>
		<td><span class="mySpan">${hm["spjDyZdjCount"]}</span></td>
		<td class="blueLabel">占比：</td>
		<td><span class="mySpan">${hm["spjDyZdjScale"]}</span></td>
	</tr>
	<tr>
		<td class="blueLabel">今收盘=今最低：</td>
		<td><span class="mySpan">${hm["spjDdyZdjCount"]}</span></td>
		<td class="blueLabel">占比：</td>
		<td><span class="mySpan">${hm["spjDdyZdjScale"]}</span></td>
	</tr>
	<tr>
		<td colspan="4"><div align="left" class="Label">今最高-今开盘在(<span>${hm["dateQj"]}</span>)区间最佳时机分析</div></td>
	</tr>
	<tr>
		<td class="blueLabel">(0.00<=(今高-今开))：</td>
		<td><span class="mySpan">${hm["zgj_Kpj_0_00Count"]}</span></td>
		<td class="blueLabel">占比：</td>
		<td><span class="mySpan">${hm["zgj_Kpj_0_00CountScale"]}</span></td>
	</tr>
	<tr>
		<td class="blueLabel">(0.05<=(今高-今开))：</td>
		<td><span class="mySpan">${hm["zgj_Kpj_0_05Count"]}</span></td>
		<td class="blueLabel">占比：</td>
		<td><span class="mySpan">${hm["zgj_Kpj_0_05CountScale"]}</span></td>
	</tr>
	<tr>
		<td class="blueLabel">(0.10<=(今高-今开))：</td>
		<td><span class="mySpan">${hm["zgj_Kpj_0_10Count"]}</span></td>
		<td class="blueLabel">占比：</td>
		<td><span class="mySpan">${hm["zgj_Kpj_0_10CountScale"]}</span></td>
	</tr>
	<tr>
		<td class="blueLabel">(0.15<=(今高-今开))：</td>
		<td><span class="mySpan">${hm["zgj_Kpj_0_15Count"]}</span></td>
		<td class="blueLabel">占比：</td>
		<td><span class="mySpan">${hm["zgj_Kpj_0_15CountScale"]}</span></td>
	</tr>
	<tr>
		<td class="blueLabel">(0.20<=(今高-今开))：</td>
		<td><span class="mySpan">${hm["zgj_Kpj_0_20Count"]}</span></td>
		<td class="blueLabel">占比：</td>
		<td><span class="mySpan">${hm["zgj_Kpj_0_20CountScale"]}</span></td>
	</tr>
	<tr>
		<td class="blueLabel">(0.25<=(今高-今开))：</td>
		<td><span class="mySpan">${hm["zgj_Kpj_0_25Count"]}</span></td>
		<td class="blueLabel">占比：</td>
		<td><span class="mySpan">${hm["zgj_Kpj_0_25CountScale"]}</span></td>
	</tr>
	<tr>
		<td class="blueLabel">(0.30<=(今高-今开))：</td>
		<td><span class="mySpan">${hm["zgj_Kpj_0_30Count"]}</span></td>
		<td class="blueLabel">占比：</td>
		<td><span class="mySpan">${hm["zgj_Kpj_0_30CountScale"]}</span></td>
	</tr>
	<tr>
		<td class="blueLabel">(0.35<=(今高-今开))：</td>
		<td><span class="mySpan">${hm["zgj_Kpj_0_35Count"]}</span></td>
		<td class="blueLabel">占比：</td>
		<td><span class="mySpan">${hm["zgj_Kpj_0_35CountScale"]}</span></td>
	</tr>
	<tr>
		<td class="blueLabel">(0.40<=(今高-今开))：</td>
		<td><span class="mySpan">${hm["zgj_Kpj_0_40Count"]}</span></td>
		<td class="blueLabel">占比：</td>
		<td><span class="mySpan">${hm["zgj_Kpj_0_40CountScale"]}</span></td>
	</tr>
	<tr>
		<td class="blueLabel">(0.45<=(今高-今开))：</td>
		<td><span class="mySpan">${hm["zgj_Kpj_0_45Count"]}</span></td>
		<td class="blueLabel">占比：</td>
		<td><span class="mySpan">${hm["zgj_Kpj_0_45CountScale"]}</span></td>
	</tr>
	<tr>
		<td class="blueLabel">(0.50<=(今高-今开))：</td>
		<td><span class="mySpan">${hm["zgj_Kpj_0_50Count"]}</span></td>
		<td class="blueLabel">占比：</td>
		<td><span class="mySpan">${hm["zgj_Kpj_0_50CountScale"]}</span></td>
	</tr>
	<tr>
		<td colspan="4"><div align="left" class="Label">今开盘-今最低在(<span>${hm["dateQj"]}</span>)区间最佳时机分析</div></td>
	</tr>
	<tr>
		<td class="blueLabel">(0.00=(今开-今低))：</td>
		<td><span class="mySpan">${hm["kpj_Zdj_0_00Count"]}</span></td>
		<td class="blueLabel">占比率：</td>
		<td><span class="mySpan">${hm["kpj_Zdj_0_00Scale"]}</span></td>
	</tr>
	<tr>
		<td class="blueLabel">(0.05<=(今开-今低))：</td>
		<td><span class="mySpan">${hm["kpj_Zdj_0_05Count"]}</span></td>
		<td class="blueLabel">占比率：</td>
		<td><span class="mySpan">${hm["kpj_Zdj_0_05Scale"]}</span></td>
	</tr>
	<tr>
		<td class="blueLabel">(0.10<=(今开-今低))：</td>
		<td><span class="mySpan">${hm["kpj_Zdj_0_10Count"]}</span></td>
		<td class="blueLabel">占比率：</td>
		<td><span class="mySpan">${hm["kpj_Zdj_0_10Scale"]}</span></td>
	</tr>
	<tr>
		<td class="blueLabel">(0.15<=(今开-今低))：</td>
		<td><span class="mySpan">${hm["kpj_Zdj_0_15Count"]}</span></td>
		<td class="blueLabel">占比率：</td>
		<td><span class="mySpan">${hm["kpj_Zdj_0_15Scale"]}</span></td>
	</tr>
	<tr>
		<td class="blueLabel">(0.20<=(今开-今低))：</td>
		<td><span class="mySpan">${hm["kpj_Zdj_0_20Count"]}</span></td>
		<td class="blueLabel">占比率：</td>
		<td><span class="mySpan">${hm["kpj_Zdj_0_20Scale"]}</span></td>
	</tr>
	<tr>
		<td class="blueLabel">(0.25<=(今开-今低))：</td>
		<td><span class="mySpan">${hm["kpj_Zdj_0_25Count"]}</span></td>
		<td class="blueLabel">占比率：</td>
		<td><span class="mySpan">${hm["kpj_Zdj_0_25Scale"]}</span></td>
	</tr>
	<tr>
		<td class="blueLabel">(0.30<=(今开-今低))：</td>
		<td><span class="mySpan">${hm["kpj_Zdj_0_30Count"]}</span></td>
		<td class="blueLabel">占比率：</td>
		<td><span class="mySpan">${hm["kpj_Zdj_0_30Scale"]}</span></td>
	</tr>
	<tr>
		<td class="blueLabel">(0.35<=(今开-今低))：</td>
		<td><span class="mySpan">${hm["kpj_Zdj_0_35Count"]}</span></td>
		<td class="blueLabel">占比率：</td>
		<td><span class="mySpan">${hm["kpj_Zdj_0_35Scale"]}</span></td>
	</tr>
	<tr>
		<td class="blueLabel">(0.40<=(今开-今低))：</td>
		<td><span class="mySpan">${hm["kpj_Zdj_0_40Count"]}</span></td>
		<td class="blueLabel">占比率：</td>
		<td><span class="mySpan">${hm["kpj_Zdj_0_40Scale"]}</span></td>
	</tr>
	<tr>
		<td class="blueLabel">(0.45<=(今开-今低))：</td>
		<td><span class="mySpan">${hm["kpj_Zdj_0_45Count"]}</span></td>
		<td class="blueLabel">占比率：</td>
		<td><span class="mySpan">${hm["kpj_Zdj_0_45Scale"]}</span></td>
	</tr>
	<tr>
		<td class="blueLabel">(0.50<=(今开-今低))：</td>
		<td><span class="mySpan">${hm["kpj_Zdj_0_50Count"]}</span></td>
		<td class="blueLabel">占比率：</td>
		<td><span class="mySpan">${hm["kpj_Zdj_0_50Scale"]}</span></td>
	</tr>
	
	<tr>
		<td colspan="4"><div align="left" class="Label">决定书信息</div></td>
	</tr>
	<tr>
		<td class="blueLabel">检查日期起：</td>
		<td><span class="mySpan">${hm["CLJCRQQ"]}</span></td>
		<td class="blueLabel">检查日期止：</td>
		<td><span class="mySpan">${hm["CLJCRQZ"]}</span></td>
	</tr>
	<tr>
		<td class="blueLabel">检查所属期间起：</td>
		<td><span class="mySpan">${hm["CLJCSSQJQ"]}</span></td>
		<td class="blueLabel">检查所属期间止：</td>
		<td><span class="mySpan">${hm["CLJCSSQJZ"]}</span></td>
	</tr>
	<tr style="height: 150px">
		<td class="blueLabel">检查范围和内容：</td>
		<td colspan="3" ><textarea readonly="readonly" style="background: #FFFADB;height:100%;width:100%" rows="12" cols="100">${hm["CLJCFWHNR"]}</textarea></td>
	</tr>
	<tr style="height: 150px">
		<td class="blueLabel">检查范围和内容：</td>
		<td colspan="3" ><textarea readonly="readonly" style="height:100%;width:100%" rows="12" cols="100">${hm["CLJCFWHNR"]}</textarea></td>
	</tr>
	</tbody>
</table>


<%-- <script src="<s:url value="/views/compositeQuery/InspectQuery/detail.js" />" type="text/javascript"></script> --%>



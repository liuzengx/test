package com.ts.module.utils;

import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;
import sun.misc.BASE64Encoder;

public class ModUtil {
	/**
	 * Date转字符串(yyyy-MM-dd HH:mm:ss)
	 * 
	 * @param date
	 *            日期
	 * @return dateStr 字符串类型的日期
	 **/
	public static String dateToString(Date date) {
		String dateStr = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (date != null) {
			dateStr = formatter.format(date);
		}
		//System.out.println("字符Date:" + dateStr);

		return dateStr;
	}

	/**
	 * 字符串转Date(yyyy-MM-dd HH:mm:ss)
	 * 
	 * @param dateStr
	 *            日期
	 * @return date Date类型的日期
	 **/
	public static Date strToDate(String dateStr) {
		Date date = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date = format.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//System.out.println("类型Date:" + date);

		return date;
	}
	/**
	 * 计算时间差
	 * 
	 * @param startTime 起始字符串日期
	 * @param lastTime 结束字符串日期
	 * @return String 时间差
	 **/
	public static String betweenTime(String startTime,String lastTime) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date start = null;
		Date last = null;
		String reTime=null;
		try {
			start = format.parse(startTime);
			last = format.parse(lastTime);
			long between = last.getTime() - start.getTime();
			long day = between / (24 * 60 * 60 * 1000);
			long hour = (between / (60 * 60 * 1000) - day * 24);
			long min = ((between / (60 * 1000)) - day * 24 * 60 - hour * 60);
			long s = (between / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
			//System.out.println(day + "天" + hour + "小时" + min + "分" + s + "秒");
			if(day >0){
				reTime=(day + "天" + hour + "小时" + min + "分" + s + "秒");
			}else if(hour >0){
				reTime=(hour + "小时" + min + "分" + s + "秒");
			}else{
				reTime=(min + "分" + s + "秒");
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return reTime;
	}

	/**
	 * 字符串转Map
	 * 
	 * @param mapStr
	 *            字符串
	 * @return Map<String,Object> map数据
	 **/
	public static HashMap<String, Object> strToMap(String mapStr) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (mapStr.indexOf("{") > -1 && mapStr.indexOf("{") != 0) {
			mapStr = mapStr.substring(mapStr.indexOf("{"), mapStr.length());
		}
		if (mapStr.startsWith("{")) {
			mapStr = mapStr.substring(1, mapStr.length());
		}
		if (mapStr.endsWith("}")) {
			mapStr = mapStr.substring(0, mapStr.length() - 1);
		}
		String[] out = mapStr.split(",");
		for (String anOut : out) {
			String[] inn = anOut.split("=");
			map.put(inn[0].trim(), inn[1]);
		}
		 //System.out.println(map);
		return map;

	}

	/**
	 * 字符串去除前后单双引号
	 * 
	 * @param str 字符串
	 * @return String 字符串数据
	 **/
	public static String stringReplace(String str) {
		String strFat = str;
		if ((str.startsWith("'") || str.startsWith("\"")) && (str.endsWith("'") || str.endsWith("\""))) {
			strFat = str.replace("\'", "").replace("\"", "");
		}
		return strFat;
	}

	/**
	 * 格式化 ip
	 * @param str 字符串
	 * @return String 字符串数据
	 **/
	public static String ipFormat(String ip) {
		String hostIp = ip;
		if (("0:0:0:0:0:0:0:1").equals(ip)) {
			hostIp = "127.0.0.1";
		}
		return hostIp;
	}
	/**
	 * Md5加密
	 * @param str 字符串
	 * @return String Md5值
	 **/
	public static String Md5(String str) {
		try {
			MessageDigest md5=MessageDigest.getInstance("MD5");
			BASE64Encoder base64en=new BASE64Encoder();
			//加密后的字符串
			return base64en.encode(md5.digest(str.getBytes("UTF-8")));
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("MD5加密异常"+e.getMessage());
			return "";
		}
	}
	/**
	 * json字符串转为json
	 * @param str 字符串
	 * @return json格式数据
	 **/
	public static JSONObject strToJson(String str) {
		JSONObject json= new JSONObject();
		try {
			json = JSONObject.fromString(str);
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("json转换异常"+e.getMessage());
		}
		return json;
	}
	/**
     * 将json对象转换成Map
     *
     * @param jsonObject json对象
     * @return Map对象
     */
    @SuppressWarnings("unchecked")
    public static HashMap<String, Object> JsontoMap(JSONObject jsonObject) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        Iterator<String> iterator = jsonObject.keys();
        String key = null;
        Object value = null;
        while (iterator.hasNext()) {
            key = iterator.next();
            value = jsonObject.get(key);
            result.put(key,value);
        }
        return result;
    }
	

	public static void main(String[] args) {
		//Date date = new Date();
		//String str = "2019-01-05 17:40:03";
		// System.out.println("原始Date:" + date);
		// dateToString(date);
		// strToDate(str);
		//String mapStr = "UserPojo{id=1, account='123', password='123'}";
		 //Map strToMap = strToMap(mapStr);
		// System.out.println(strToMap.get("id"));
		//String s = "95.12.78.151";
		//System.out.println(ipFormat(s));
		 
		 /*List<HashMap<String, Object>> aMap= new ArrayList<HashMap<String,Object>>();
		 HashMap<String, Object> s = new HashMap<String, Object>();//定义一个HashMap<String, Object>用来向集合总添加列属性
		    s.put("user", "user");
		    s.put("id", "1");
		HashMap<String, Object> s1 = new HashMap<String, Object>();//定义一个HashMap<String, Object>用来向集合总添加列属性
	    s1.put("user", "user123");
		    aMap.add(s); 
		    aMap.add(s1);
		 System.out.println("aMap:"+aMap);*/
		
		//System.out.println(Md5("dsf"));
		
		String str = "2019-01-16 20:53:07";
		
		System.out.println();
		
		
	}

}

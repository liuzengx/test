package com.ts.module.utils;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;

/**
 * db 工具类
 * 
 * createdate: 2020/08/29
 * 
 * @version 1
 * @author y
 */
public class DbUtils {
	
	//TODO 
	
	private static final Logger log = Logger.getLogger(DbUtils.class);

	/**
	 * 根据页码生成sql分页语句的最小值
	 */
	public static int generatePaginationFirstResult(int page, int rows) {
		if (page < 1) {
			page = 1;
		}
		page = page - 1;
		int firstResult = page * rows;
		//rownum 是从1开始的
		//firstResult += 1;
		return firstResult;
	}
	
	/**
	 * 根据页码生成sql分页语句的最大值
	 */
	public static int generatePaginationMaxResult(int page, int rows) {
		if (page < 1) {
			page = 1;
		}
		page = page - 1;
		int firstResult = page * rows;
		//rownum 是从1开始的
		//firstResult += 1;
		int maxResult = firstResult + rows;
		return maxResult;
	}
	
}

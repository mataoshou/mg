package com.mg.node.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/* 通用工具类
 * 
 */
public class DBSql
{
	public static SimpleDateFormat sdf_dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static SimpleDateFormat sdf_d = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat sdf_t = new SimpleDateFormat("HH:mm:ss");
	
	public static Date now()
	{
		return new Date();
	}
	
	// 名字加反引号
	public static String name(String str)
	{
		if(str.indexOf('.')>=0) return str; // "db.table.column"
		if(str.indexOf('`')>=0) return str;
		return "`" + str + "`";		
	}
	
	// 值加单引号
	public static String value(String str)
	{
		if(str.startsWith("\'")) return str;
		return "'" + str + "'";
	}
	
	public static String date(Date d)
	{
		return sdf_d.format(d);
	}
	
	public static String datetime(Date d)
	{
		return sdf_dt.format(d);
	}
	
	// 转义 替换 \ 和 '
	public static String escape(String sql)
	{
		StringBuffer sb = new StringBuffer(sql.length() * 2);
		for(int i=0; i<sql.length(); i++)
		{
			char ch = sql.charAt(i);
			if(ch=='\'' || ch == '\\')
			{
				sb.append('\\')	;		
			}

			sb.append(ch);			
		}
		return sb.toString();
	}
	
	public static void main(String[] args) throws Exception
	{
		String sql = "邵\\发\'不错";
		sql = DBSql.escape(sql);
		
		System.out.println("exit");
	}
}

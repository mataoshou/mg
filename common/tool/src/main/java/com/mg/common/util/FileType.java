package com.mg.common.util;

import java.util.ArrayList;
import java.util.List;

public class FileType
{

	static List<FileItem> m_list = new ArrayList<>();

	static {
		m_list.add(new FileItem("JPG","JPG","image/jpeg"));
		m_list.add(new FileItem("PNG","PNG","image/png"));
		m_list.add(new FileItem("GIF","GIF","image/gif"));
		m_list.add(new FileItem("JS","JS","application/x-javascript"));
		m_list.add(new FileItem("CSS","CSS","text/css"));
		m_list.add(new FileItem("HTML","HTML","text/html"));

	}
	public static String JPG = "JPG";
	public static String PNG = "PNG";
	public static String GIF = "GIF";
	public static String WEBP = "WEBP";

	public static String VIDEO = "VIDEO";


	public static String JS ="JS";
	public static String CSS ="CSS";
	public static String HTML ="HTML";


	//根据文件类型获取后缀
	public static String getSuffix(String type)
	{
		for(FileItem item : m_list)
		{
			if (item.fileType.equals(type.toUpperCase())) {
				return item.fileSuffix.toLowerCase();
			}
		}
		return "";
	}
	//根据后缀获取文件类型
	public static String getType(String suffix)
	{
		for(FileItem item : m_list)
		{
			if (item.fileSuffix.equals(suffix.toUpperCase())) {
				return item.fileSuffix.toUpperCase();
			}
		}
		return "";
	}


	public static String getContentByType(String type)
	{

		for(FileItem item : m_list)
		{
			if (item.fileType.equals(type.toUpperCase())) {
				return item.contentType;
			}
		}
		return "";
	}


	public static String getContentBySuffix(String suffix)
	{

		for(FileItem item : m_list)
		{
			if (item.fileSuffix.equals(suffix.toUpperCase())) {
				return item.contentType;
			}
		}
		return "";
	}


	static class FileItem
	{

		public FileItem(String ftype,String fsuffix,String fcontentType)
		{
			this.fileType = ftype;

			this.fileSuffix = fsuffix;

			this.contentType = fcontentType;
		}

		String fileType;

		String fileSuffix;

		String contentType ;

	}


}

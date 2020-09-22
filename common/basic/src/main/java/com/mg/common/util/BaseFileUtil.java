package com.mg.common.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.File;
import java.io.IOException;

@Slf4j
public class BaseFileUtil
{

	/**
	 *初始化文件路径，并删除已存在文件 
	 */
	public static void initFile(File f)
	{
		f.deleteOnExit();
		f.getParentFile().mkdirs();
	}

	/**
	 * 根据多段路径，获取文
	 */
	public static File getFile(String... paths)
	{
		if (paths == null)
			return null;
		if (paths.length <= 0)
			return null;

		File f = new File(paths[0]);
		for (int i = 1; i < paths.length; i++)
		{
			f = new File(f, paths[i]);
		}
		log.debug("构建文件:" + f.getPath());
		return f;
	}
	
	/**
	 * 根据多段路径，获取文件完整路�?
	 */
	public static String getFilePath(String... paths)
	{
		if (paths == null)
			return null;
		if (paths.length <= 0)
			return null;
		return getFile(paths).getPath();
	}

	/**
	 * 获取文件名称
	 */
	public static String getFileName(String path)
	{
		if (path == null)
			return null;
		if (path.length() <= 0)
			return null;
		File f = new File(path);
		return f.getName();
	}

//	public static String getFileNameNoSuffix(String fn)
//	{
//
//		String name =  fn.substring(0,fn.lastIndexOf(".") );
//
//		return name;
//	}

	public static String getFileNameNoSuffix(String path)
	{
		File f = new File(path);
		String name = f.getName();
		name =  name.substring(0,name.lastIndexOf(".") );

		return name;
	}

	/**
	 * 获取文件后缀
	 */
	public static String getSuffix(String path, String def)
	{
		String fileName = new File(path).getName();
		String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
		log.debug("文件后缀:" + suffix);
		if (suffix.length() <= 0)
		{
			return def;
		}

		return suffix;
	}

	// 获取文件后缀
	public static String getSuffix(File f)
	{
		return getSuffix(f.getPath());
	}

	// 获取文件后缀
	public static String getSuffix(String path)
	{
		String suffix = path.substring(path.lastIndexOf(".") + 1);
		return suffix;
	}

	// 将文件移动到指定位置
	public static void move(File src, File dst) throws IOException
	{
		if (src.exists())
		{
			dst.getParentFile().mkdirs();
			FileUtils.moveFile(src, dst);
			log.debug("文件:" + src.getPath() + "移动到:" + dst.getPath());
			return;
		}
		log.debug(src.getPath() + "文件不存!!");
	}

	// 文件格式转换
	public static void copy(File src, String codeType1, File dst,
			String codeType2) throws IOException
	{
		FileUtils.writeLines(dst, codeType2,
				FileUtils.readLines(src, codeType1));
	}
	/**
	 *删除文件、文件夹及下属子文件或文件夹
	 *@param file 删除的文件的路径
	 */
	public static boolean delete(File file){
		if(!file.exists()){//验证路径是否存在
			log.info(file.getPath()+"   路径不存在！");
			return false;
		}
		if(!file.isDirectory()){//验证是否是文件夹
			file.delete();//文件直接删除
			log.info("删除文件" +file.getPath());
			return true;
		}
		//遍历文件夹下的文件或文件夹，进行删除
		File[] files=file.listFiles();
		for(File f:files){
			delete(f);//递归删除
		}
		file.delete();//删除文件�?
		log.info("删除文件:" +file.getPath());
		return true;
		
	}
	//根据url  获取文件类型
	public static String getFileType(String url) throws Exception
	{

		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		CloseableHttpResponse response = httpclient.execute(httpget);
		String type="";
		try
		{
			StatusLine statusLine = response.getStatusLine();
			int status = statusLine.getStatusCode();
			if (status != 200)
			{
				throw new Exception("HTTP GET出错:" + status + ","
						+ statusLine.getReasonPhrase());
			}
			try
			{
				String contentType = response.getFirstHeader("Content-Type")
						.getValue();
				if ("image/jpeg".equals(contentType))
					type = FileType.JPG;
				else if ("image/png".equals(contentType))
					type = FileType.PNG;
				else if ("image/gif".equals(contentType))
					type = FileType.GIF;
				else if ("image/webp".equals(contentType))
					type = FileType.WEBP;
			} catch (Exception e)
			{
				log.debug("无法获取Content-Type ");
			}
		} finally
		{
			try
			{
				response.close();
			} catch (Exception e)
			{
			}
		}
		return type;
	}
	
	public static void main(String[] args)
	{
		String path = "http://mmbiz.qpic.cn/mmbiz_png/96whG4FDb7icyobtfaGw8AOATUiaFoHJYhtThLtibrCdLYJiczibl1pobqibWSOXobaMgw9yiaylkR5EVfAYibWPx1l6zw/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1";
		try
		{
			System.out.println(getFileType(path));
		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}
}

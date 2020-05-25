package build.tool;

import org.apache.commons.io.FileUtils;


import java.io.File;
import java.io.IOException;

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
	 * 根据多段路径，获取文件
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
		System.out.println("构建文件:" + f.getPath());
		return f;
	}
	
	/**
	 * 根据多段路径，获取文件完整路径
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

	/**
	 * 获取文件后缀
	 */
	public static String getSuffix(String path, String def)
	{
		String fileName = new File(path).getName();
		String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
		System.out.println("文件后缀:" + suffix);
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
			System.out.println("文件从:" + src.getPath() + "移动到:" + dst.getPath());
			return;
		}
		System.out.println(src.getPath() + "文件不存在");
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
			System.out.println(file.getPath()+"   路径不存在！");
			return false;
		}
		if(!file.isDirectory()){//验证是否是文件夹
			file.delete();//文件直接删除
			System.out.println("删除文件" +file.getPath());
			return true;
		}
		//遍历文件夹下的文件或文件夹，进行删除
		File[] files=file.listFiles();
		for(File f:files){
			delete(f);//递归删除
		}
		file.delete();//删除文件夹
		System.out.println("删除文件夹" +file.getPath());
		return true;
		
	}
}

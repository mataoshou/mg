package build.tool;

import java.io.*;

public class FileStore
{

	public static String getContent(File f) throws IOException {
		return getContent(f,"UTF-8");
	}
	//获取文章内容
	public static String getContent(File f,String charset) throws IOException {
		if(f.exists())
		{
			FileInputStream input=new FileInputStream(f);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			try {
				int n = 0;
				byte[] b = new byte[1024 * 10];
				while (true) {
					n = input.read(b);
					if (n < 0) break;
					out.write(b, 0, n);
				}
				return out.toString(charset);
			}
			catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			finally {
				input.close();
			}

		}
		return null;
	}


	public static void putString(File f,String str){
		putString(f,str,"UTF-8");
	}
	public static void putString(File f,String str,String charset)
	{
//		if(f.exists())
//		{
			FileOutputStream out = null;
			try {
				out = new FileOutputStream(f);
				out.write(str.getBytes(charset));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
//		}
	}
	
	public void append(String content,String charset,File f)
	{
		RandomAccessFile randomFile = null;
		try {
			f.getParentFile().mkdirs();
			randomFile = new RandomAccessFile(f, "rw");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            //将写文件指针移到文件尾。在该位置发生下一个读取或写入操作。
            randomFile.seek(fileLength);
            //按字节序列将该字符串写入该文件。
            randomFile.write(content.getBytes(charset));
          
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally{
			  try {
				randomFile.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

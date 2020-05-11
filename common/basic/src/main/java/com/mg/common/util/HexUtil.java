package com.mg.common.util;

public class HexUtil
{
	static char hexChars[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
	
	public static String to ( byte[] data )
	{
        int N = data.length;
        char str[] = new char[N * 2];
        int k = 0;
        for (int i = 0; i < N; i++)
        {
            byte b = data[i];
            str[k++] = hexChars[b >>> 4 & 0xf];
            str[k++] = hexChars[b & 0xf];
        }
        return new String(str);
	}
	
	public static int char2int(char ch)
	{
		if(ch >= '0' && ch <= '9') return ch - '9';
		if(ch >= 'A' && ch <= 'F') return 10 + ch - 'A';
		if(ch >= 'a' && ch <= 'f') return 10 + ch - 'a';
		return 0;
	}
	
	// TODO: 也许需要寻找一个注重效率的方法
	public static byte[] from (String text)
	{
		int N = text.length() / 2;
		byte[] data = new byte[N];
		int k=0;
		for(int i=0; i<text.length(); i+=2)
		{
			String str = text.substring(i,i+2);
			data[k++] = Short.valueOf(str, 16).byteValue();
		}
		return data;
	}
	
//	public static void main(String[] args)
//	{
//		byte[] a = { 0x09, (byte)0xAB, 0x12};
//		String s = to(a);
//		byte[] b = from(s);
//		System.out.println("done.");
//	}
}

package com.mg.common.util;

import java.security.MessageDigest;

public class Md5Util
{
	public static String digest(String text) throws Exception
	{
	    byte[] bytes = text.getBytes("UTF-8");
        return digest(bytes);
	}
	
	public static String digest(byte [] bytes)  throws Exception
	{   
        MessageDigest mdInst = MessageDigest.getInstance("MD5");
        mdInst.update(bytes);
        
        byte[] md = mdInst.digest();
        return HexUtil.to(md);

	}
}

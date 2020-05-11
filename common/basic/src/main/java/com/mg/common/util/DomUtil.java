package com.mg.common.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DomUtil
{
	// 读取xml文件
	public  Document getDocument(File f) throws IOException,
			DocumentException
	{
		SAXReader reader = new SAXReader();
		// 不进行dtd校验
		reader.setEntityResolver(new EntityResolver()
		{
			@Override
			public InputSource resolveEntity(String publicId, String systemId)
					throws SAXException, IOException
			{
				return new InputSource(new ByteArrayInputStream(
						"<?xml version='1.0' encoding='UTF-8'?>".getBytes()));
			}
		});
		/* 此reader需传入一个InputStream */
		Document xmldoc = reader.read(f);
		return xmldoc;
	}

	// 写入xml文件
	public  void writeDocument(Document xmldoc, File f)
	{
		try
		{
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setNewlines(true); // 设置是否换行
			/** 将document中的内容写入文件中 */
			XMLWriter writer = new XMLWriter(new FileOutputStream(f), format);
			writer.write(xmldoc);
			writer.close();
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public  String child(Element ele, String name, String defValue)
	{
		try
		{
			String value = ele.element(name).getTextTrim();
			return value;
		} catch (Exception ex)
		{
			return defValue;
		}
	}
}

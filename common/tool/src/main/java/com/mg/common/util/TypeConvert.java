package com.mg.common.util;

import java.util.*;

/**
 * 数据类型的转换
 */
public class TypeConvert
{
	// 数组转换为List
	public List toList(Object[] os)
	{
		List result = new ArrayList();
		Collections.addAll(result, os);
		return result;
	}
	//list转数组
	public Object[] toArray(List list)
	{
		Object[] array = new Object[list.size()];
		for (int i = 0; i < list.size(); i++) 
		{
			array[i] = list.get(i);
		}
		return array;
	}

	// map的key转换为List
	public List keytoList(Map map)
	{
		Iterator it = map.keySet().iterator();
		List result = new ArrayList();
		while (it.hasNext())
		{
			result.add(it.next());
		}
		return result;
	}

	// map的value转换为List
	public List valuetoList(Map map)
	{
		Iterator it = map.values().iterator();
		List result = new ArrayList();
		while (it.hasNext())
		{
			result.add(it.next());
		}
		return result;
	}

}

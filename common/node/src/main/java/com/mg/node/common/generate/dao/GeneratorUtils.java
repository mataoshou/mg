package com.mg.node.common.generate.dao;

public class GeneratorUtils {

    public static String getTableName(String pojoName)
    {
        String tableName = pojoName.toLowerCase();

        char[] temp = new char[tableName.length()*2];

        int count =0;
        for(int i=0;i<tableName.length();i++)
        {
            if(pojoName.charAt(i)!=tableName.charAt(i)&&i!=0)
            {
                temp[count] ='_';
                count++;
            }

            temp[count] = tableName.charAt(i);
            count++;
        }

        return new String(temp).trim();
    }



}

package com.mg.node.common.config;

import com.mg.node.common.util.DaoUtils;
import org.dozer.DozerBeanMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfiguration {

    @Bean
    @ConditionalOnMissingBean(DaoUtils.class)
    public DaoUtils daoUtilsBean() {

        DaoUtils utils = new DaoUtils() {
            @Override
            public String getTableName(Class pojo) {
                return getTableName(pojo.getSimpleName());
            }
            @Override
            public String getTableName(String pojoName) {
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
        };
        return utils;
    }

}

package com.mg.node.mapper;

import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Component
public class GeneralMapper {

    @Resource
    private Mapper mapper;

    /**
     * List  实体类 转换器
     *
     * @param source 原数据
     * @param clz    转换类型
     * @param <T>
     * @param <S>
     * @return
     */
    public <T, S> List<T> convert(List<S> source, Class<T> clz) {
        if (source == null) return null;
        List<T> map = new ArrayList<>();
        for (S s : source) {
            map.add(mapper.map(s, clz));
        }
        return map;
    }

    /**
     * Set 实体类 深度转换器
     *
     * @param source 原数据
     * @param clz    目标对象
     * @param <T>
     * @param <S>
     * @return
     */
    public <T, S> Set<T> convert(Set<S> source, Class<T> clz) {
        if (source == null) return null;
        Set<T> set = new TreeSet<>();
        for (S s : source) {
            set.add(mapper.map(s, clz));
        }
        return set;
    }

    /**
     * 实体类 深度转换器
     *
     * @param source
     * @param clz
     * @param <T>
     * @param <S>
     * @return
     */
    public <S,T> T convert(S source, Class<T> clz) {
        if (source == null) return null;
        return mapper.map(source, clz);
    }

    public void convertor(Object source, Object object) {
        mapper.map(source, object);
    }

    public <T> void copyConvertor(T source, Object object) {
        mapper.map(source, object);
    }
}

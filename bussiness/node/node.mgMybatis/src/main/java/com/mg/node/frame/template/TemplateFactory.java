package com.mg.node.frame.template;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TemplateFactory {


    Map<String,List<String>> m_map = new HashMap<>();

    List<String> methods = new ArrayList<>();


    static TemplateFactory factory;

    public static TemplateFactory single()
    {
        if(factory==null) {
            factory = new TemplateFactory();
        }
        return factory;
    }

    public void addTemplate()
    {

    }

}

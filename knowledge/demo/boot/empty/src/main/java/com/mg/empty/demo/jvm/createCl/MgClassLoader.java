package com.mg.empty.demo.jvm.createCl;

import java.net.URL;
import java.net.URLClassLoader;

public class MgClassLoader extends URLClassLoader {


    public MgClassLoader(URL[] urls) {
        super(urls);
    }
}

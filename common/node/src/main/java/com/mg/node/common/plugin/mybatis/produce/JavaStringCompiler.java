package com.mg.node.common.plugin.mybatis.produce;

import com.mg.node.common.plugin.mybatis.imp.IGeneralMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.system.ApplicationHome;

import javax.tools.*;
import java.io.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.Charset;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

@Slf4j
public class JavaStringCompiler {
    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
    StandardJavaFileManager stdManager;

    public JavaStringCompiler() {
        this.stdManager = this.compiler.getStandardFileManager((DiagnosticListener)null, (Locale)null, (Charset)null);
    }

    public Map<String, byte[]> compile(String fileName, String source,String relyOn) throws IOException {
        MemoryJavaFileManager manager = new MemoryJavaFileManager(this.stdManager);
        Throwable var4 = null;
        Map var8;
        try {
            JavaFileObject javaFileObject = manager.makeStringSource(fileName, source);
            JavaCompiler.CompilationTask task;
            if(relyOn==null||relyOn.length()==0)
            {
                log.debug("调试环境不引入依赖！！");
                task = this.compiler.getTask((Writer)null, manager, (DiagnosticListener)null, null,
                        null, Arrays.asList(javaFileObject));

            }
            else{
                log.debug("引入依赖：{}",relyOn);
                Iterable options = Arrays.asList("-classpath", relyOn);
                task = this.compiler.getTask((Writer)null, manager, (DiagnosticListener)null, options,
                        null, Arrays.asList(javaFileObject));

//                task =this.compiler.getTask((Writer)null, manager, (DiagnosticListener)null,
//                        Arrays.asList("-classpath","./E:\\core\\mg\\bussiness\\node\\node.article\\target\\tmp\\BOOT-INF\\lib\\mybatis-3.5.1.jar;E:\\core\\mg\\bussiness\\node\\node.article\\target\\tmp\\BOOT-INF\\lib\\mg-common-node-1.0.jar;E:\\core\\mg\\bussiness\\node\\node.article\\target\\tmp\\BOOT-INF\\classes;")
//                        ,null, Arrays.asList(javaFileObject));
            }
            Boolean result = task.call();
            if (result == null || !result) {
                throw new RuntimeException("Compilation failed.");
            }

            var8 = manager.getClassBytes();
        } catch (Throwable var17) {
            var4 = var17;
            throw var17;
        } finally {
            if (manager != null) {
                if (var4 != null) {
                    try {
                        manager.close();
                    } catch (Throwable var16) {
                        var4.addSuppressed(var16);
                    }
                } else {
                    manager.close();
                }
            }

        }

        return var8;
    }



    public Class<?> loadClass(String name, Map<String, byte[]> classBytes) throws ClassNotFoundException, IOException {
        MemoryClassLoader classLoader = new MemoryClassLoader(classBytes);
        Throwable var4 = null;

        Class var5;
        try {
            var5 = classLoader.loadClass(name);
        } catch (Throwable var14) {
            var4 = var14;
            throw var14;
        } finally {
            if (classLoader != null) {
                if (var4 != null) {
                    try {
                        classLoader.close();
                    } catch (Throwable var13) {
                        var4.addSuppressed(var13);
                    }
                } else {
                    classLoader.close();
                }
            }

        }

        return var5;
    }

//    public static void main(String[] args) throws IOException {
//        JavaStringCompiler  compiler = new JavaStringCompiler();
//        compiler.buildClassPath(new File("E:\\core\\mg\\bussiness\\node\\node.article\\target\\mg-node-article-1.0.jar"),"/tmp");
//    }
}

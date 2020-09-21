package com.mg.node.common.util;

import com.mg.common.util.BaseFileUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

@Slf4j
public class JarUtil {
    public String buildClassPath(File jarFile, String url) throws IOException {
        JarFile jf = new JarFile(jarFile);
        File rootFile = new File(jarFile.getParent(),url);


        log.info("....2222...{}",rootFile.getPath());
        if(rootFile.exists())
        {
            BaseFileUtil.delete(rootFile);
        }

        for (Enumeration e = jf.entries(); e.hasMoreElements();)
        {
            JarEntry je = (JarEntry) e.nextElement();
            String outFileName = new File( rootFile.getPath() ,je.getName()).getPath();
            File f = new File(outFileName);
            System.out.println(f.getAbsolutePath());
            f.getParentFile().mkdirs();
            if(je.isDirectory())
            {
                continue;
            }
            InputStream in = null;
            OutputStream out = null;
            try
            {
                in = jf.getInputStream(je);
                out = new BufferedOutputStream(new FileOutputStream(f));
                byte[] buffer = new byte[2048];
                int nBytes = 0;
                while ((nBytes = in.read(buffer)) > 0)
                {
                    out.write(buffer, 0, nBytes);
                }
            }catch (IOException ioe)
            {
                throw ioe;
            } finally
            {
                try
                {
                    if (null != out)
                    {
                        out.flush();
                        out.close();
                    }
                } catch (IOException ioe)
                {
                    throw ioe;
                }
                finally
                {
                    if (null != in)
                    {
                        in.close();
                    }
                }
            }
        }
        return rootFile.getPath();
    }
}

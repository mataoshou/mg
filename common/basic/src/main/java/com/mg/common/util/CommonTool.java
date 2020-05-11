package com.mg.common.util;

import java.io.File;

public class CommonTool {

    public File getSysPath(String packageName)
    {
        String sys = this.getClass().getResource("/").getPath();

        File  root = new File(sys).getParentFile().getParentFile();
        File coder = new File(root, "src\\main\\java\\");

        File result = new File(coder,packageName.replace(".","\\"));

        return result;
    }
}

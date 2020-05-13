package com.mg.compose.common.action.sys;

import org.springframework.stereotype.Service;

@Service
public class SysUtil {
    public String getName(String fileName)
    {
        return fileName + ".mg";
    }
}

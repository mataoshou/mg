package com.mg.website.uauth.common.action.sys;

import org.springframework.stereotype.Service;

@Service
public class SysUtil {
    public String getName(String fileName)
    {
        return fileName + ".mg";
    }
}

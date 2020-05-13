package com.mg.compose.common.action.sys;



import com.mg.common.util.FileStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@RestController
@Slf4j
public class SysPageController {

    @Autowired
    SysUtil util;

    @RequestMapping("sys/page/{pageName}")
    public String get(HttpServletRequest request, HttpServletResponse response,@PathVariable String pageName) throws IOException {

        File file = new File(this.getClass().getResource("").getPath(),util.getName(pageName));

        System.out.println(file.getPath());

        String content = FileStore.getContent(file);

        System.out.println(content);

        return content;

    }
}

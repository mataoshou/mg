package com.mg.node.action;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import java.io.File;
import java.io.IOException;

@RestController
@MultipartConfig
public class FileUploadController {

//    @CrossOrigin(origins="*")

    @RequestMapping(value="/upload",method=RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile file)
    {
//        StandardMultipartHttpServletRequest.StandardMultipartFile cf = (CommonsMultipartFile) file;
//
//        DiskFileItem fi = (DiskFileItem) cf.getFileItem();
//
//        File f = fi.getStoreLocation();
//
//        System.out.println("........................."+f.getPath());
        System.out.println("..........................开始上传");
        if(file.isEmpty())
        {
            return "上传失败，请选择文件";
        }

        System.out.println(".........."+file.getOriginalFilename());

        String fileName = file.getOriginalFilename();
        String docPath = "c:/tmp1";
        File root = new File(docPath);

        root.mkdirs();


        File dst = new File(root,fileName);

        try {
            file.transferTo(dst);
            System.out.println("完成上传");
            return "success";
        } catch (IOException e) {

            e.printStackTrace();

            return "fail";
        }



    }

//
//    @Bean(name = "multipartResolver")
//    public MultipartResolver multipartResolver(){
//        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//        resolver.setDefaultEncoding("UTF-8");
//        resolver.setResolveLazily(true);//resolveLazily属性启用是为了推迟文件解析，以在在UploadAction中捕获文件大小异常
//        resolver.setMaxInMemorySize(40960);
//        resolver.setMaxUploadSize(5000*1024*1024);//上传文件大小 50M 50*1024*1024
//        return resolver;
//    }

}

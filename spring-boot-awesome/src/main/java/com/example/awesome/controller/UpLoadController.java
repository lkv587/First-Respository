package com.example.awesome.controller;

import com.example.awesome.pojo.bo.UploadBO;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName ：UpLoadController
 * @Description ：TODO
 * @Author ：lkv587
 * @Date ：2020-01-13 15:40
 * @Version ：V1.0.0
 */
@RestController("/upload")
public class UpLoadController {


    /**
     * @Description: MultipartFile 上传
     * @Param:
     * @return:
     * @Author: LKV587
     * @Date: 2020/1/13 16:05
     */
    @PostMapping("/file1")
    public String uploadFile(@ModelAttribute UploadBO upLoadBO){
        // TODO
        upload(upLoadBO.getFiles());
        return null;
    }


    /**
     * @Description: HttpServletRequest 上传
     * @Param:
     * @return:
     * @Author: LKV587
     * @Date: 2020/1/14 16:10
     */
    @PostMapping("/file2")
    public String uploadFile(HttpServletRequest request){
        List<MultipartFile> fileList = new ArrayList<>();
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        Iterator<String> fileNames = multipartHttpServletRequest.getFileNames();
        while (fileNames.hasNext()){
            String name = fileNames.next();
            List<MultipartFile> files = multipartHttpServletRequest.getFiles(name);
            fileList.addAll(files);
        }
        upload(fileList);
        return null;
    }

    /**
     * @Description: 文件上传处理
     * @Param: 
     * @return: 
     * @Author: LKV587
     * @Date: 2020/1/15 16:11
     */
    private void upload(List<MultipartFile> fileList) {
        System.out.println("文件上传处理");
    }

}

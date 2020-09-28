package com.example.awesome.pojo.bo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @ClassName ：UploadBO
 * @Description ：TODO
 * @Author ：lkv587
 * @Date ：2020-01-13 15:44
 * @Version ：V1.0.0
 */
@Data
public class UploadBO {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 上传类型
     */
    private String type;

    /**
     * 单个文件
     */
    private MultipartFile file;

    /**
     * 多个文件
     */
    private List<MultipartFile> files;
}

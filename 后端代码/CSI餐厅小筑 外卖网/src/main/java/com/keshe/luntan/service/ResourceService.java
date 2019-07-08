package com.keshe.luntan.service;

import com.keshe.luntan.entity.ResponseBean;
import org.springframework.web.multipart.MultipartFile;

public interface ResourceService {

    // 上传文件
    public ResponseBean uploadFile(MultipartFile file);

    //绑定手机
    public ResponseBean getPhoneCode(String phonenumber);

    //删除文件
    ResponseBean delateFile(String fileName);
}

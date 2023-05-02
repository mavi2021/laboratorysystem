package com.cqupt.laboratorysystem.service;

import com.aliyun.oss.model.OSSObject;

/**
 * @create 2023/5/2 10:52
 */
public interface DocumentService {

    void upload(String filePath);

    OSSObject downloadDocument(String folderName, String objectName);

    void deleteDocument(String folderName, String objectName);

}

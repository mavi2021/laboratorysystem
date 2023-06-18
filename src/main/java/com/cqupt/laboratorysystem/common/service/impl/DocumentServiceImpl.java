package com.cqupt.laboratorysystem.common.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.DeleteBucketCnameRequest;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.PutObjectRequest;
import com.cqupt.laboratorysystem.common.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @create 2023/5/2 10:54
 */
@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {

    private final OSS ossClient;

    @Value("${aliyun.oss.file.bucketName}")
    private String bucketName;

    @Value("${aliyun.oss.file.root}")
    private String fileRoot;

    @Override
    public void upload(String filePath) {
        File file = new File(filePath);
        String fileName = file.getName();
        String key = fileRoot + "/" + fileName;
        PutObjectRequest request = new PutObjectRequest(bucketName, key, file);
        ossClient.putObject(request);
    }

    @Override
    public OSSObject downloadDocument(String folderName, String objectName) {
        String key = folderName + "/" + objectName;
        GetObjectRequest request = new GetObjectRequest(bucketName, key);
        return ossClient.getObject(request);
    }

    @Override
    public void deleteDocument(String folderName, String objectName) {
        String key = folderName + "/" + objectName;
        DeleteBucketCnameRequest request = new DeleteBucketCnameRequest(bucketName, key);
        ossClient.deleteObject(request);
    }
}

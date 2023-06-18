package com.cqupt.laboratorysystem.controller;

import com.cqupt.laboratorysystem.common.dto.Result;
import com.cqupt.laboratorysystem.service.DocumentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @create 2023/5/1 11:48
 */
@Api(tags = "文件管理相关接口")
@RestController
@RequestMapping("/file")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @GetMapping("/upload")
    public Result upload(){
//        documentService.upload("1");
        return Result.success();
    }

    @GetMapping("/download")
    public Result download(){
        return Result.success();
    }

}

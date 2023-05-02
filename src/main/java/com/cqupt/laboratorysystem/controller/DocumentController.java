package com.cqupt.laboratorysystem.controller;

import com.cqupt.laboratorysystem.dto.Result;
import com.cqupt.laboratorysystem.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : ZengJun
 * @create 2023/5/1 11:48
 */
@RestController
@RequestMapping("/file")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @GetMapping("/upload")
    public Result upload(){
//        documentService.upload("1");
        return Result.ok();
    }

    @GetMapping("/download")
    public Result download(){
        return Result.ok();
    }

}

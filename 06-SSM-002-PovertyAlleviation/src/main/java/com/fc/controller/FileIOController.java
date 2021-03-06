package com.fc.controller;

import com.fc.service.FileIOControllerService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileIOController {
    @Autowired
    private FileIOControllerService fileIOControllerService;

    @PostMapping("uploadImg")
    public ResultVO fileUpload(MultipartFile file, @RequestParam String type){
        return fileIOControllerService.fileUpload(file,type);
    }

}
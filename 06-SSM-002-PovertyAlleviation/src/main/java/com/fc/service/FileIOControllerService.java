package com.fc.service;

import com.fc.vo.ResultVO;
import org.springframework.web.multipart.MultipartFile;

public interface FileIOControllerService {
    ResultVO fileUpload(MultipartFile file, String type);
}

package com.kodlamaio.HRManageSystem.core.utilities.image;

import com.kodlamaio.HRManageSystem.core.utilities.result.Result;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface FileService {

    String upload(File file);

}

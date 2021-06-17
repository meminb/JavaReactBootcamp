package com.kodlamaio.HRManageSystem.business.abstracts.resume;

import com.kodlamaio.HRManageSystem.core.utilities.result.Result;

import java.io.IOException;

public interface ImageService {
    Result add(int resumeId,String path) throws IOException;

}

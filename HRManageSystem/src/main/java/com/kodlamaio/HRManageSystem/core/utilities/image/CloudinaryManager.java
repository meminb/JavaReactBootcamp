package com.kodlamaio.HRManageSystem.core.utilities.image;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
@Component
@Service
@SpringBootApplication
public class CloudinaryManager implements FileService {


    Cloudinary cloudinary;

    public CloudinaryManager() {
        this.cloudinary = new com.cloudinary.Cloudinary(ObjectUtils.asMap(
                "cloud_name","meminbilgic",
                "api_key","547646816258899",
                "api_secret","gczg66myWfdGeu-qH8mabrPym6I"
        ));
    }

    @Override
    public String upload(File file) {
        try {
            Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            return  (uploadResult.get("url").toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

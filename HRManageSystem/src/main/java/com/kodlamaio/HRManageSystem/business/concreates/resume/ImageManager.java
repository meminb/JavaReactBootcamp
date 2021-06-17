package com.kodlamaio.HRManageSystem.business.concreates.resume;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.kodlamaio.HRManageSystem.business.abstracts.resume.ImageService;
import com.kodlamaio.HRManageSystem.core.utilities.image.FileService;
import com.kodlamaio.HRManageSystem.core.utilities.result.Result;
import com.kodlamaio.HRManageSystem.core.utilities.result.SuccessResult;
import com.kodlamaio.HRManageSystem.dataAccess.abstracts.resumeDaos.ImageDao;
import com.kodlamaio.HRManageSystem.dataAccess.abstracts.resumeDaos.ResumeDao;
import com.kodlamaio.HRManageSystem.entities.concreates.resume.Image;
import com.kodlamaio.HRManageSystem.entities.concreates.resume.Resume;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.imageio.stream.FileImageInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Map;

@Component
@Service
@SpringBootApplication
public class ImageManager implements ImageService {

    FileService fileService;
    ImageDao imageDao;
    ResumeDao resumeDao;



    @Autowired
    public  ImageManager(FileService fileService, ImageDao imageDao, ResumeDao resumeDao){

        this.resumeDao=resumeDao;
        this.fileService=fileService;
        this.imageDao=imageDao;
    }


    @Override
    public Result add(int resumeId,String path) throws IOException {// path mean is location of your image you wanted to upload

        Resume resume=resumeDao.getOne(resumeId);
        File file= (new File(path));


        String link=fileService.upload(file);// uploading image to cloudinary
        // if you get errors about fileservice which implemented by CLOUDINARY you should check my pom.xml dependency
        // and "core/utilities/image" system

        Image image=new Image(0,link,resume);

        resume.setImage(image);


        imageDao.save(image);
        resumeDao.save(resume);
        return new SuccessResult("Image inserted to resume that resume_id is "+ resumeId+", Link of picture"+link);
    }


}

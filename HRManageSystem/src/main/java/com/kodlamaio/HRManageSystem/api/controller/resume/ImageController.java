package com.kodlamaio.HRManageSystem.api.controller.resume;


import com.kodlamaio.HRManageSystem.business.abstracts.resume.ImageService;
import com.kodlamaio.HRManageSystem.core.utilities.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/image")
public class ImageController {

    ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService){this.imageService=imageService;}





    @PostMapping()
    public Result add(@RequestParam String path, @RequestParam int resumeId) throws IOException {
        // path parameter  is a picture's path from your computer, such as : "/home/meb/Pictures/Bing/demo.jpg"
        // path parametresine istediğiniz bir dosyanın tam yolunu girin, örnek: "/home/meb/Pictures/Bing/demo.jpg"

        return this.imageService.add(resumeId,path);
    }




}

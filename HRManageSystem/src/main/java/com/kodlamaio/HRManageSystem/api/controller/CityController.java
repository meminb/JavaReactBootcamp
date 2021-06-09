package com.kodlamaio.HRManageSystem.api.controller;

import com.kodlamaio.HRManageSystem.business.abstracts.CityService;
import com.kodlamaio.HRManageSystem.core.utilities.result.DataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.Result;
import com.kodlamaio.HRManageSystem.entities.concreates.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city")
public class CityController {

    CityService cityService;
    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }


    @GetMapping("/getAll")
    DataResult<List<City>> getAll(){

        return cityService.getAll();
    }


    @GetMapping("/getByCityId")
    DataResult<City> getByCityId(int cityId){

        return cityService.getByCityId(cityId);
    }


    @PostMapping("addCity")
    Result add(@RequestParam String cityName){
        return cityService.add(cityName);


    }


}

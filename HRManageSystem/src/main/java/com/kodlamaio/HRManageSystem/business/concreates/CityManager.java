package com.kodlamaio.HRManageSystem.business.concreates;

import com.kodlamaio.HRManageSystem.business.abstracts.CityService;
import com.kodlamaio.HRManageSystem.core.utilities.result.*;
import com.kodlamaio.HRManageSystem.dataAccess.abstracts.CityDao;
import com.kodlamaio.HRManageSystem.entities.concreates.City;
import com.kodlamaio.HRManageSystem.entities.concreates.JobPost;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
@Service
@SpringBootApplication
public class CityManager implements CityService {


    private CityDao cityDao;

    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public DataResult<List<City>> getAll() {
        return new SuccessDataResult<List<City>>(this.cityDao.findAll());
    }

    @Override
    public Result add(String cityName) {

        if(cityName==null || cityName.length()<2){
            return new ErrorResult("Bad city name");
        }

        this.cityDao.save(new City(0,cityName,new ArrayList<JobPost>()));
        return new SuccessResult("City saved");
    }

    @Override
    public DataResult<City> getByCityId(int cityId) {
        return new SuccessDataResult<City>(this.cityDao.getByCityId(cityId));
    }
}

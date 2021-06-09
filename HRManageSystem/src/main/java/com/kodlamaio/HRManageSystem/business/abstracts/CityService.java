package com.kodlamaio.HRManageSystem.business.abstracts;

import com.kodlamaio.HRManageSystem.core.utilities.result.DataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.Result;
import com.kodlamaio.HRManageSystem.entities.concreates.City;
import com.kodlamaio.HRManageSystem.entities.concreates.Employee;

import java.util.List;

public interface CityService {
    DataResult<List<City>> getAll();
    Result add(String cityName);
    DataResult<City> getByCityId(int cityId);
}

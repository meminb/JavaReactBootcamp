package com.kodlamaio.HRManageSystem.business.concreates;

import com.kodlamaio.HRManageSystem.business.abstracts.JobPositionService;
import com.kodlamaio.HRManageSystem.dataAccess.abstracts.ProductDao;
import com.kodlamaio.HRManageSystem.entities.concreates.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Component
@Service
@SpringBootApplication
public class JobPositionManager implements JobPositionService {
    private ProductDao productDao;

    @Autowired
    public JobPositionManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<JobPosition> getAll() {
        return this.productDao.findAll();
    }
}

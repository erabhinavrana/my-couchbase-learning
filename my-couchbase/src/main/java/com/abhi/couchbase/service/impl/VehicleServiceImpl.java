package com.abhi.couchbase.service.impl;

import com.abhi.couchbase.model.Vehicle;
import com.abhi.couchbase.repo.VehicleRepo;
import com.abhi.couchbase.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Abhinav on 12/18/2018.
 */
@Service("vehicleService")
public class VehicleServiceImpl implements VehicleService{

    /**
     * The Vehicle repo.
     */
    @Autowired
    public VehicleRepo vehicleRepo;

    @Override
    @Cacheable(value = "VEHICLE", key = "#id")
    public Vehicle getByID(int id) {
        return vehicleRepo.getByID(id);
    }

    @Override
    @Cacheable(value = "VEHICLE", key = "#type")
    public List<Vehicle> getByType(String type) {
        return vehicleRepo.getByType(type);
    }

    @Override
    @CachePut(value="VEHICLE", key = "#id")
    public Vehicle put(String model, int id) {
        return vehicleRepo.put(model, id);
    }

    @Override
    @CacheEvict(value = "VEHICLE", key = "#id")
    public void flushByID(int id){

    }

    @Override
    @CacheEvict(value = "VEHICLE", key = "#type")
    public void flushByType(String type){

    }

}

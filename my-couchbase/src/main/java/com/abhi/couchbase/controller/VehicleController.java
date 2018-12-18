package com.abhi.couchbase.controller;

import com.abhi.couchbase.model.Vehicle;
import com.abhi.couchbase.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Abhinav on 12/18/2018.
 */

@RestController
public class VehicleController {
    @Autowired
    VehicleService vehicleService;

    @RequestMapping("/vehicleByID")
    public Vehicle getByID(@RequestParam("id") int id){
        return vehicleService.getByID(id);
    }

    @RequestMapping("/vehicleByType")
    public List<Vehicle> getByType(@RequestParam("type") String type){
        return vehicleService.getByType(type);
    }

    @RequestMapping("/update")
    public Vehicle updateVehicle(@RequestParam("model") String model, @RequestParam("id") int id){
        return vehicleService.put(model, id);
    }

    @RequestMapping("/flushByID")
    public void flushCacheByID(@RequestParam("id") int id){
        vehicleService.flushByID(id);
    }

    @RequestMapping("/flushByType")
    public void flushCacheByType(@RequestParam("type") String type){
        vehicleService.flushByType(type);
    }
}

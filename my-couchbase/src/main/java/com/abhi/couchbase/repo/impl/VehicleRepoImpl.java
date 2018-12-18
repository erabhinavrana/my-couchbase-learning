package com.abhi.couchbase.repo.impl;

import com.abhi.couchbase.model.Vehicle;
import com.abhi.couchbase.repo.VehicleRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Abhinav on 12/18/2018.
 */
@Repository("vehicleRepo")
public class VehicleRepoImpl implements VehicleRepo {
    private static Map<Integer, Vehicle> vehicleMap = new HashMap<Integer, Vehicle>();
    static {
        vehicleMap.put(1, new Vehicle(1,"4WD","Nissan","2018","PETROL SV"));
        vehicleMap.put(2, new Vehicle(2,"AWD","Nissan","2018","KICK SL"));
    }

    @Override
    public Vehicle getByID(int id) {
        System.out.println("Fetching the Vehicle based on input Vehicle ID.....");
        try {
            Thread.sleep(5000); // this for demo purpose only
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return vehicleMap.get(id);
    }

    @Override
    public List<Vehicle> getByType(String type) {
        System.out.println("Fetching the Vehicle based on input Vehicle Type.....");
        List<Vehicle> vehicleList = new ArrayList<Vehicle>();
        for (Vehicle vehicle: vehicleMap.values()) {
            if (vehicle.getType().equalsIgnoreCase(type)){
                vehicleList.add(vehicle);
            }
        }
        try {
            Thread.sleep(3000); // this for demo purpose only
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return vehicleList;
    }

    @Override
    public Vehicle put(String model, int id) {
        Vehicle oldVehicle = getByID(id);
        oldVehicle.setModel(model);
        return oldVehicle;
    }
}

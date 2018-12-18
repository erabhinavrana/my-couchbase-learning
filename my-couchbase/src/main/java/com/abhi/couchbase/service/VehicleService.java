package com.abhi.couchbase.service;

import com.abhi.couchbase.model.Vehicle;

import java.util.List;

/**
 * Created by Abhinav on 12/18/2018.
 */
public interface VehicleService {
    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    Vehicle getByID(int id);

    /**
     * Gets by type.
     *
     * @param type the type
     * @return the by type
     */
    List<Vehicle> getByType(String type);

    /**
     * Put vehicle.
     *
     * @param model the model
     * @param id    the id
     * @return the vehicle
     */
    Vehicle put(String model, int id);

    /**
     * Flush by id.
     *
     * @param id the id
     */
    void flushByID(int id);

    /**
     * Flush by type.
     *
     * @param type the type
     */
    void flushByType(String type);
}

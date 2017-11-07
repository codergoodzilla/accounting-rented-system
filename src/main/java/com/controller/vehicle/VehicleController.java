package com.controller.vehicle;

import com.domain.vehicle.InputVehicle;
import com.domain.vehicle.Vehicle;
import com.service.vehicle.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(path="/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService service;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public @ResponseBody
    Vehicle findByLicensePlate(@RequestParam String licensePlate) {
        return service.findByLicensePlate(licensePlate);
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void create(@Valid @RequestBody InputVehicle vehicle) {
        service.create(vehicle);
    }

    @RequestMapping(path = "/delete", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@RequestParam Integer id) {
        service.delete(id);
    }
}
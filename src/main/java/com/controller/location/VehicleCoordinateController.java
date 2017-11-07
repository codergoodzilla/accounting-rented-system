package com.controller.location;

import com.domain.location.CoordinateHistory;
import com.domain.location.InputVehicleCoordinate;
import com.service.location.VehicleCoordinateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path="/vehicle-coordinate")
public class VehicleCoordinateController {

    @Autowired
    private VehicleCoordinateService service;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public @ResponseBody
    List<CoordinateHistory> getStatisticBy(@RequestParam Integer categoryId, @RequestParam Integer markId) {
        return service.getStatisticBy(categoryId, markId);
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void create(@Valid @RequestBody InputVehicleCoordinate coordinate) {
        service.create(coordinate);
    }

    @RequestMapping(path = "/delete", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@RequestParam Integer id) {
        service.delete(id);
    }
}

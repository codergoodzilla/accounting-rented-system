package com.controller.dictionary;

import com.domain.dictionary.InputVehicleModel;
import com.domain.dictionary.VehicleModel;
import com.service.dictionary.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path="/vehicle-model")
public class VehicleModelController {

    @Autowired
    private VehicleModelService service;

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<VehicleModel> getAll() {
        return service.getAll();
    }

    @RequestMapping(path = "/find-by-name", method = RequestMethod.GET)
    public @ResponseBody
    VehicleModel findByLicensePlate(@RequestParam String name) {
        return service.findByName(name);
    }

    @RequestMapping(path = "/find-by", method = RequestMethod.GET)
    public @ResponseBody
    List<VehicleModel> findByCategoryAndMark(@RequestParam int categoryId, @RequestParam int markId) {
        return service.findByCategoryAndMark(categoryId, markId);
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void create(@Valid @RequestBody InputVehicleModel vehicleModel) {
        service.create(vehicleModel);
    }

    @RequestMapping(path = "/delete", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@RequestParam Integer id) {
        service.delete(id);
    }
}

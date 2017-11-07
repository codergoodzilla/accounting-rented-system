package com.controller.dictionary;

import com.domain.dictionary.VehicleCategory;
import com.service.dictionary.VehicleCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(path="/vehicle-category")
public class VehicleCategoryController {

    @Autowired
    private VehicleCategoryService service;

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public @ResponseBody Iterable<VehicleCategory> getAll() {
        return service.getAll();
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public @ResponseBody VehicleCategory findByName(@RequestParam String name) {
        return service.findByName(name);
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void create(@Valid @RequestBody String name) {
        service.create(name);
    }

    @RequestMapping(path = "/delete", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@RequestParam Integer id) {
        service.delete(id);
    }
}
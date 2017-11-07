package com.controller.dictionary;

import com.domain.dictionary.VehicleMark;
import com.service.dictionary.VehicleMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(path="/vehicle-mark")
public class VehicleMarkController {

    @Autowired
    private VehicleMarkService service;

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<VehicleMark> getAll() {
        return service.getAll();
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public @ResponseBody VehicleMark findByName(@RequestParam String name) {
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
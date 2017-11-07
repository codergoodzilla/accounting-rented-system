package com.controller.renter;

import com.domain.renter.InputRenter;
import com.domain.renter.Renter;
import com.service.renter.RenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(path="/renter")
public class RenterController {

    @Autowired
    private RenterService service;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public @ResponseBody Renter findByName(@RequestParam String name) {

        return service.findByName(name);
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void create(@Valid @RequestBody InputRenter inputRenter) {

        service.create(inputRenter);
    }

    @RequestMapping(path = "/delete", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@RequestParam Integer id) {
        service.delete(id);
    }
}

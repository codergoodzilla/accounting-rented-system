package com.controller.accounting;

import com.domain.accounting.AccountingHistory;
import com.domain.accounting.InputAccountingRecord;
import com.service.accounting.AccountingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path="/accounting-record")
public class AccountingRecordController {

    @Autowired
    private AccountingRecordService service;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public @ResponseBody List<Integer> findAll() {
        return service.findAll();
    }

    @RequestMapping(path = "/find/", method = RequestMethod.GET)
    public @ResponseBody AccountingHistory findById(@RequestParam int id) {
        return service.findById(id);
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void create(@Valid @RequestBody InputAccountingRecord record) {
        service.create(record);
    }

    @RequestMapping(path = "/delete", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@RequestParam Integer id) {
        service.delete(id);
    }
}

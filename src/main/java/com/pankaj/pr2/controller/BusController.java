package com.pankaj.pr2.controller;

import com.pankaj.pr2.entity.Buses;
import com.pankaj.pr2.service.BusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/buses")
public class BusController {
    private BusService busService;

    public BusController(BusService busService) {
        this.busService = busService;

    }

    @PostMapping
    public ResponseEntity<String> addbuses(@RequestBody Buses bus){
                                busService.addbuses(bus);
        return new ResponseEntity<>("Added", HttpStatus.CREATED);

    }







}

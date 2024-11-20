package com.pankaj.pr2.controller;

import com.pankaj.pr2.entity.Buses;
import com.pankaj.pr2.entity.Stops;
import com.pankaj.pr2.service.BusService;
import com.pankaj.pr2.service.StopsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/stops")
public class StopsController {


   private StopsService stopsService;

    public StopsController(StopsService stopsService) {
        this.stopsService = stopsService;
    }

    @PostMapping
        public ResponseEntity<String> addstops(@RequestBody Stops stops){
         stopsService. addstops(stops);
            return new ResponseEntity<>("Added", HttpStatus.CREATED);

        }

    }

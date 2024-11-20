package com.pankaj.pr2.controller;

import com.pankaj.pr2.entity.BusStop;
import com.pankaj.pr2.service.BusService;
import com.pankaj.pr2.service.BusStopService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/busstops")
public class BusStopsController {
    private BusStopService busStopService;

    public BusStopsController(BusStopService busStopService) {
        this.busStopService = busStopService;
    }


    @PostMapping
    public ResponseEntity<String>Adddata( @RequestParam Long buses_id, @RequestParam Long stops_id, @RequestBody BusStop stopsname){
       busStopService.Adddata( stopsname, buses_id, stops_id);

return new ResponseEntity<>("Done", HttpStatus.CREATED);
    }




}

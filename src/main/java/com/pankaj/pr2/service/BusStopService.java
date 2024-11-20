package com.pankaj.pr2.service;

import com.pankaj.pr2.entity.BusStop;
import com.pankaj.pr2.entity.Buses;
import com.pankaj.pr2.entity.Stops;
import com.pankaj.pr2.repository.BusStopRepository;
import com.pankaj.pr2.repository.BusesRepository;
import com.pankaj.pr2.repository.StopsRepository;
import org.springframework.stereotype.Service;

@Service
public class BusStopService {
    private BusStopRepository busStopRepository;
    private BusesRepository busesRepository;
    private StopsRepository stopsRepository;
    public BusStopService(BusStopRepository busStopRepository, BusesRepository busesRepository, StopsRepository stopsRepository) {
        this.busStopRepository = busStopRepository;
        this.busesRepository = busesRepository;
        this.stopsRepository = stopsRepository;
    }

    public void Adddata(BusStop stopsname, Long buses_id, Long stops_id){
        Buses buses = busesRepository.findById(buses_id).get();
        Stops stops = stopsRepository.findById(stops_id).get();
        BusStop busStop=new BusStop();
        busStop.setBuses(buses);
        busStop.setStopsname(stops.getName());
        busStop.setStops(stops);
        busStopRepository.save(busStop);

    }
}

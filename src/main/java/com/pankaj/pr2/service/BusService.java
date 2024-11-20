package com.pankaj.pr2.service;

import com.pankaj.pr2.entity.BusStop;
import com.pankaj.pr2.entity.Buses;
import com.pankaj.pr2.entity.Stops;
import com.pankaj.pr2.repository.BusesRepository;
import org.springframework.stereotype.Service;

@Service
public class BusService {
private BusesRepository busesRepository;

    public BusService(BusesRepository busesRepository) {
        this.busesRepository = busesRepository;
    }

    public void addbuses(Buses bus) {
        busesRepository.save(bus);
    }



}

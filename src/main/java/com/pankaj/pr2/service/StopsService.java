package com.pankaj.pr2.service;

import com.pankaj.pr2.entity.Stops;
import com.pankaj.pr2.repository.StopsRepository;
import org.springframework.stereotype.Service;

@Service
public class StopsService {
    private StopsRepository stopsRepository;

    public StopsService(StopsRepository stopsRepository) {
        this.stopsRepository = stopsRepository;
    }

    public void addstops(Stops stops) {
        stopsRepository.save(stops);
    }
}

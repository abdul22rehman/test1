package com.pankaj.pr2.repository;

import com.pankaj.pr2.entity.BusStop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusStopRepository extends JpaRepository<BusStop, Long> {
}
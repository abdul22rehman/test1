package com.pankaj.pr2.repository;

import com.pankaj.pr2.entity.Buses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusesRepository extends JpaRepository<Buses, Long> {
}
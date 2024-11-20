package com.pankaj.pr2.repository;

import com.pankaj.pr2.entity.Stops;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StopsRepository extends JpaRepository<Stops, Long> {
}
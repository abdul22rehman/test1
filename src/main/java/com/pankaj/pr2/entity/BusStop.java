package com.pankaj.pr2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "bus_stop_1")
public class BusStop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "buses_id")
    private Buses buses;

    @ManyToOne
    @JoinColumn(name = "stops_id")
    private Stops stops;

    @Column(name = "stopsname")

    private String stopsname;
    public String getStopsname() {
        return stopsname;
    }

    public void setStopsname(String stopsname) {
        this.stopsname = stopsname;
    }


}
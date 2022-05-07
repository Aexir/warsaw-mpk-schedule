package pl.dabkowski.edp.database.entities;

import java.util.List;

public class ZtmSchedule {
    private String line;
    private String bus_stop_id;
    private String bus_stop_nr;
    private List<ZtmRide> rides;
}

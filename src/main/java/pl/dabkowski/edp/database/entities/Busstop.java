package pl.dabkowski.edp.database.entities;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Busstop {
    public static List<Busstop> busstos = new ArrayList<>();

    private String street;
    private String stop_id;
    private String stop_nr;
    private Location location;
}

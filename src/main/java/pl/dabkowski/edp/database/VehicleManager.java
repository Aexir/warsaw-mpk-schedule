package pl.dabkowski.edp.database;

import pl.dabkowski.edp.database.entities.ZtmVehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleManager {
    private static final List<ZtmVehicle> buses = new ArrayList<>();
    private static final List<ZtmVehicle> trams = new ArrayList<>();

    public static void addZtmVehicle(ZtmVehicle ztmVehicle) {
        if (ztmVehicle.getType() == 1) {
            buses.add(ztmVehicle);
        } else {
            trams.add(ztmVehicle);
        }
    }

    public static List<ZtmVehicle> getBusByLine(String line){
        List<ZtmVehicle> buses = new ArrayList<>();
        for (ZtmVehicle bus : buses){
            if (bus.getLine().equals(line)){
                buses.add(bus);
            }
        }
        return buses;
    }


}

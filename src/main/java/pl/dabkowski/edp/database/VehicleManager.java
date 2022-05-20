package pl.dabkowski.edp.database;

import lombok.Getter;
import pl.dabkowski.edp.database.entities.ZtmVehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleManager {
    @Getter
    private static final List<ZtmVehicle> buses = new ArrayList<>();
    private static final List<ZtmVehicle> trams = new ArrayList<>();

    public static void addZtmVehicle(ZtmVehicle ztmVehicle) {
        if (ztmVehicle.getType() == 1) {
            buses.add(ztmVehicle);
        } else {
            trams.add(ztmVehicle);
        }
    }

    public static int getBusesCount() {
        return buses.size();
    }

    public static int getTramCount() {
        return trams.size();
    }


    public static List<ZtmVehicle> getBusByLine(String line) {
        List<ZtmVehicle> buses = new ArrayList<>();
        for (ZtmVehicle bus : buses) {
            if (bus.getLine().equals(line)) {
                buses.add(bus);
            }
        }
        return buses;
    }


}

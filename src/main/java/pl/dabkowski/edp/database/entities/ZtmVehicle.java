package pl.dabkowski.edp.database.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ZtmVehicle {
    private Location location;
    private String line;
    private String vehicle_number;
    private LocalDateTime time;
    private String brigade;
    private int type;
}

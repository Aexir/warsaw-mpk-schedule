package pl.dabkowski.edp.database.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ZtmRide {
    private int brigade;
    private String direction;
    private String route;
    private String time;
}

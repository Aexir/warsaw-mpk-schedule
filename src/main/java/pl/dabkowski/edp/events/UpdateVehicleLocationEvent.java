package pl.dabkowski.edp.events;

import javafx.event.Event;
import javafx.event.EventType;

public class UpdateVehicleLocationEvent extends Event {
    public UpdateVehicleLocationEvent(EventType<? extends Event> eventType) {
        super(eventType);
    }
}

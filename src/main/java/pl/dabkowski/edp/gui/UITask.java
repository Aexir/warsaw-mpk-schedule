package pl.dabkowski.edp.gui;

import javafx.concurrent.Task;
import pl.dabkowski.edp.database.entities.Busstop;
import pl.dabkowski.edp.gui.controllers.MapSceneController;

public class UITask extends Task {
    @Override
    protected Void call() throws Exception {
        System.out.println("XD");
        for (int i = 0; i < Busstop.busstos.size(); i++) {
            MapSceneController.webEngine.executeScript("test(long, lat)".replace("long",
                    String.valueOf(Busstop.busstos.get(i).getLocation().getLongitude())).replace("lat", String.valueOf(Busstop.busstos.get(i).getLocation().getLatitude())));
            updateProgress(i,Busstop.busstos.size());
            System.out.println(i);
        }

        return null;
    }
}

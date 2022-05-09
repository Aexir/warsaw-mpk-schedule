package pl.dabkowski.edp.threads;

import pl.dabkowski.edp.Main;
import pl.dabkowski.edp.database.VehicleManager;

import java.io.IOException;

public class UpdateTramposThread extends Thread{
    @Override
    public void run() {
        while(true){
            try {
                Main.getUmAPI().updateTramLocation();
                Thread.sleep(10000);
            } catch (InterruptedException  e) {
                e.printStackTrace();
            }
        }

    }
}

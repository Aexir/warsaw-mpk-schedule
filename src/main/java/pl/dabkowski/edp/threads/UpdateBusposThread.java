package pl.dabkowski.edp.threads;

import pl.dabkowski.edp.Main;
import pl.dabkowski.edp.UmAPI;
import pl.dabkowski.edp.database.VehicleManager;

import java.io.IOException;

public class UpdateBusposThread extends Thread{
    @Override
    public void run() {
        while(true){
            try {
                Main.getUmAPI().updateBusLocation();
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

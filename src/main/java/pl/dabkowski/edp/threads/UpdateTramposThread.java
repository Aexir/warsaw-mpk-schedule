package pl.dabkowski.edp.threads;

import pl.dabkowski.edp.Main;
import pl.dabkowski.edp.UmAPI;

public class UpdateTramposThread extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                UmAPI.getInstance().updateTramLocation();
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

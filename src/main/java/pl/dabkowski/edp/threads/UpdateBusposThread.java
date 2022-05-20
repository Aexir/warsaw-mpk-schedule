package pl.dabkowski.edp.threads;

import pl.dabkowski.edp.Main;
import pl.dabkowski.edp.UmAPI;

public class UpdateBusposThread extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                UmAPI.getInstance().updateBusLocation();
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

package pl.dabkowski.edp.gui.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import pl.dabkowski.edp.Main;
import pl.dabkowski.edp.database.VehicleManager;
import pl.dabkowski.edp.database.entities.Busstop;

import java.net.URL;

public class MapSceneController {

    public static WebEngine webEngine;

    @FXML
    private WebView mapView;

    @FXML
    private Button refreshButton;

    @FXML
    private Button addbutton;

    @FXML
    void onRefreshClick(MouseEvent event) {
        webEngine = mapView.getEngine();
        mapView.setZoom(1);
        final URL urlGoogleMaps = Main.class.getResource("mapa.html");
        webEngine.load(urlGoogleMaps.toExternalForm());
    }

    public void doLongRunningCall() {

        Platform.runLater(() -> {
//            webEngine.executeScript("test(long, lat)".replace("long",
//                    String.valueOf(Busstop.busstos.get(2).getLocation().getLongitude())).replace("lat", String.valueOf(Busstop.busstos.get(2).getLocation().getLatitude())));
//                for (int i = 0; i < Busstop.busstos.size(); i++) {
//                    webEngine.executeScript("test(long, lat)".replace("long",
//                            String.valueOf(Busstop.busstos.get(i).getLocation().getLongitude())).replace("lat", String.valueOf(Busstop.busstos.get(i).getLocation().getLatitude())));
//                }

            for (int i = 0; i < VehicleManager.getBusesCount(); i++) {
                webEngine.executeScript("test(long, lat)".replace("long",
                        String.valueOf(VehicleManager.getBuses().get(i).getLocation().getLongitude())).replace("lat", String.valueOf(VehicleManager.getBuses().get(i).getLocation().getLatitude())));
            }
        });
    }


    @FXML
    public void onaddClick(MouseEvent mouseEvent) {

        doLongRunningCall();
        System.out.println(Busstop.busstos.size());
        /*

        for (int i = 0; i < Busstop.busstos.size(); i++) {
            webEngine.executeScript("test(long, lat)".replace("long",
                    String.valueOf(Busstop.busstos.get(i).getLocation().getLongitude())).replace("lat", String.valueOf(Busstop.busstos.get(i).getLocation().getLatitude())));
        }
*/

    }
}

package pl.dabkowski.edp.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.WindowEvent;
import pl.dabkowski.edp.Main;

import java.net.URL;

public class MapSceneController {
    @FXML
    private WebView mapView;

    @FXML
    private Button refreshButton;

    @FXML
    void onRefreshClick(MouseEvent event) {
        WebEngine webEngine = mapView.getEngine();
        mapView.setZoom(1);
        final URL urlGoogleMaps = Main.class.getResource("mapa.html");
        webEngine.load(urlGoogleMaps.toExternalForm());
    }

}

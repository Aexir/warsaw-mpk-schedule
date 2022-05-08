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

    private WebEngine webEngine;

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

    @FXML
    public void onaddClick(MouseEvent mouseEvent) {
        webEngine.executeScript("test(51.5, 21.0117800)");

    }
}

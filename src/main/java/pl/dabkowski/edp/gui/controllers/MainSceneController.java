package pl.dabkowski.edp.gui.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pl.dabkowski.edp.Main;

import java.io.IOException;

public class MainSceneController {
    @FXML
    private Button mapButton;

    @FXML
    void onMapButtonClick(MouseEvent event) throws IOException {
        mapButton.setDisable(true);
        Parent fxmlLoader = FXMLLoader.load(Main.class.getResource("map-view.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader);
        Main.getTheStage().setScene(scene);
        scene.widthProperty().addListener((observableValue, number, t1) -> System.out.println("Width: " + t1));
        scene.heightProperty().addListener((observableValue, number, t1) -> System.out.println("Height: " + t1));
    }
}
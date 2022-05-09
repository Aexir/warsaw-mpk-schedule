package pl.dabkowski.edp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;
import pl.dabkowski.edp.database.MySqlManager;
import pl.dabkowski.edp.threads.UpdateBusposThread;
import pl.dabkowski.edp.threads.UpdateTramposThread;

import java.io.IOException;


public class Main extends Application {

    private static Config config;
    @Getter
    private static UmAPI umAPI;
    private static MySqlManager mySqlManager;
    @Getter
    private static Stage theStage;

    public static void main(String[] args) throws IOException {
        config = new Config();
        umAPI = new UmAPI();

        new UpdateBusposThread().start();
        new UpdateTramposThread().start();
        launch();
//        mySqlManager = new MySqlManager();
//        umAPI = new UmAPI();
//        List<Integer> line = new ArrayList<>();
//        for (Result r : umAPI.getBus().getResult()){
//            if (!line.contains(Integer.parseInt(r.getLines()))){
//                line.add(Integer.parseInt(r.getLines()));
//            }
//        }
//
//        Collections.sort(line);
//        Stream.of(line).forEach(System.out::println);
//        List<String> vehicles = new ArrayList<>();
//        mySqlManager.prepareTables();
//        try {
//            ResultSet result = mySqlManager.getConnection().prepareStatement("Select * from VEHICLE").executeQuery();
//            while (result.next()){
//                String number = result.getString("Number");
//                if (!vehicles.contains(number)){
//                    vehicles.add(number);
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        theStage = stage;
        theStage.setTitle("Hello!");
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        theStage.setScene(scene);
        theStage.show();
    }

}

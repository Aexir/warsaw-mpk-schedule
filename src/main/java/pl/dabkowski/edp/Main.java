package pl.dabkowski.edp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.dabkowski.edp.database.MySqlManager;

import java.io.IOException;

public class Main extends Application{

    public static Main instance;
    public static Config config;
    public static UmAPI umAPI;
    public static MySqlManager mySqlManager;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) throws IOException {

        config = new Config();
        umAPI = new UmAPI();
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

}

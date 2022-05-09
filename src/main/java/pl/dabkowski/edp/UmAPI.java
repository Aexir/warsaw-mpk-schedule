package pl.dabkowski.edp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pl.dabkowski.edp.database.VehicleManager;
import pl.dabkowski.edp.database.entities.Busstop;
import pl.dabkowski.edp.database.entities.Location;
import pl.dabkowski.edp.database.entities.ZtmVehicle;
import pl.dabkowski.edp.exceptions.LocationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UmAPI {
    private final String apiKey;
    private final String locationEndpoint = "https://api.um.warszawa.pl/api/action/busestrams_get/";
    private final String scheduleEndpoint = "https://api.um.warszawa.pl/api/action/dbtimetable_get";
    private final Config config;

    public UmAPI() throws IOException {
        this.config = new Config();
        this.apiKey = config.getProperties().getProperty("UM_API_KEY");




        try {
            JSONArray jsonArray = getAllBusStops().getJSONArray("result");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                JSONArray jsonArray1 = obj.getJSONArray("values");
                List<String> stringList = new ArrayList<>();
                for (int j = 0; j < jsonArray1.length(); j++) {

                    //System.out.println(jsonArray1.getString(j));
                    stringList.add((String) jsonArray1.getJSONObject(j).get("value"));

                }

                Busstop busstop = new Busstop();
                try {
                    busstop.setLocation(new Location(stringList.get(4), stringList.get(5)));
                    busstop.setStreet(stringList.get(2));
                    busstop.setStop_id(stringList.get(0));
                    busstop.setStop_nr(stringList.get(1));
                } catch (LocationException e) {
                    e.printStackTrace();
                }
                Busstop.busstos.add(busstop);

                System.out.println(stringList);


                System.out.println("///");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void updateBusLocation(){
        try {
            JSONArray jr = getZtmBuses().getJSONArray("result");
            VehicleManager.getBuses().clear();
            for (int i = 0; i < jr.length(); i++){
                final JSONObject person = jr.getJSONObject(i);
                ZtmVehicle ztmVehicle = new ZtmVehicle();
                ztmVehicle.setBrigade(person.getString("Brigade"));
                ztmVehicle.setLine(person.getString("Lines"));
                ztmVehicle.setLocation(new Location(person.getString("Lat"), person.getString("Lon")));
                ztmVehicle.setVehicle_number(person.getString("VehicleNumber"));
                //ztmVehicle.setTime(LocalDateTime.parse(person.getString("Time"), DateTimeFormatter.ISO_DATE));
                ztmVehicle.setBrigade(person.getString("Brigade"));
                ztmVehicle.setType(1);
                VehicleManager.addZtmVehicle(ztmVehicle);
            }

        } catch (JSONException | LocationException | IOException e) {
            e.printStackTrace();
        }
    }

    public void updateTramLocation(){

        try {
            JSONArray jr = getZtmTrams().getJSONArray("result");
            VehicleManager.getBuses().clear();
            for (int i = 0; i < jr.length(); i++){
                final JSONObject person = jr.getJSONObject(i);
                ZtmVehicle ztmVehicle = new ZtmVehicle();
                ztmVehicle.setBrigade(person.getString("Brigade"));
                ztmVehicle.setLine(person.getString("Lines"));
                ztmVehicle.setLocation(new Location(person.getString("Lat"), person.getString("Lon")));
                ztmVehicle.setVehicle_number(person.getString("VehicleNumber"));
                //ztmVehicle.setTime(LocalDateTime.parse(person.getString("Time"), DateTimeFormatter.ISO_DATE));
                ztmVehicle.setBrigade(person.getString("Brigade"));
                ztmVehicle.setType(2);
                VehicleManager.addZtmVehicle(ztmVehicle);
            }

        } catch (JSONException | LocationException | IOException e) {
            e.printStackTrace();
        }
    }


    public JSONObject getAllBusStops() throws IOException {
        String lynk = "https://api.um.warszawa.pl/api/action/dbstore_get/?id=ab75c33d-3a26-4342-b36a-6e5fef0a3ac3&apikey=" + apiKey;

        return getJsonObject(lynk);
    }

    private JSONObject getJsonObject(String lynk) throws IOException {
        InputStream inputStream = new URL(lynk).openStream();
        try {                                 // try catch for checked exception
            BufferedReader re = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            // Buffer Reading In UTF-8
            StringBuilder sb = new StringBuilder();
            int respone;
            do {
                respone = re.read();
                sb.append((char) respone);
            } while (respone != -1);

            String fullRespone = sb.toString();
            JSONObject jsonObject = new JSONObject(fullRespone);
            return jsonObject;    // Returning JSON
        } catch (Exception e) {
            return null;
        } finally {
            inputStream.close();
        }
    }

    public JSONObject getZtmBuses() throws IOException {
        String lynk = "https://api.um.warszawa.pl/api/action/busestrams_get/?resource_id=f2e5503e927d-4ad3-9500-4ab9e55deb59&apikey=" + apiKey +"&type=1";
        //String lynk = "https://api.um.warszawa.pl/api/action/busestrams_get/?resource_id=f2e5503e927d-4ad3-9500-4ab9e55deb59&apikey=f24cce85-da3c-412b-a0a5-371cf19e3a7f&type=1"
        Logger.getLogger("").log(Level.INFO, "Updated bus locations");

        return getJsonObject(lynk);
    }

    public JSONObject getZtmTrams() throws IOException {
        String lynk = "https://api.um.warszawa.pl/api/action/busestrams_get/?resource_id=f2e5503e927d-4ad3-9500-4ab9e55deb59&apikey=" + apiKey +"&type=2";
        Logger.getLogger("").log(Level.INFO, "Updated trams locations");

        return getJsonObject(lynk);
    }
}

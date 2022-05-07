package pl.dabkowski.edp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class UmAPI {
    private final String apiKey;
    private final String locationEndpoint = "https://api.um.warszawa.pl/api/action/busestrams_get/";
    private final String scheduleEndpoint = "https://api.um.warszawa.pl/api/action/dbtimetable_get";
    private final Config config;

    public UmAPI() throws IOException {
        this.config = new Config();
        this.apiKey = config.getProperties().getProperty("UM_API_KEY");
//        try {
//            JSONArray jr = getZtmRespone(locationEndpoint, "f2e5503e927d-4ad3-9500-4ab9e55deb59", apiKey).getJSONArray("result");
//            for (int i = 0; i < jr.length(); i++){
//                final JSONObject person = jr.getJSONObject(i);
//                System.out.println(person.getString("Lines"));
//                System.out.println(person.getString("Lon"));
//                System.out.println(person.getString("VehicleNumber"));
//                System.out.println(person.getString("Time"));
//                System.out.println(person.getDouble("Lat"));
//                System.out.println(person.getString("Brigade"));
//                System.out.println("+++++++++");
//                buses.add(person.getString("Lines"));
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        System.out.println(buses.size());
//        System.out.println(buses);
//


//        try {
//            JSONArray jsonArray = getAllBusStops().getJSONArray("result");
//
//            for (int i = 0; i < 2; i++){
//                JSONObject obj = jsonArray.getJSONObject(i);
//                JSONArray jsonArray1 = obj.getJSONArray("values");
//                for (int j = 0; j < jsonArray1.length(); j++){
//                    System.out.println(jsonArray1.getString(j));
//                }
//                System.out.println("///");
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
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
                sb.append((char)respone);
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

    public JSONObject getZtmBuses(String endpoint, String resourceid, String apiKey) throws IOException {
        String lynk = endpoint + "?resource_id=" + resourceid +
                "&apikey=" + apiKey + "&type=1";
        return getJsonObject(lynk);
    }

    public JSONObject getZtmTrams(String endpoint, String resourceid, String apiKey) throws IOException {
        String lynk = endpoint + "?resource_id=" + resourceid +
                "&apikey=" + apiKey + "&type=2";
        return getJsonObject(lynk);
    }
}

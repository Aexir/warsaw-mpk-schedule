package pl.dabkowski.edp.database;

import lombok.SneakyThrows;
import pl.dabkowski.edp.Config;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySqlManager {

    private Logger logger;
    private Config config;
    private Connection conn;

    @SneakyThrows
    public MySqlManager() {
        logger = Logger.getLogger(this.getClass().getName());
        config = Config.getInstance();
        prepareConnection();
        prepareTables();
    }

    public Connection prepareConnection() {
        try {
            String url = "jdbc:mysql://" + config.getProperty("DATABASE_URL") + "/" + config.getProperty("DATABASE_NAME");
            return DriverManager.getConnection(url, config.getProperty("DATABASE_USER"), config.getProperty("DATABASE_PASSWORD"));
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "CANNOT CONNECT TO DATABASE!", ex);
        }
        return null;
    }

    public Connection getConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            conn = prepareConnection();
        }
        return conn;
    }

    public void prepareTables() throws SQLException {
        String createVehicle = "CREATE TABLE IF NOT EXISTS VEHICLE " +
                "(ID integer(255) not null primary key AUTO_INCREMENT," +
                "NUMBER varchar (10)," +
                "LONGITUDE varchar (30)," +
                "LATITUDE varchar (30))";

        String createBusstop = "Create table if not exists Busstop " +
                "(ID integer(255) not null primary key auto_increment," +
                "Street varchar(50)," +
                "stop_id varchar(10)," +
                "stop_nr varchar(10), " +
                "lon float(20)," +
                "lat float(20))";
        getConnection().prepareStatement(createVehicle).executeUpdate();
        getConnection().prepareStatement(createBusstop).executeUpdate();

    }
}

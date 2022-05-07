package pl.dabkowski.edp;


import lombok.Getter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private final String fileName = "config.properties";
    @Getter
    private Properties properties;
    @Getter
    private InputStream inputStream;

    public Config() throws IOException {
        properties = new Properties();
        inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
        properties.load(inputStream);
    }

    public String getProperty(String prop) {
        return properties.getProperty(prop);
    }


}

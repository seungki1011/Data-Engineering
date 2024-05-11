package dbutil;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class MongoDBPropertiesLoader {
    private static final String PROPERTIES_FILE = "database.properties";
    private static Properties properties;

    static {
        properties = new Properties();
        try (InputStream input = MongoDBPropertiesLoader.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            if (input == null) {
                System.out.println("file not found");
            }

            properties.load(input);
        } catch (IOException e) {
            log.error("MongoDBPropertiesLoader error", e);
        }
    }

    public static String getHost() {
        return properties.getProperty("mongodb.host");
    }

    public static  String getPort() {
        return properties.getProperty("mongodb.port");
    }

    public static String getDatabase() {
        return properties.getProperty("mongodb.database");
    }

    public static String getUsername() {
        return properties.getProperty("mongodb.username");
    }

    public static String getPassword() {
        return properties.getProperty("mongodb.password");
    }

}

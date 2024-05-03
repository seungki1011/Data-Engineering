package dbutil;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;

@Slf4j
public class JdbcPropertiesLoader {
    private static final String PROPERTIES_FILE = "database.properties";
    private static Properties properties;

    static {
        properties = new Properties();
        try (InputStream input = JdbcPropertiesLoader.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            if (input == null) {
                System.out.println("file not found");
            }

            properties.load(input);
        } catch (IOException e) {
            log.error("JdbcPropertiesLoader error", e);
        }
    }

    public static String getUrl() {
        return properties.getProperty("jdbc.url");
    }

    public static String getUsername() {
        return properties.getProperty("jdbc.username");
    }

    public static String getPassword() {
        return properties.getProperty("jdbc.password");
    }

}
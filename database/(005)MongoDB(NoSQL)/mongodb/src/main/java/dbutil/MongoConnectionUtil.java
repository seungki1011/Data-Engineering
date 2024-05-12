package dbutil;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MongoConnectionUtil {
    private static final String HOST = MongoDBPropertiesLoader.getHost();
    private static final String PORT = MongoDBPropertiesLoader.getPort();
    private static final String USERNAME = MongoDBPropertiesLoader.getUsername();
    private static final String PASSWORD = MongoDBPropertiesLoader.getPassword();

    public static MongoClient getConnection() {
        String URI = "mongodb://"+USERNAME+":"+PASSWORD+"@" +HOST+":"+PORT;

        try {
            return MongoClients.create(URI);
        } catch (Exception e) {
            log.error("Failed to connect to MongoDB", e);
            throw new RuntimeException("Failed to connect to MongoDB", e);
        }
    }
}

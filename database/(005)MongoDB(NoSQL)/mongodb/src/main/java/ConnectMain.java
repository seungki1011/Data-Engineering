import com.mongodb.client.*;
import com.mongodb.client.model.Sorts;
import dbutil.MongoDBPropertiesLoader;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;

@Slf4j
public class MongoDBMain {
    public static void main(String[] args) {

        String HOST = MongoDBPropertiesLoader.getHost();
        String PORT = MongoDBPropertiesLoader.getPort();
        String DATABASE = MongoDBPropertiesLoader.getDatabase();
        String USERNAME = MongoDBPropertiesLoader.getUsername();
        String PASSWORD = MongoDBPropertiesLoader.getPassword();
        String URI = "mongodb://"+USERNAME+":"+PASSWORD+"@" +HOST+":"+PORT;

        try (MongoClient mongoClient = MongoClients.create(URI)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE);
            MongoCollection<Document> collection = database.getCollection("books");

            Document projection = new Document("_id", 1)
                    .append("title", 1)
                    .append("pageCount", 1);

            Document query = new Document("pageCount", new Document("$gt", 300));

            MongoCursor<Document> cursor = collection.find(query)
                            .projection(projection)
                            .sort(Sorts.descending("pageCount"))
                            .iterator();

            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }

        } catch (Exception e) {
            log.error("Exception", e);
        }
    }
}

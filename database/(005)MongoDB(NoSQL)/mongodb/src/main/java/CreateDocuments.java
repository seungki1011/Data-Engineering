import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dbutil.MongoConnectionUtil;
import domain.Movies;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class CreateDocuments {
    public static void main(String[] args) {

        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(),fromProviders(pojoCodecProvider));

        try(MongoClient mongoClient = MongoConnectionUtil.getConnection()) {
            MongoDatabase database = mongoClient.getDatabase("shop").withCodecRegistry(pojoCodecRegistry);

            MongoCollection<Movies> moviesCollection = database.getCollection("movies", Movies.class);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            List<Movies> movies = new ArrayList<>();
            movies.add(new Movies(null, "The Nexus Protocol", "Sci-Fi", 12000,
                    "Summary comes here!", LocalDateTime.now()));
            movies.add(new Movies(null, "Quantum Dawn", "Sci-Fi", 9000,
                    "Summary comes here!", LocalDateTime.now()));
            movies.add(new Movies(null, "Shadow Protocol", "Sci-Fi", 12000,
                    "Summary comes here!", LocalDateTime.now()));
            movies.add(new Movies(null, "Midnight Echo", "Mystery", 10000,
                    "Summary comes here!", LocalDateTime.now()));
            movies.add(new Movies(null, "Code Breaker", "Thriller", 15000,
                    "Summary comes here!", LocalDateTime.now()));
            movies.add(new Movies(null, "Celestial Odyssey", "Adventure", 28000,
                    "Summary comes here!", LocalDateTime.now()));
            movies.add(new Movies(null, "Echoes of Tomorrow", "Drama", 9000,
                    "Summary comes here!", LocalDateTime.now()));
            movies.add(new Movies(null, "The Last Stand", "Action", 9000,
                    "Summary comes here!", LocalDateTime.now()));
            movies.add(new Movies(null, "Red Horizon", "Adventure", 5000,
                    "Summary comes here!", LocalDateTime.now()));

            moviesCollection.insertMany(movies);

        }
    }
}

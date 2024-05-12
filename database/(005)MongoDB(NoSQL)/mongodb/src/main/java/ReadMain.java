import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import dbutil.MongoConnectionUtil;
import domain.Movies;
import org.bson.Document;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class ReadMain {
    public static void main(String[] args) {
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(),fromProviders(pojoCodecProvider));

        try(MongoClient mongoClient = MongoConnectionUtil.getConnection()) {
            MongoDatabase database = mongoClient.getDatabase("shop").withCodecRegistry(pojoCodecRegistry);

            MongoCollection<Movies> moviesCollection = database.getCollection("movies", Movies.class);

            // 1. 커서를 이용해서 조회
            MongoCursor<Movies> cursor = moviesCollection.find().cursor();
            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }

            // 2. 필터를 통한 조회 조건 설정
            cursor = moviesCollection.find(eq("price", 9000)).cursor();
            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }

            // 3. projection으로 원하는 필드만 가져오기

            // projection이라는 도큐먼트를 생성해서 사용하지 않고 Projections.fields(include()) 사용
            Document projection = new Document("title", 1)
                    .append("genre", 1)
                    .append("price", 1);

            cursor = moviesCollection.find()
                    .projection(Projections.fields(Projections.include("title", "genre", "price")))
                    .sort(Sorts.descending("price"))
                    .limit(5)
                    .cursor();

            while (cursor.hasNext()) {
                Movies doc = cursor.next();

                System.out.println("Title: " + doc.getTitle());
                System.out.println("Genre: " + doc.getGenre());
                System.out.println("Price: " + doc.getPrice());
                System.out.println("-------------------------");

            }
        }
    }
}

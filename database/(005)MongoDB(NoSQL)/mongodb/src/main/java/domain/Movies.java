package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movies {
    @BsonId
    ObjectId _id;
    String title;
    String genre;
    Integer price;
    // @BsonProperty("contents") : 데이터베이스상의 이름과 달라도 매핑 가능
    String description;
    LocalDateTime updatedAt;

    @Override
    public String toString() {
        return "Movies{" +
                "_id=" + _id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", updatedAt=" + updatedAt +
                '}';
    }
}

package dbutil;

import domain.Product;
import lombok.extern.slf4j.Slf4j;

import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
public class ResultSetUtil {

    public static void printResultSet(ResultSet rs) {
        try {
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " "
                        + rs.getDate(3) + " " + rs.getString(4) + " "
                        + rs.getInt(5));
            }
        } catch (SQLException e) {
            log.error("printResultSet() error", e);
        }
    }

    public static Product resultSetMapper(ResultSet rs) throws SQLException {
        return new Product(rs.getInt(1), rs.getString(2),
                rs.getTimestamp(3).toLocalDateTime(), rs.getString(4),
                rs.getInt(5));
    }
}

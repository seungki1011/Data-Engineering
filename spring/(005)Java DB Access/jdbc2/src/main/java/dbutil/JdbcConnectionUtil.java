package dbutil;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;

@Slf4j
public class JdbcConnectionUtil {
    public static String URL;
    public static String USERNAME;
    public static String PASSWORD;

    public static Connection getConnection() {
        Connection connection = null;
        try {
            URL = JdbcPropertiesLoader.getUrl();
            USERNAME = JdbcPropertiesLoader.getUsername();
            PASSWORD = JdbcPropertiesLoader.getPassword();

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return connection;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public static void close(Connection con, Statement stmt, ResultSet rs) {

        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                log.error("ResultSet close error", e);
            }
        }

        if(stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                log.error("Statement close error", e);
            }
        }

        if(con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                log.error("Connection close error", e);
            }
        }
    }
}

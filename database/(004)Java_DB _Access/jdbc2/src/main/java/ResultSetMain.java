import dbutil.JdbcConnectionUtil;
import dbutil.ResultSetUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Slf4j
public class ResultSetMain {
    public static void main(String[] args) {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "select id, name, updated_at, description, price from product";

        try {
            con = JdbcConnectionUtil.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println(ResultSetUtil.resultSetMapper(rs));
            }
        } catch (SQLException e) {
            log.error("DB Error", e);
        } finally {
            JdbcConnectionUtil.close(con, stmt, rs);
        }

    }
}

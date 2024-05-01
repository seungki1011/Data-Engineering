
import dbutil.JdbcConnectionUtil;
import dbutil.ResultSetUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;

@Slf4j
public class ExecuteQueryMain {
    public static void main(String[] args) {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Connection 생성
            con = JdbcConnectionUtil.getConnection();

            // 1. Statement 사용
            stmt = con.createStatement(); // Statement 객체 생성
            // executeQuery() 사용
            rs = stmt.executeQuery("select * from product");

            ResultSetUtil.printResultSet(rs);

        } catch (SQLException e) {
            log.error("DB error", e);
        } finally {
            JdbcConnectionUtil.close(con, stmt, rs);
        }
    }

}

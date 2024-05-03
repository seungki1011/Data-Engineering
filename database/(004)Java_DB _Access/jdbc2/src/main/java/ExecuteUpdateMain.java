import dbutil.JdbcConnectionUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;

@Slf4j
public class ExecuteUpdateMain {
    public static void main(String[] args) {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = JdbcConnectionUtil.getConnection();
            stmt = con.createStatement();

            // executeUpdate() 사용 - 튜플 삽입
            int changedRows = stmt.executeUpdate("insert into product(name, updated_at, description, price)" +
                    "values ('sunglass2', '2024-04-13 14:50:00', 'A sunglass', '80000')");
            System.out.println("변경된 row 수 = " + changedRows);

            // executeUpdate() - 값 업데이트
            changedRows = stmt.executeUpdate("update product set price = price - 5000 where name like 'tshirt%'");
            System.out.println("변경된 row 수 = " + changedRows);

        } catch (SQLException e) {
            log.error("DB error", e);
        } finally {
            JdbcConnectionUtil.close(con, stmt, rs);
        }
    }
}

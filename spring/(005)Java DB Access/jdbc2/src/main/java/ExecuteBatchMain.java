import dbutil.JdbcConnectionUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Slf4j
public class ExecuteBatchMain {
    public static void main(String[] args) {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = JdbcConnectionUtil.getConnection();
            stmt = con.createStatement();

            // addBatch()로 SQL 추가
            stmt.addBatch("update product set price = price + 300000 where name = 'ak47'");
            stmt.addBatch("update product set price = price + 7700 where id = 1");
            stmt.addBatch("update product set price = price + 7700 where id = 2");
            stmt.addBatch("update product set price = price + 4400 where id between 7 and 10");

            // executeBatch()로 batch 단위로 쌓인 SQL 실행
            int[] resultCounts = stmt.executeBatch();

            for (int resultCount : resultCounts) {
                System.out.println("resultCount = " + resultCount);
            }

        } catch (SQLException e) {
            log.error("DB error", e);
        } finally {
            JdbcConnectionUtil.close(con, stmt, rs);
        }
    }
}


import dbutil.JdbcConnectionUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

@Slf4j
public class ConnectMain {
    public static void main(String[] args) {

        Connection con = null;

        // 예외 처리는 JdbcConnectionUtil.getConnection()에서 전부 처리
        con = JdbcConnectionUtil.getConnection();

        try {
            DatabaseMetaData dbmd = con.getMetaData();
            log.info("getDriverName() = {}, getDriverVersion = {}", dbmd.getDriverName(), dbmd.getDriverVersion());
        } catch (SQLException e) {
            log.error("DatabaseMetaData error", e);
        } finally {
            JdbcConnectionUtil.close(con, null, null);
        }
    }
}

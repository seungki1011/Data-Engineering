import dbutil.JdbcConnectionUtil;
import dbutil.ResultSetUtil;
import domain.Product;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;

@Slf4j
public class PreparedStatementMain {
    public static void main(String[] args) {

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "insert into product(name, updated_at, description, price) values(?,?,?,?)";

        try {
            con = JdbcConnectionUtil.getConnection();
            // PreparedStatement 객체 생성
            pstmt = con.prepareStatement(sql);
            // parameter binding
            pstmt.setString(1, "coat1");
            pstmt.setTimestamp(2, Timestamp.valueOf("2024-04-20 14:50:00"));
            pstmt.setString(3, "This is a coat");
            pstmt.setInt(4, 150000);

            pstmt.executeUpdate(); // 지금 튜플 하나 삽입하고 있음
            pstmt.close();

            // PreparedStatement으로 조회해보기
            pstmt = con.prepareStatement("select * from product where name = ?");
            pstmt.setString(1, "coat1");

            rs = pstmt.executeQuery();
            ResultSetUtil.printResultSet(rs);

        } catch (SQLException e) {
            log.error("DB error", e);
        } finally {
            JdbcConnectionUtil.close(con, pstmt, rs);
        }
    }
}

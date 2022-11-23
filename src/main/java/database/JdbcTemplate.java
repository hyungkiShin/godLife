package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static database.ConnectionManager.getConnection;

public class JdbcTemplate {

    public void excuteUpdate(User user, String sql) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
//            String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getName());
            pstmt.setString(4, user.getEmail());

            pstmt.executeUpdate();
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }

            if (con != null) {
                con.close();
            }
        }
    }
}

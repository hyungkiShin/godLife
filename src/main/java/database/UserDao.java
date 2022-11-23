package database;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDao {

    public User findByUserId(String userId) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

        try {
            con = ConnectionManager.getConnection();
            String sql = "SELECT userId, password, name, email FROM USERS WHERE userId = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userId);
            resultSet = pstmt.executeQuery();

            User user = null;
            if (resultSet.next()) {
                user = new User(resultSet.getString("userId"),
                        resultSet.getString("password"),
                        resultSet.getString("name"),
                        resultSet.getString("email")
                );
            }
            return user;
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }

            if (pstmt != null) {
                resultSet.close();
            }

            if (con != null) {
                con.close();
            }
        }
    }
}

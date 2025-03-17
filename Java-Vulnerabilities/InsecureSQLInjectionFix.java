import java.sql.*;

public class InsecureSQLInjectionFix {
    public void getUserData(String userId) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "user", "password");
        Statement stmt = conn.createStatement();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE id = ?");
        stmt.setString(1, userId);
        ResultSet rs = stmt.executeQuery();
    }
}

import java.sql.*;

public class InsecureSQLInjection {
    public void getUserData(String userId) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "user", "password");
        Statement stmt = conn.createStatement();
        String query = "SELECT * FROM users WHERE id = '" + userId + "'"; // ❌ SQL Injection Risk
        ResultSet rs = stmt.executeQuery(query);
    }
}

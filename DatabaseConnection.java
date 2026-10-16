import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection getConnection()
            throws SQLException {

        String url = "jdbc:mysql://localhost:3306/student_db";
        String user = "root";
        String password = System.getenv("DB_PASSWORD");

        if (password == null || password.isBlank()) {
            throw new SQLException(
                "DB_PASSWORD environment variable is not set."
            );
        }

        return DriverManager.getConnection(url, user, password);
    }
}
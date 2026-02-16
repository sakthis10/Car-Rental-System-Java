import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/car_rental",
                "root",
                "8080"
            );
            return conn;
        } catch (Exception e) {
            System.out.println("Database connection failed");
            return null;
        }
    }
}

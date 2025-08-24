import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class DBConnection {
    public static final String URL = "jdbc:mysql://localhost:3306/usermanagement";
    public static final String USER = "root";
    public static final String Password = "123456";
    public static Connection getConnection() throws SQLException{
        System.out.println("DB Connection Successfully");
        return DriverManager.getConnection(URL, USER, Password);
    }

}

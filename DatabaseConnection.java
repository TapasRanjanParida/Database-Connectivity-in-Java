import java.sql.Connection;
import java.sql.DriverManager;

class DatabaseConnection{
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/";
        String userName = "root";
        String password = "Tapas@123";
        
        try {
            Connection connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Connection Successfully");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
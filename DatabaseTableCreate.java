import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseTableCreate {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/tapas";
        String userName = "root";
        String password = "Tapas@123";

        try {
            Connection connection = DriverManager.getConnection(url, userName, password);
            String query = "create table employee (empid int(5), empname varchar(100), empsalary int(5))";
            Statement statement = connection.createStatement();
            statement.execute(query);
            System.out.println("Table Create Successfully");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

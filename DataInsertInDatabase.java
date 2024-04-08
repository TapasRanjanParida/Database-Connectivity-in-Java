import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DataInsertInDatabase {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/tapas";
        String userName = "root";
        String password = "Tapas@123";

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee ID : ");
        int id = sc.nextInt();
        System.out.println("Enter Employee Name : ");
        String name = sc.next();
        System.out.println("Enter Employee Salary : ");
        int salary = sc.nextInt();
        sc.close();

        try {
            Connection connection = DriverManager.getConnection(url, userName, password);
            String query = "insert into employee (empid, empname, empsalary) values (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, salary);
            preparedStatement.executeUpdate();
            connection.close();
            System.out.println("Data Insert Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

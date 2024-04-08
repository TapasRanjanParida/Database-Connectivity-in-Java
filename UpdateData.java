import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateData {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Employee ID : ");
        int id = scanner.nextInt();
        System.out.println("Update Employee Name : ");
        String name = scanner.next();
        System.out.println("Update Employee Salary : ");
        int salary = scanner.nextInt();
        scanner.close();

        String url = "jdbc:mysql://localhost:3306/tapas";
        String userName = "root";
        String password = "Tapas@123";
        try {
            Connection connection = DriverManager.getConnection(url, userName, password);
            String query = "update employee set empname=?, empsalary=? where empid=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, salary);
            preparedStatement.setInt(3, id);

            int row = preparedStatement.executeUpdate();
            if(row>0){
                System.out.println("Update Successfully");
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

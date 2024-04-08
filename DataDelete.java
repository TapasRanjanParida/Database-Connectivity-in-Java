import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DataDelete {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Delete Employee ID : ");
        int id = scanner.nextInt();
        scanner.close();

        String url = "jdbc:mysql://localhost:3306/tapas";
        String userName = "root";
        String password = "Tapas@123";

        try {
            Connection connection = DriverManager.getConnection(url, userName, password);
            String query = "delete from employee where empid = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            int row = preparedStatement.executeUpdate();
            if(row>0){
                System.out.println("Delete Successfully");
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

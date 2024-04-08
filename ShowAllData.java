import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ShowAllData {
    public static void main(String[] args) {
        
        String url = "jdbc:mysql://localhost:3306/tapas";
        String userName = "root";
        String password = "Tapas@123";

        try {
            Connection connection = DriverManager.getConnection(url, userName, password);
            String query = "select * from employee";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while(rs.next()){

                int id = rs.getInt("empid");
                String name = rs.getString("empname");
                int salary = rs.getInt("empsalary");

                System.out.println("Employee ID : "+id);
                System.out.println("Employee Name : "+name);
                System.out.println("Employee Salary : "+salary);
                System.out.println("**************************");
            }

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

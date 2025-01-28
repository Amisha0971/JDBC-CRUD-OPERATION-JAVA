package Create;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcCreate {

	public static void main(String[] args) {
		    String url = "jdbc:mysql://localhost:3306/testdb";
	        String user = "root";
	        String password = "abc123";

	        try (Connection connection = DriverManager.getConnection(url, user, password)) {
	            String insertQuery = "INSERT INTO users (name, email, age) VALUES (?, ?, ?)";
	            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

	            preparedStatement.setString(1, "priya sharma");
	            preparedStatement.setString(2, "priya@example.com");
	            preparedStatement.setInt(3, 22);
	            
	           int rowsInserted = preparedStatement.executeUpdate();
	            System.out.println(rowsInserted + " row(s) inserted.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}
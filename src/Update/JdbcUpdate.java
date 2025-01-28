package Update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcUpdate {

	public static void main(String[] args) {
		    String url = "jdbc:mysql://localhost:3306/testdb";
	        String user = "root";
	        String password = "abc123";

	        try (Connection connection = DriverManager.getConnection(url, user, password)) {
	            String updateQuery = "UPDATE users SET email = ? WHERE id = ?";
	            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);

	            preparedStatement.setString(1, "john.doe@example.com");
	            preparedStatement.setInt(2, 1);

	            int rowsUpdated = preparedStatement.executeUpdate();
	            System.out.println(rowsUpdated + " row(s) updated.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }


	}



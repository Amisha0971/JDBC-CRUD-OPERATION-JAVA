package Delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcDelete {

	public static void main(String[] args) {
		    String url = "jdbc:mysql://localhost:3306/testdb";
	        String user = "root";
	        String password = "abc123";

	        try (Connection connection = DriverManager.getConnection(url, user, password)) {
	        	 String deleteQuery = "DELETE FROM users WHERE id = ?";
	             PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);

	             preparedStatement.setInt(1, 3);

	             int rowsDeleted = preparedStatement.executeUpdate();
	             System.out.println(rowsDeleted + " row(s) deleted.");
	         } catch (SQLException e) {
	             e.printStackTrace();
	         }
	     }
	}



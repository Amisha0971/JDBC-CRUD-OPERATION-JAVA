package Read;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcRead {

	public static void main(String[] args) {
	    String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "abc123";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String selectQuery = "SELECT * FROM users ";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectQuery);

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Email: " + resultSet.getString("email"));
                System.out.println("Age: " + resultSet.getInt("age"));
                System.out.println("-----");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




	}



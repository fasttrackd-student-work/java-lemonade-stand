package lemonadestand.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lemonadestand.entity.LemonadeStand;

public class LemonadeStandDAO {
	
	public LemonadeStandDAO() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Unable to find PostgreSQL Driver. Please ensure it is imported with Maven.");
		}
	}

	private Connection getDBConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "bondstone");
	}

	public LemonadeStand getLemonadeStand(int id) {
		LemonadeStand lemonadeStand = null;
		try (PreparedStatement preparedStatement = getDBConnection().prepareStatement(
				"SELECT * FROM lemonade_stand WHERE id=?");) {
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				lemonadeStand = new LemonadeStand(resultSet.getInt("id"), resultSet.getString("name"));

			}
		} catch (SQLException e) {
			System.out.println("Order with id " + id + " does not exist");
		}
		return lemonadeStand;
	}

}

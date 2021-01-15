package lemonadestand.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import lemonadestand.entity.Lemonade;
import lemonadestand.entity.Order;

public class LemonadeDAO implements BaseDAO<Lemonade> {

	public LemonadeDAO() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Unable to find PostgreSQL Driver. Please ensure it is imported with Maven.");
		}
	}

	@Override
	public PreparedStatement prepareCreateStatement(Lemonade lemonade) throws SQLException {
		PreparedStatement createLemonadeStatement = getDBConnection().prepareStatement(
				"INSERT INTO lemonade (\"lemonJuice\", water, \"iceCubes\", sugar, price, order_id) VALUES (?, ?, ?, ?, ?, ?)",
				Statement.RETURN_GENERATED_KEYS);
		createLemonadeStatement.setDouble(1, lemonade.getLemonJuice());
		createLemonadeStatement.setDouble(2, lemonade.getWater());
		createLemonadeStatement.setInt(3, lemonade.getIceCubes());
		createLemonadeStatement.setDouble(4, lemonade.getSugar());
		createLemonadeStatement.setDouble(5, lemonade.getPrice());
		createLemonadeStatement.setInt(6, lemonade.getOrder().getId());
		return createLemonadeStatement;
	}

	@Override
	public Lemonade constructObject(Integer id, Lemonade lemonade) {
		return new Lemonade(id, lemonade.getLemonJuice(), lemonade.getPrice(), lemonade.getSugar(),
				lemonade.getIceCubes(), lemonade.getWater(), lemonade.getOrder());
	}

	@Override
	public PreparedStatement prepareReadStatement(int id) throws SQLException {
		PreparedStatement getLemonadeById = getDBConnection().prepareStatement("SELECT L.id as \"lemonade_id\", L.\"lemonJuice\", L.water, L.sugar, L.price, L.\"iceCubes\", OT.id as \"order_id\", OT.total FROM lemonade as L JOIN order_table as OT ON L.order_id = OT.id WHERE id=?");
		getLemonadeById.setInt(1, id);
		return getLemonadeById;
	}

	@Override
	public Lemonade constructObject(ResultSet resultSet) throws SQLException {
		return new Lemonade(resultSet.getInt("lemoande_id"), resultSet.getDouble("lemonJuice"), resultSet.getDouble("price"), resultSet.getDouble("sugar"), resultSet.getInt("iceCubes"), resultSet.getDouble("water"), new Order(resultSet.getInt("order_id"), resultSet.getDouble("total")));
	}

}

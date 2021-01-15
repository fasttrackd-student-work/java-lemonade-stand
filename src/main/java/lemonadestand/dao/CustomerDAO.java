package lemonadestand.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import lemonadestand.entity.Customer;

public class CustomerDAO implements BaseDAO<Customer> {

	public CustomerDAO() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Unable to find PostgreSQL Driver. Please ensure it is imported with Maven.");
		}
	}

	@Override
	public PreparedStatement prepareCreateStatement(Customer customer) throws SQLException {
		PreparedStatement createCustomerStatement = getDBConnection().prepareStatement(
				"INSERT INTO customer (name, \"phoneNumber\") VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
		createCustomerStatement.setString(1, customer.getName());
		createCustomerStatement.setString(2, customer.getPhoneNumber());
		return createCustomerStatement;
	}

	@Override
	public Customer constructObject(Integer id, Customer customer) {
		return new Customer(id, customer.getName(), customer.getPhoneNumber());
	}

	@Override
	public PreparedStatement prepareReadStatement(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer constructObject(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}

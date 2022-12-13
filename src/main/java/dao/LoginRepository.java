package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.SingletonConnectionDB;
import model.User;

public class LoginRepository {

	private Connection connection;
	
	public LoginRepository() {
		this.connection = SingletonConnectionDB.getConnection();
	}
	
	public boolean validarLogin(User login) throws SQLException {
		String sql = "SELECT * FROM tb_user where lower(login) = lower(?) and lower(password) = lower(?);";
		try(PreparedStatement preparedStatement = this.connection.prepareStatement(sql)){
			ResultSet resultSet;
			preparedStatement.setString(1, login.getLogin());
			preparedStatement.setString(2, login.getPassword());			
			resultSet = preparedStatement.executeQuery();			
			return resultSet.next();
		}
	}
}

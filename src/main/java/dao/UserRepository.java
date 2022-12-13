package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import connection.SingletonConnectionDB;
import model.User;

public class UserRepository implements RepositoryCrud<User> {
	private Connection connection;
	
	public UserRepository() {
		this.connection = SingletonConnectionDB.getConnection();
	}

	@Override
	public Optional<User> save(User object) throws SQLException {
		if(object.isNovo()) {
			String sql = "INSERT INTO tsspersonalfinance.tb_user (login, email, password) VALUES (?,?,?);";	
			

			try(PreparedStatement prepareStatement = this.connection.prepareStatement(sql)){
				prepareStatement.setString(1, object.getLogin());
				prepareStatement.setString(2, object.getEmail());
				prepareStatement.setString(3, object.getPassword());
				prepareStatement.executeUpdate();	
				this.connection.commit();
			}
			
			return Optional.ofNullable(object);
			
		}else {
			//Alteracao
		}
		return null;
	}

	@Override
	public Optional<User> findByOne(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
}

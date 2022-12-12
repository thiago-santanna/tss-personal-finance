package service;

import java.sql.SQLException;
import java.util.Optional;

import dao.UserRepository;
import model.User;

public class UserService {
	private UserRepository signupRepository;
	
	public UserService(UserRepository signupRepository) {
		this.signupRepository = signupRepository;
	}
	
	public Optional<User> saveUser(User user) throws SQLException {
		
		if (user == null) {
			throw new IllegalArgumentException("Dados não foram informados.");
		}		
		if(user.getLogin() == null && user.getLogin().isEmpty()) {
			throw new IllegalArgumentException("Login não foi informado.");
		}		
		if(user.getEmail() == null && user.getEmail().isEmpty()) {
			throw new IllegalArgumentException("E-mail não foi informado.");
		}		
		if(user.getPassword() == null && user.getPassword().isEmpty()) {
			throw new IllegalArgumentException("Senha não foi informada.");
		}
		
		return signupRepository.save(user);
	}
}

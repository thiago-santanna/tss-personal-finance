package model;

public class User {
	private Long id;
	private Long idUserOwner;
	private String login;
	private String email;
	private String password;
	private boolean status;
	
	public static User getLoginDataLogin(String login, String password) {
		User modelLogin = new User();
		modelLogin.setLogin(login);
		modelLogin.setPassword(password);
		return modelLogin;
	}
	
	public User() {
	}

	public User(Long id, Long idUserOwner, String login, String email, String password,
			boolean status) {
		
		this.id = id;
		this.idUserOwner = idUserOwner;
		this.login = login;
		this.email = email;
		this.password = password;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public Long getIdUserOwner() {
		return idUserOwner;
	}

	public String getLogin() {
		return login;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public boolean isStatus() {
		return status;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setIdUserOwner(Long idUserOwner) {
		this.idUserOwner = idUserOwner;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}	
	
}

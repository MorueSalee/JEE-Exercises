package fr.eni.ecole.bo;

public class User {
	private Integer idUser;
	private String name;
	private String firstName;
	private String login;
	private String password;

	public User(Integer idUser, String name, String firstName, String login, String password) {
		super();
		this.idUser = idUser;
		this.name = name;
		this.firstName = firstName;
		this.login = login;
		this.password = password;
	}

	public User(String name, String firstName, String login, String password) {
		super();
		this.name = name;
		this.firstName = firstName;
		this.login = login;
		this.password = password;
	}

	public User(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public User() {
		super();
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

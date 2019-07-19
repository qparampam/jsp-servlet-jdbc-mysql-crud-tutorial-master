package crud.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
    private String name;

	@Column(name = "login")
    private String login;

	@Column(name = "password")
    private String password;

	@Column(name = "role")
	private String role;
	
	public User() {
	}
	
	public User(String name, String login, String password) {
		super();
		this.name = name;
		this.login = login;
		this.password = password;
	}

	public User(int id, String name, String login, String password) {
		super();
		this.id = id;
		this.name = name;
		this.login = login;
		this.password = password;
	}

	public User(String name, String login, String password, String role) {
		super();
		this.name = name;
		this.login = login;
		this.password = password;
		this.role = role;
	}

	public User(int id, String name, String login, String password, String role) {
		super();
		this.id = id;
		this.name = name;
		this.login = login;
		this.password = password;
		this.role = role;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}


}

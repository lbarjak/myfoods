package foods;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", fullName=" + fullName
				+ ", activation=" + activation + ", enabled=" + enabled + "]";
	}
	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true, nullable = false)
	private String email;

	@Column(nullable = false)
	private String password;
	private String fullName;
	private Boolean activation;
	private Boolean enabled;

	//@OneToMany(mappedBy = "user")
	//private List<Story> stories;

	//@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//@JoinTable(name = "users_roles", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "roles_id") })
	//private Set<Role> roles = new HashSet<Role>();

}

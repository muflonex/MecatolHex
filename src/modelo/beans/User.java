package modelo.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="usuario")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private int userId;

	private String email;

	@Column(name="is_admin")
	private byte isAdmin;

	@Column(name="nombre")
	private String name;

	private String password;

	//bi-directional many-to-one association to Copy
	@OneToMany(mappedBy="user")
	private List<Copy> copies;

	//bi-directional many-to-one association to Loan
	@OneToMany(mappedBy="user")
	private List<Loan> loans;

	//bi-directional one-to-one association to Address
	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="id_direccion")
	private Address address;

	public User() {
	}

	public User(String email, String name, String password) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
	}

	public User(String email, byte isAdmin, String name, String password) {
		super();
		this.email = email;
		this.isAdmin = isAdmin;
		this.name = name;
		this.password = password;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setIdUsuario(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte getIsAdmin() {
		return this.isAdmin;
	}

	public void setIsAdmin(byte isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Copy> getCopies() {
		return this.copies;
	}

	public void setCopies(List<Copy> copies) {
		this.copies = copies;
	}

	public Copy addCopy(Copy copy) {
		getCopies().add(copy);
		copy.setUser(this);

		return copy;
	}

	public Copy removeCopy(Copy copy) {
		getCopies().remove(copy);
		copy.setUser(null);

		return copy;
	}

	public List<Loan> getLoans() {
		return this.loans;
	}

	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}

	public Loan addLoan(Loan loan) {
		getLoans().add(loan);
		loan.setUser(this);

		return loan;
	}

	public Loan removeLoan(Loan loan) {
		getLoans().remove(loan);
		loan.setUser(null);

		return loan;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", isAdmin=" + isAdmin + ", name=" + name
				+ ", password=" + password + ", copies=" + copies + ", loans=" + loans + ", address=" + address + "]";
	}

}
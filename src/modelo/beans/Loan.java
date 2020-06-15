package modelo.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the prestamo database table.
 * 
 */
@Entity
@Table(name="prestamo")
@NamedQuery(name="Loan.findAll", query="SELECT l FROM Loan l")
public class Loan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_prestamo")
	private int loanId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_fin")
	private Date endDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_inicio")
	private Date startDate;

	//bi-directional many-to-one association to Copy
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="copia_id_copia")
	private Copy copy;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="usuario_id_usuario")
	private User user;

	public Loan() {
	}

	public Loan( Date startDate, Copy copy, User user) {
		super();
		this.startDate = startDate;
		this.copy = copy;
		this.user = user;
	}

	public Loan(int loanId, Date startDate, Date endDate, Copy copy, User user) {
		super();
		this.loanId = loanId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.copy = copy;
		this.user = user;
	}
	
	public void takeAgain() {
		this.setStartDate(new Date());
		this.setEndDate(null);
	}
	
	public void giveBack() {
		this.setEndDate(new Date());
	}
	
	public int getLoanId() {
		return this.loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Copy getCopy() {
		return this.copy;
	}

	public void setCopy(Copy copy) {
		this.copy = copy;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + loanId;
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
		Loan other = (Loan) obj;
		if (loanId != other.loanId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", startDate=" + startDate + ", endDate=" + endDate + ", copy=" + copy
				+ ", user=" + user + "]";
	}

}
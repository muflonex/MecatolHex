package modelo.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the copia database table.
 * 
 */
@Entity
@Table(name="copia")
@NamedQuery(name="Copy.findAll", query="SELECT c FROM Copy c")
public class Copy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_copia")
	private int copyId;

	//bi-directional many-to-one association to Shelf
	@ManyToOne
	@JoinColumn(name="estante_id_estante")
	private Shelf shelf;

	//bi-directional many-to-one association to Bookshelf
	@ManyToOne
	@JoinColumn(name="estanteria_id_estanteria")
	private Bookshelf bookshelf;

	//bi-directional many-to-one association to Game
	@ManyToOne
	@JoinColumn(name="juego_id_juego")
	private Game game;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="usuario_id_usuario")
	private User user;

	//bi-directional many-to-one association to Loan
	@OneToMany(mappedBy="copy")
	private List<Loan> loans;

	public Copy() {
	}

	public int getCopyId() {
		return this.copyId;
	}

	public void setCopyId(int copyId) {
		this.copyId = copyId;
	}

	public Shelf getShelf() {
		return this.shelf;
	}

	public void setShelf(Shelf shelf) {
		this.shelf = shelf;
	}

	public Bookshelf getBookshelf() {
		return this.bookshelf;
	}

	public void setBookshelf(Bookshelf bookshelf) {
		this.bookshelf = bookshelf;
	}

	public Game getGame() {
		return this.game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Loan> getLoans() {
		return this.loans;
	}

	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}

	public Loan addLoan(Loan loan) {
		getLoans().add(loan);
		loan.setCopy(this);

		return loan;
	}

	public Loan removeLoan(Loan loan) {
		getLoans().remove(loan);
		loan.setCopy(null);

		return loan;
	}

}
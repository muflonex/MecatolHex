package modelo.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estante database table.
 * 
 */
@Entity
@Table(name="estante")
@NamedQuery(name="Shelf.findAll", query="SELECT s FROM Shelf s")
public class Shelf implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_estante")
	private int shelfId;

	@Column(name="numero")
	private int number;

	//bi-directional many-to-one association to Copy
	@OneToMany(mappedBy="shelf", cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<Copy> copies;

	//bi-directional many-to-one association to Bookshelf
	@ManyToOne
	@JoinColumn(name="estanteria_id_estanteria")
	private Bookshelf bookshelf;

	public Shelf() {
	}

	public Shelf(int shelfId, int number, Bookshelf bookshelf) {
		super();
		this.shelfId = shelfId;
		this.number = number;
		this.bookshelf = bookshelf;
	}

	public int getShelfId() {
		return this.shelfId;
	}

	public void setShelfId(int shelfId) {
		this.shelfId = shelfId;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public List<Copy> getCopies() {
		return this.copies;
	}

	public void setCopies(List<Copy> copies) {
		this.copies = copies;
	}

	public Copy addCopy(Copy copy) {
		getCopies().add(copy);
		copy.setShelf(this);

		return copy;
	}

	public Copy removeCopy(Copy copy) {
		getCopies().remove(copy);
		copy.setShelf(null);

		return copy;
	}

	public Bookshelf getBookshelf() {
		return this.bookshelf;
	}

	public void setBookshelf(Bookshelf bookshelf) {
		this.bookshelf = bookshelf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + shelfId;
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
		Shelf other = (Shelf) obj;
		if (shelfId != other.shelfId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Shelf [shelfId=" + shelfId + ", number=" + number + ", copies=" + copies + ", bookshelf=" + bookshelf
				+ "]";
	}

}
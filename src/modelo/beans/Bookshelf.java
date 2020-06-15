package modelo.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estanteria database table.
 * 
 */
@Entity
@Table(name="estanteria")
@NamedQuery(name="Bookshelf.findAll", query="SELECT b FROM Bookshelf b")
public class Bookshelf implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_estanteria")
	private int bookshelfId;

	//bi-directional many-to-one association to Copy
	@OneToMany(mappedBy="bookshelf")
	private List<Copy> copies;

	//bi-directional many-to-one association to Shelf
	@OneToMany(mappedBy="bookshelf")
	private List<Shelf> shelves;

	public Bookshelf() {
	}

	public Bookshelf(int bookshelfId, List<Shelf> shelves) {
		super();
		this.bookshelfId = bookshelfId;
		this.shelves = shelves;
	}

	public int getBookshelfId() {
		return this.bookshelfId;
	}

	public void setBookshelfId(int bookshelfId) {
		this.bookshelfId = bookshelfId;
	}

	public List<Copy> getCopies() {
		return this.copies;
	}

	public void setCopies(List<Copy> copies) {
		this.copies = copies;
	}

	public Copy addCopy(Copy copy) {
		getCopies().add(copy);
		copy.setBookshelf(this);

		return copy;
	}

	public Copy removeCopy(Copy copy) {
		getCopies().remove(copy);
		copy.setBookshelf(null);

		return copy;
	}

	public List<Shelf> getShelves() {
		return this.shelves;
	}

	public void setShelves(List<Shelf> shelves) {
		this.shelves = shelves;
	}

	public Shelf addShelve(Shelf shelve) {
		getShelves().add(shelve);
		shelve.setBookshelf(this);

		return shelve;
	}

	public Shelf removeShelve(Shelf shelve) {
		getShelves().remove(shelve);
		shelve.setBookshelf(null);

		return shelve;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookshelfId;
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
		Bookshelf other = (Bookshelf) obj;
		if (bookshelfId != other.bookshelfId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bookshelf [bookshelfId=" + bookshelfId + ", copies=" + copies + ", shelves=" + shelves + "]";
	}

}
package modelo.daos;

import java.util.List;

import modelo.beans.Shelf;

public interface ShelfDao {
	public int insert(Shelf shelf);
    public Shelf findById(int shelfId);
    public List<Shelf> findAll();
    public int update(Shelf shelf);
    public int delete(Shelf shelf);
}

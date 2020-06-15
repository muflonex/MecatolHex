package modelo.daos;

import java.util.List;

import modelo.beans.Bookshelf;

public interface BookshelfDao {
	public int insert(Bookshelf bookshelf);
    public Bookshelf findById(int bookshelfId);
    public List<Bookshelf> findAll();
    public int update(Bookshelf bookshelf);
    public int delete(Bookshelf bookshelf);
}

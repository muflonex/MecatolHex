package modelo.daos;

import java.util.List;

import modelo.beans.Copy;

public interface CopyDao {
	public int insert(Copy copy);
    public Copy findById(int copyId);
    public List<Copy> findAll();
    public List<Copy> findAllInUser(int userId);
    public List<Copy> findInUserByGameTitle(int userId, String query);
    public int update(Copy copy);
    public int delete(Copy copy);
}

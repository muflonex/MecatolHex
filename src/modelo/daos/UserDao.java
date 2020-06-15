package modelo.daos;

import java.util.List;

import modelo.beans.User;

public interface UserDao {
	public int insert(User user);
    public User findById(int idUsuario);
    public List<User> findAll();
    public int update(User user);
    public int delete(User user);
    public User findByNameOrEmail(String queryTerm);
    public User findByEmail(String email);
    public User findByName(String name);
}

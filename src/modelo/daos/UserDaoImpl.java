package modelo.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.beans.User;

public class UserDaoImpl implements UserDao {

	EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction tx;
    String sql;
    Query query;
    
    
	public UserDaoImpl() {
		emf = Persistence.createEntityManagerFactory("MecatolHex");
        em = emf.createEntityManager();
        tx = em.getTransaction();
	}

	@Override
	public int insert(User user) {
	    int rows = 0;
        tx.begin();
        try {
            em.persist(user);
            tx.commit();
            return 1;
        } catch(Exception exception) {
        	exception.printStackTrace();
            return 0;
        }
	}

	@Override
	public User findById(int userId) {
		 return em.find(User.class, userId);
	}

	@Override
	public List<User> findAll() {
		sql = "select c from User c";
	    query = em.createQuery(sql);
	    return query.getResultList();
	}

	@Override
	public int update(User user) {
		tx.begin();
		try {
			em.merge(user);
			tx.commit();
			return 1;
		} catch(Exception exception) {
			exception.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delete(User User) {
		tx.begin();
        try {
            em.remove(User);
            return 1;
        } catch(Exception e) {
            return 0;
        }
	}

	@Override
	public User findByNameOrEmail(String queryTerm) {

        sql = "SELECT u FROM User u WHERE u.email = :queryTerm OR u.name = :queryTerm";
        query = em.createQuery(sql);
        query.setParameter("queryTerm", queryTerm);
        
        List<User> results = query.getResultList();
        User user = null;
        if(!results.isEmpty())
        	user = (User) results.get(0);
	       
	    return user;
	}

	@Override
	public User findByName(String name) {
		sql = "SELECT u FROM User u WHERE u.name = :name";
        query = em.createQuery(sql);
        query.setParameter("name", name);
        
        List<User> results = query.getResultList();
        User user = null;
        if(!results.isEmpty())
        	user = (User) results.get(0);
	       
	    return user;
	}
	
	@Override
	public User findByEmail(String email) {
		sql = "SELECT u FROM User u WHERE u.email = :email";
        query = em.createQuery(sql);
        query.setParameter("email", email);
        
        List<User> results = query.getResultList();
        User user = null;
        if(!results.isEmpty())
        	user = (User) results.get(0);
	       
	    return user;
	}
	
}

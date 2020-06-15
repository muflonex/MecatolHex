package modelo.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.beans.Copy;

public class CopyDaoImpl implements CopyDao {

	EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction tx;
    String jpql;
    Query query;
    
    
	public CopyDaoImpl() {
		emf = Persistence.createEntityManagerFactory("MecatolHex");
        em = emf.createEntityManager();
        tx = em.getTransaction();
	}

	@Override
	public int insert(Copy copy) {
	    int rows = 0;
        tx.begin();
        try {
            em.persist(copy);
            tx.commit();
            return 1;
        } catch(Exception exception) {
        	exception.printStackTrace();
            return 0;
        }
	}

	@Override
	public Copy findById(int copyId) {
		 return em.find(Copy.class, copyId);
	}
	@Override
	public List<Copy> findAll() {
		jpql = "select c from Copy c";
	    query = em.createQuery(jpql);
	    return query.getResultList();
	}
	
	@Override
	public List<Copy> findInUserByGameTitle(int userId, String gameTitle){
		jpql = "SELECT c from Copy c "
				+ "WHERE c.user.userId = :userId "
				+ "AND c.game.name LIKE UPPER(:gameTitle)";
        query = em.createQuery(jpql);
        query.setParameter("userId", userId);
        query.setParameter("gameTitle", "%" + gameTitle + "%");
        return query.getResultList();
	}
	
	@Override
	public List<Copy> findAllInUser(int userId) {
		jpql = "select c from Copy c WHERE c.user.userId = :userId";
	    query = em.createQuery(jpql);
	    query.setParameter("userId", userId);
	    return query.getResultList();
	}

	@Override
	public int update(Copy copy) {
		tx.begin();
        try {
            em.merge(copy);
            tx.commit();
            return 1;
        } catch(Exception exception) {
        	exception.printStackTrace();
            return 0;
        }
	}

	@Override
	public int delete(Copy copy) {
		tx.begin();
        try {
            em.remove(copy);
            return 1;
        } catch(Exception e) {
            return 0;
        }
	}

}

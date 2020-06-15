package modelo.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.beans.Shelf;

public class ShelfDaoImpl implements ShelfDao {

	EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction tx;
    String sql;
    Query query;
    
    public ShelfDaoImpl() {
		emf = Persistence.createEntityManagerFactory("MecatolHex");
        em = emf.createEntityManager();
        tx = em.getTransaction();
	}

	@Override
	public int insert(Shelf shelf) {
	    int rows = 0;
        tx.begin();
        try {
            em.persist(shelf);
            tx.commit();
            return 1;
        } catch(Exception exception) {
        	exception.printStackTrace();
            return 0;
        }
	}

	@Override
	public Shelf findById(int shelfId) {
		 return em.find(Shelf.class, shelfId);
	}

	@Override
	public List<Shelf> findAll() {
		sql = "select c from Shelf c";
	    query = em.createQuery(sql);
	    return query.getResultList();
	}

	@Override
	public int update(Shelf shelf) {
		tx.begin();
        try {
            em.merge(shelf);
            tx.commit();
            return 1;
        } catch(Exception exception) {
        	exception.printStackTrace();
            return 0;
        }
	}

	@Override
	public int delete(Shelf shelf) {
		tx.begin();
        try {
            em.remove(shelf);
            return 1;
        } catch(Exception e) {
            return 0;
        }
	}

}

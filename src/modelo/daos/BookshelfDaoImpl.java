package modelo.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.beans.Bookshelf;

public class BookshelfDaoImpl implements BookshelfDao {

	EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction tx;
    String sql;
    Query query;
    
    public BookshelfDaoImpl() {
		emf = Persistence.createEntityManagerFactory("MecatolHex");
        em = emf.createEntityManager();
        tx = em.getTransaction();
	}

	@Override
	public int insert(Bookshelf bookshelf) {
	    int rows = 0;
        tx.begin();
        try {
            em.persist(bookshelf);
            tx.commit();
            return 1;
        } catch(Exception exception) {
        	exception.printStackTrace();
            return 0;
        }
	}

	@Override
	public Bookshelf findById(int bookshelfId) {
		 return em.find(Bookshelf.class, bookshelfId);
	}

	@Override
	public List<Bookshelf> findAll() {
		sql = "select c from Bookshelf c";
	    query = em.createQuery(sql);
	    return query.getResultList();
	}

	@Override
	public int update(Bookshelf bookshelf) {
		tx.begin();
        try {
            em.merge(bookshelf);
            tx.commit();
            return 1;
        } catch(Exception exception) {
        	exception.printStackTrace();
            return 0;
        }
	}

	@Override
	public int delete(Bookshelf bookshelf) {
		tx.begin();
        try {
            em.remove(bookshelf);
            return 1;
        } catch(Exception e) {
            return 0;
        }
	}

}

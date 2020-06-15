package modelo.daos;

import modelo.beans.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.Persistence;

import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
	EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction tx;
    String sql;
    Query query;

    public CategoryDaoImpl() {
        emf = Persistence.createEntityManagerFactory("MecatolHex");
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }

    @Override
    public int insert(Category category) {
        int rows = 0;
        tx.begin();
        try {
            em.persist(category);
            tx.commit();
            return 1;
        } catch(Exception exception) {
        	exception.printStackTrace();
            return 0;
        }
    }

    @Override
    public Category findById(int categoryId) {
        return em.find(Category.class, categoryId);
    }

    @Override
    public List<Category> findAll() {
        sql = "select c from Category c";
        query = em.createQuery(sql);
        return query.getResultList();
    }

    @Override
    public int update(Category category) {
        tx.begin();
        try {
            em.merge(category);
            tx.commit();
            return 1;
        } catch(Exception exception) {
        	exception.printStackTrace();
            return 0;
        }
	}

    @Override
    public int delete(Category category) {
        tx.begin();
        try {
            em.remove(category);
            return 1;
        } catch(Exception e) {
            return 0;
        }
    }

}

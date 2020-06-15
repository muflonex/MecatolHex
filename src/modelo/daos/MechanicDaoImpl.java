package modelo.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.beans.Mechanic;

public class MechanicDaoImpl implements MechanicDao {

	EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction tx;
    String sql;
    Query query;
    
    
	public MechanicDaoImpl() {
		emf = Persistence.createEntityManagerFactory("MecatolHex");
        em = emf.createEntityManager();
        tx = em.getTransaction();
	}

	@Override
	public int insert(Mechanic mechanic) {
	    int rows = 0;
        tx.begin();
        try {
            em.persist(mechanic);
            tx.commit();
            return 1;
        } catch(Exception exception) {
        	exception.printStackTrace();
            return 0;
        }
	}

	@Override
	public Mechanic findById(int mechanicId) {
		 return em.find(Mechanic.class, mechanicId);
	}

	@Override
	public List<Mechanic> findAll() {
		sql = "select c from Mechanic c";
	    query = em.createQuery(sql);
	    return query.getResultList();
	}

	@Override
	public int update(Mechanic mechanic) {
		tx.begin();
        try {
            em.merge(mechanic);
            tx.commit();
            return 1;
        } catch(Exception exception) {
        	exception.printStackTrace();
            return 0;
        }
	}

	@Override
	public int delete(Mechanic mechanic) {
		tx.begin();
        try {
            em.remove(mechanic);
            return 1;
        } catch(Exception e) {
            return 0;
        }
	}
}

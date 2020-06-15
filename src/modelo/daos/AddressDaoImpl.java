package modelo.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.beans.Address;

public class AddressDaoImpl implements AddressDao {

	EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction tx;
    String sql;
    Query query;
    
    public AddressDaoImpl() {
		emf = Persistence.createEntityManagerFactory("MecatolHex");
        em = emf.createEntityManager();
        tx = em.getTransaction();
	}

	@Override
	public int insert(Address address) {
	    int rows = 0;
        tx.begin();
        try {
            em.persist(address);
            tx.commit();
            return 1;
        } catch(Exception exception) {
        	exception.printStackTrace();
            return 0;
        }
	}

	@Override
	public Address findById(int userId) {
		 return em.find(Address.class, userId);
	}

	@Override
	public List<Address> findAll() {
		sql = "select c from Address c";
	    query = em.createQuery(sql);
	    return query.getResultList();
	}

	@Override
	public int update(Address address) {
		tx.begin();
        try {
            em.merge(address);
            tx.commit();
            return 1;
        } catch(Exception exception) {
        	exception.printStackTrace();
            return 0;
        }
	}

	@Override
	public int delete(Address address) {
		tx.begin();
        try {
            em.remove(address);
            return 1;
        } catch(Exception e) {
            return 0;
        }
	}
}

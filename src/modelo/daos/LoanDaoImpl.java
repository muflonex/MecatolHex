package modelo.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.beans.Loan;

public class LoanDaoImpl implements LoanDao {
	
	EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction tx;
    String sql;
    Query query;
    
    
	public LoanDaoImpl() {
		emf = Persistence.createEntityManagerFactory("MecatolHex");
        em = emf.createEntityManager();
        tx = em.getTransaction();
	}

	@Override
	public int insert(Loan loan) {
	    int rows = 0;
        tx.begin();
        try {
            em.persist(loan);
            tx.commit();
            return 1;
        } catch(Exception exception) {
        	exception.printStackTrace();
            return 0;
        }
	}

	@Override
	public Loan findById(int loanId) {
		 return em.find(Loan.class, loanId);
	}

	@Override
	public List<Loan> findAll() {
		sql = "select c FROM Loan c";
	    query = em.createQuery(sql);
	    return query.getResultList();
	}
	
	@Override
	public List<Loan> findUserLoans(int userId) {
		sql = "select l FROM Loan l where l.user.userId = :userId ORDER BY l.startDate DESC";
		query = em.createQuery(sql);
		query.setParameter("userId", userId);
		return query.getResultList();
	}
	@Override 
	public List<Loan> findUserActiveLoans(int userId) {
		sql = "select l FROM Loan l where l.user.userId = :userId AND l.endDate IS NULL";
		query = em.createQuery(sql);
		query.setParameter("userId", userId);
		return query.getResultList();
	}
	
	@Override
	public List<Loan> findAllActive() {
		sql = "select l from Loan l where l.endDate IS NULL";
		query = em.createQuery(sql);
		return query.getResultList();
	}

	@Override
	public int update(Loan loan) {
		tx.begin();
        try {
            em.merge(loan);
            tx.commit();
            return 1;
        } catch(Exception exception) {
        	exception.printStackTrace();
            return 0;
        }
	}

	@Override
	public int delete(Loan loan) {
		tx.begin();
        try {
            em.remove(loan);
            return 1;
        } catch(Exception e) {
            return 0;
        }
	}
}

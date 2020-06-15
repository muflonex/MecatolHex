package modelo.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import modelo.beans.Game;

public class GameDaoImpl implements GameDao {

	EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction tx;
    String sql;
    Query query;
    
    
	public GameDaoImpl() {
		emf = Persistence.createEntityManagerFactory("MecatolHex");
        em = emf.createEntityManager();
        tx = em.getTransaction();
	}

	@Override
	public int insert(Game game) {
	    int rows = 0;
        tx.begin();
        try {
            em.persist(game);
            tx.commit();
            return 1;
        } catch(Exception exception) {
        	exception.printStackTrace();
            return 0;
        }
	}

	@Override
	public Game findById(int gameId) {
		 return em.find(Game.class, gameId);
	}

	@Override
	public List<Game> findAll() {
		sql = "select c from Game c";
	    query = em.createQuery(sql);
	    return query.getResultList();
	}

	@Override
	public int update(Game game) {
		tx.begin();
        try {
            em.merge(game);
            tx.commit();
            return 1;
        } catch(Exception exception) {
        	exception.printStackTrace();
            return 0;
        }
	}

	@Override
	public int delete(Game game) {
		tx.begin();
        try {
            em.remove(game);
            return 1;
        } catch(Exception e) {
            return 0;
        }
	}

	@Override
	public List<Game> query(Map<String,Object> params) {
		 CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder(); 
         CriteriaQuery<Game> query = criteriaBuilder.createQuery(Game.class); 
         Root<Game> from = query.from(Game.class); 
         
         query.select(from); 
         Predicate[] predicates = analyzeParameters(criteriaBuilder, from, params); 
         query.where(criteriaBuilder.and(predicates));
         TypedQuery<Game> typedQuery = em.createQuery(query); 
         List<Game> results = typedQuery.getResultList();
         return results;
	}
	
	private Predicate[] analyzeParameters(CriteriaBuilder builder, Root<Game> from, Map<String,Object> params) {
		List<Predicate> tempPredicates = new ArrayList<Predicate>();
		
		for (Map.Entry<String, Object> entry : params.entrySet()) { 
            String key = entry.getKey(); 
            String[] valueArray = (String[]) params.get(key); 
            String value = valueArray[0];
            if(!value.isEmpty()) {
	            switch(key) {
	            case "name":
	            	tempPredicates.add(builder.like(from.get(key), "%"+value+"%")); 
	            	break;
	            case "minPlayers":
	            case "difficulty":
	            case "lingDependency":
	            	tempPredicates.add(builder.ge(from.get(key), Integer.parseInt(value)));
	            	break;
	            case "maxPlayers":
	            case "playTime":
	            	tempPredicates.add(builder.le(from.get(key), Integer.parseInt(value)));
	            	break;
	            }
            }
        } 
        Predicate[] predicates = new Predicate[tempPredicates.size()]; 
        for (int i = 0; i < tempPredicates.size(); i++) { 
            predicates[i] = tempPredicates.get(i); 
        } 
 
        return predicates; 
	}
	

}

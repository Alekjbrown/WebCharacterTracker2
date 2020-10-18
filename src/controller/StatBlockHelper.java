package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import model.StatBlock;

public class StatBlockHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CharacterTracker");
	
	public void insertStatBlock(StatBlock s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<StatBlock> getAll(){
		EntityManager em = emfactory.createEntityManager();
		List<StatBlock> allStatBlocks = em.createQuery("SELECT s FROM StatBlock s").getResultList();
		return allStatBlocks;
	}
	
	public void delete(StatBlock toDelete) throws RollbackException {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<StatBlock> tq = em.createQuery("SELECT i FROM StatBlock i where i.id = :selectedId",StatBlock.class);
		
		//sub param for actual data
		tq.setParameter("selectedId", toDelete.getId());
		
		tq.setMaxResults(1);
		
		//save result to new
		StatBlock result = tq.getSingleResult();
		
		//remove
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public StatBlock searchById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		StatBlock found = em.find(StatBlock.class, idToEdit);
		em.close();
		return found;
	}
	
	public void update(StatBlock toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanup() {
		emfactory.close();
	}
}

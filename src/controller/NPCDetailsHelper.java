package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.NPCDetails;

public class NPCDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CharacterTracker");
	
	public void insertNewNPCDetails(NPCDetails s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<NPCDetails> getNPCS(){
		EntityManager em = emfactory.createEntityManager();
		List<NPCDetails> allNPCDetails = em.createQuery("SELECT n FROM NPCDetails n").getResultList();
		return allNPCDetails;
	}
	
	public void deleteList(NPCDetails toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<NPCDetails> typedQuery = em.createQuery("Select detail from NPCDetails detail where detail.id = :selectedId", NPCDetails.class);
		
		//sub param with actual data
		typedQuery.setParameter("selectedId", toDelete.getId());
		
		//only one result
		typedQuery.setMaxResults(1);
		
		//get result and save it to new npc item
		NPCDetails result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public NPCDetails searchForNPCDetailsById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		NPCDetails found = em.find(NPCDetails.class, tempId);
		em.close();
		return found;
	}
	
	public void updateList(NPCDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}

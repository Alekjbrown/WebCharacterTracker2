package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
}

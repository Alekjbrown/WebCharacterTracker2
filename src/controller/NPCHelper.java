package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.NPC;

public class NPCHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CharacterTracker");
	
	public void insert(NPC npc) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(npc);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<NPC> getAll(){
		EntityManager em = emfactory.createEntityManager();
		List<NPC> allNPC = em.createQuery("SELECT i FROM NPC i").getResultList();
		return allNPC;
	}
	
	public void delete(NPC toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<NPC> tq = em.createQuery("SELECT i FROM NPC i where i.name = :selectedName and i.race = :selectedRace",NPC.class);
		
		//substitute parameters for actual data from toDelete
		tq.setParameter("selectedName", toDelete.getName());
		tq.setParameter("selectedRace", toDelete.getRace());
		
		//only want one result
		tq.setMaxResults(1);
		
		//get the result and save it into a new npc
		NPC result = tq.getSingleResult();
		
		//remove item
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public NPC searchByID(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		NPC found = em.find(NPC.class, idToEdit);
		em.close();
		return found;
	}
	
	public void update(NPC toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<NPC> searchByName(String npcName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<NPC> tq = em.createQuery("SELECT i FROM NPC i where i.name = :selectedName", NPC.class);
		tq.setParameter("selectedName", npcName);
		List<NPC> found = tq.getResultList();
		em.close();
		return found;
	}
	
	public List<NPC> searchByRace(String npcRace) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<NPC> tq = em.createQuery("SELECT i FROM NPC i where i.race = :selectedRace", NPC.class);
		tq.setParameter("selectedRace", npcRace);
		List<NPC> found = tq.getResultList();
		em.close();
		return found;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}

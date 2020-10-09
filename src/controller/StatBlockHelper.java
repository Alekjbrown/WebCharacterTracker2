package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
	
	public List<StatBlock> showAllStatBlocks(){
		EntityManager em = emfactory.createEntityManager();
		List<StatBlock> allStatBlocks = em.createQuery("SELECT s FROM StatBlock s").getResultList();
		return allStatBlocks;
	}
}

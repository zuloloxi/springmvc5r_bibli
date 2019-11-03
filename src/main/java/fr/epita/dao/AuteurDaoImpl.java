package fr.epita.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import fr.epita.entity.Auteur;

@Repository
@Transactional
public class AuteurDaoImpl implements AuteurDao  {
	//@PersistenceContext(unitName = "bibliothequePU")
	//EntityManager em;
    private SessionFactory sessionFactory;	
	EntityManager em;
	public void creerAuteur(Auteur a) {
		// TODO Auto-generated method stub
		em=sessionFactory.createEntityManager();
		em.persist(a);
	}

	public Auteur trouverAuteur(Long id) {
		// TODO Auto-generated method stub
		em=sessionFactory.createEntityManager();
		return em.find(Auteur.class, id);
	}

	public void supprimerAuteur(Long id) {
		// TODO Auto-generated method stub
		Auteur a = trouverAuteur(id);
		em=sessionFactory.createEntityManager();
		em.remove(a);
		
	}

	public void modifierAuteur(Auteur a) {
		// TODO Auto-generated method stub
		em=sessionFactory.createEntityManager();
		em.merge(a);
	}
}

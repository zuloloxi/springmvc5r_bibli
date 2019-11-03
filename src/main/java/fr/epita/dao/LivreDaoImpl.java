package fr.epita.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.epita.entity.Livre;


@Repository
@Transactional
public class LivreDaoImpl implements LivreDAO  {
	
	private SessionFactory sessionFactory;	
	EntityManager em;
	public void creerLivre(Livre l) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(l);	   
	}
	
	public Livre trouverLivre (Long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Livre l=new Livre();
		l=currentSession.find(Livre.class,id);
		return(l);
	}
	
	/*
	public void supprimerLivre(Long id) {
		Livre l = trouverLivre(id);
		em.remove(l);
	}
	*/
	
	public void modifierLivre (Livre l) {

			em.merge(l);

	}

	public void supprimer(Livre l) {
		// TODO Auto-generated method stub
		//Session currentSession = sessionFactory.getCurrentSession();
		em=sessionFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(l);
			em.getTransaction().commit();
		}catch (Exception se) {
			// TODO: handle exception
			em.getTransaction().rollback();
		}
		finally {
			em.close(); // demande explicite de fermeture au pool de connexion
		}
	}

	public List<Livre> findAll() {
		// TODO Auto-generated method stub
		//Session currentSession = sessionFactory.getCurrentSession();
		em=sessionFactory.createEntityManager();
		List<Livre> results;
		try {
		em.getTransaction().begin();// pas obligatoire sur une recherche
			Query query=em.createQuery("SELECT l FROM Livre l");
			results=query.getResultList();
			em.getTransaction().commit();       // pas obligatoire sur une recherche
		}finally {
			em.close();
		}
		return results;
	}
}

package fr.epita.service;

import java.util.List;

import fr.epita.entity.Livre;

public interface LivreService {
	
	/* cette m�thode permet d'enregistrer un livre dans la base de donn�es.
	 * @param l le livre � enregistrer
	 */

	String enregistrerLivre(Livre l);
	Livre recupererLivre(Long id);
	void modifierLivre (Livre l);
	void supprimerLivre(Livre l);
	List<Livre>findAll();
}

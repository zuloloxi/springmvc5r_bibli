package fr.epita.service;

import fr.epita.entity.Auteur;

public interface AuteurService {
	
	/* cette m�thode permet d'enregistrer un livre dans la base de donn�es.
	 * @param l le livre � enregistrer
	 */

	String enregistrerAuteur(Auteur a);
	Auteur recupererAuteur(Long id);
	void modifierAuteur (Auteur a);
	void supprimerAuteur(Long id);
}

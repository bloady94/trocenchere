package fr.eni.trocenchere.dal.test;

import java.time.LocalDate;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.ArticleVendu;
import fr.eni.trocenchere.bo.Categorie;
import fr.eni.trocenchere.bo.Enchere;
import fr.eni.trocenchere.bo.Retrait;
import fr.eni.trocenchere.bo.Utilisateur;
import fr.eni.trocenchere.dal.jdbc.EncheresDAOJdbcImpl;

public class AppliTestDAL {

	public static void main(String[] args) {
		Utilisateur corentin = new Utilisateur("corentinLeCaramel","ROBIN", "Corentin", "jadoreJPP@gmail.com", "0612121212", "rue des Blasés", "35000", "RENNES", "motdepasse", 100, false);
		Utilisateur jeremie = new Utilisateur("jeremieLeBlase","DESNOES", "Jeremie", "jmePrendsDesBagnolesAVelo@gmail.com", "0606060606", "rue des Fifous", "35000", "RENNES", "1234", 100, true);
		Utilisateur gaspard = new Utilisateur("gazpacho","JOHANET", "Gaspard", "gaspardLeBG@crack.com", "0699999999", "rue des Quasi-Mineurs", "35000", "RENNES", "laMatrice", 100, false);

		Categorie electromenager = new Categorie("Electroménager");
		Categorie auto = new Categorie("Autos/Motos/Vélos");
		Categorie jardinage = new Categorie("Jardinage");
		
		ArticleVendu drogueDuBonheur = new ArticleVendu("LSD", "Petite pilule du bonheur :)", LocalDate.now(), LocalDate.of(2023, 3, 31), 100, 220, corentin,  jardinage);
		ArticleVendu veloDeCompet = new ArticleVendu("Velo", "B'Twin Decathlon", LocalDate.now(), LocalDate.now(), 100, 220, jeremie,  auto);
		ArticleVendu coeur5g = new ArticleVendu("Coeur 5 g", "C'est trop compliqué pour décrire", LocalDate.now(), LocalDate.now(), 100, 220, gaspard,  electromenager);
		
		Retrait retraitDrogue = new Retrait(corentin.getRue(), corentin.getCodePostal(), corentin.getVille(), drogueDuBonheur);
		Retrait retraitVelo = new Retrait(jeremie.getRue(), jeremie.getCodePostal(), jeremie.getVille(), veloDeCompet);
		Retrait retraitCoeur = new Retrait(gaspard.getRue(), gaspard.getCodePostal(), gaspard.getVille(), coeur5g);
		
		Enchere enchere1 = new Enchere(LocalDate.now(), 50, jeremie, drogueDuBonheur);
		Enchere enchere2 = new Enchere(LocalDate.now(), 60, corentin, coeur5g);
		Enchere enchere3 = new Enchere(LocalDate.now(), 100, gaspard, veloDeCompet);
		
		EncheresDAOJdbcImpl dao = new EncheresDAOJdbcImpl();
		
		try {
			dao.insert_articleVendu(drogueDuBonheur);
			dao.insert_articleVendu(coeur5g);
			dao.insert_articleVendu(veloDeCompet);
			dao.insert_retrait(retraitDrogue);
			dao.insert_retrait(retraitVelo);
			dao.insert_retrait(retraitCoeur);
			dao.insert_enchere(enchere1);
			dao.insert_enchere(enchere2);
			dao.insert_enchere(enchere3);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}

}

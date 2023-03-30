package fr.eni.trocenchere.bo;

import java.time.LocalDate;

public class AppliTestBo {

	public static void main(String[] args) {
		Utilisateur corentin = new Utilisateur("corentinLeCaramel","ROBIN", "Corentin", "jadoreJPP@gmail.com", "0612121212", "rue des Blasés", "35000", "RENNES", "motdepasse", 100, false);
		Utilisateur jeremie = new Utilisateur("jeremieLeBlase","DESNOES", "Jeremie", "jmePrendsDesBagnolesAVelo@gmail.com", "0606060606", "rue des Fifous", "35000", "RENNES", "1234", 100, true);
		Utilisateur gaspard = new Utilisateur("gazpacho","JOHANET", "Gaspard", "gaspardLeBG@crack.com", "0699999999", "rue des Quasi-Mineurs", "35000", "RENNES", "laMatrice", 100, false);

		Categorie electromenager = new Categorie("Electroménager");
		Categorie auto = new Categorie("Autos/Motos/Vélos");
		Categorie jardinage = new Categorie("Jardinage");
		
		ArticleVendu drogueDuBonheur = new ArticleVendu("LSD", "Petite pilule du bonheur :)", LocalDate.now(), LocalDate.of(2023, 3, 31), 100, 220, corentin,  jardinage);
		ArticleVendu veloDeCompet = new ArticleVendu("Velo", "B'Twin Decathlon", LocalDate.now(), LocalDate.of(2023, 4, 15), 100, 220, jeremie,  auto);
		ArticleVendu coeur5g = new ArticleVendu("Coeur 5 g", "C'est trop compliqué pour décrire", LocalDate.now(), LocalDate.of(2023, 4, 30), 100, 220, gaspard,  electromenager);
		
		Retrait retraitDrogue = new Retrait(corentin.getRue(), corentin.getCodePostal(), corentin.getVille(), drogueDuBonheur);
		Retrait retraitVelo = new Retrait(jeremie.getRue(), jeremie.getCodePostal(), jeremie.getVille(), veloDeCompet);
		Retrait retraitCoeur = new Retrait(gaspard.getRue(), gaspard.getCodePostal(), gaspard.getVille(), coeur5g);
		
		Enchere enchere1 = new Enchere(LocalDate.now(), 50, jeremie, drogueDuBonheur);
		Enchere enchere2 = new Enchere(LocalDate.now(), 60, corentin, coeur5g);
		Enchere enchere3 = new Enchere(LocalDate.now(), 100, gaspard, veloDeCompet);
		
		System.out.println(enchere1.toString());
		System.out.println(enchere2.toString());
		System.out.println(enchere3.toString());
		
		System.out.println(retraitDrogue.toString());
		System.out.println(retraitVelo.toString());
		System.out.println(retraitCoeur.toString());
	}

}

package fr.eni.trocenchere.bo;

import java.util.ArrayList;
import java.util.List;

public class Categorie {

		private Integer noCategorie;
		private String libelle;
		private List<ArticleVendu> listeArticles = new ArrayList<>();
		
		public Categorie() {
		}

		public Categorie(Integer noCategorie, String libelle, List<ArticleVendu> listeArticles) {
			this.noCategorie = noCategorie;
			this.libelle = libelle;
			this.listeArticles = listeArticles;
		}
		
		public Categorie(String libelle) {
			this.libelle = libelle;
		}


		public Integer getNoCategorie() {
			return noCategorie;
		}

		public void setNoCategorie(Integer noCategorie) {
			this.noCategorie = noCategorie;
		}

		public String getLibelle() {
			return libelle;
		}

		public void setLibelle(String libelle) {
			this.libelle = libelle;
		}

		public List<ArticleVendu> getListeArticles() {
			return listeArticles;
		}

		public void setListeArticles(List<ArticleVendu> listeArticles) {
			this.listeArticles = listeArticles;
		}

		@Override
		public String toString() {
			return "Categorie [no_categorie=" + noCategorie + ", libelle=" + libelle + "]";
		}
		
		
}

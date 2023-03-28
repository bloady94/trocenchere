package fr.eni.trocenchere.bo;

import java.util.ArrayList;
import java.util.List;

public class Categorie {

		private Integer no_categorie;
		private String libelle;
		private List<ArticleVendu> listeArticles = new ArrayList<>();
		
		public Categorie() {
		}

		public Categorie(Integer no_categorie, String libelle, List<ArticleVendu> listeArticles) {
			this.no_categorie = no_categorie;
			this.libelle = libelle;
			this.listeArticles = listeArticles;
		}
		
		public Categorie(String libelle) {
			super();
			this.libelle = libelle;
		}

		public Categorie(Integer no_categorie, String libelle) {
			this.no_categorie = no_categorie;
			this.libelle = libelle;
		}

		public Integer getNo_categorie() {
			return no_categorie;
		}

		public void setNo_categorie(Integer no_categorie) {
			this.no_categorie = no_categorie;
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
			return "Categorie [no_categorie=" + no_categorie + ", libelle=" + libelle + "]";
		}
		
		
}

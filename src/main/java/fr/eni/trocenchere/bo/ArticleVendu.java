package fr.eni.trocenchere.bo;

import java.time.LocalDate;

public class ArticleVendu {
	
	private Integer no_article;
	private String nom_article;
	private String description;
	private LocalDate debutEnchere;
	private LocalDate finEnchere;
	private Integer prix_initial ;
	private Integer prix_final ;
	private Integer no_utilisateur; 
	private Integer no_categorie;
	

	
	public ArticleVendu() {
		super();
	}


	public ArticleVendu(Integer no_article, String nom_article, String description, LocalDate debutEnchere,
			LocalDate finEnchere, Integer prix_initial, Integer prix_final, Integer no_utilisateur,
			Integer no_categorie) {
		super();
		this.no_article = no_article;
		this.nom_article = nom_article;
		this.description = description;
		this.debutEnchere = debutEnchere;
		this.finEnchere = finEnchere;
		this.prix_initial = prix_initial;
		this.prix_final = prix_final;
		this.no_utilisateur = no_utilisateur;
		this.no_categorie = no_categorie;
	}


	public Integer getNo_article() {
		return no_article;
	}
	public void setNo_article(Integer no_article) {
		this.no_article = no_article;
	}

	public String getNom_article() {
		return nom_article;
	}
	public void setNom_article(String nom_article) {
		this.nom_article = nom_article;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDebutEnchere() {
		return debutEnchere;
	}
	public void setDebutEnchere(LocalDate debutEnchere) {
		this.debutEnchere = debutEnchere;
	}

	public LocalDate getFinEnchere() {
		return finEnchere;
	}
	public void setFinEnchere(LocalDate finEnchere) {
		this.finEnchere = finEnchere;
	}
	
	public Integer getPrix_initial() {
		return prix_initial;
	}
	public void setPrix_initial(Integer prix_initial) {
		this.prix_initial = prix_initial;
	}

	public Integer getPrix_final() {
		return prix_final;
	}
	public void setPrix_final(Integer prix_final) {
		this.prix_final = prix_final;
	}

	public Integer getNo_utilisateur() {
		return no_utilisateur;
	}
	public void setNo_utilisateur(Integer no_utilisateur) {
		this.no_utilisateur = no_utilisateur;
	}

	public Integer getNo_categorie() {
		return no_categorie;
	}
	public void setNo_categorie(Integer no_categorie) {
		this.no_categorie = no_categorie;
	}


	@Override
	public String toString() {
		return "ArticleVendu [no_article=" + no_article + ", nom_article=" + nom_article + ", description="
				+ description + ", debutEnchere=" + debutEnchere + ", finEnchere=" + finEnchere + ", prix_initial="
				+ prix_initial + ", prix_final=" + prix_final + ", no_utilisateur=" + no_utilisateur + ", no_categorie="
				+ no_categorie + "]";
	}


	
	
	
	

}

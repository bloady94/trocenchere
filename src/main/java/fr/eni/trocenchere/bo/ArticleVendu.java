package fr.eni.trocenchere.bo;

import java.time.LocalDate;

public class ArticleVendu {
	
	private Integer noArticle;
	private String nomArticle;
	private String description;
	private LocalDate debutEnchere;
	private LocalDate finEnchere;
	private Integer prixInitial ;
	private Integer prixFinal ;
	private Utilisateur utilisateur; 
	private Categorie categorie;
	

	
	public ArticleVendu() {
	}


	public ArticleVendu(String nomArticle, String description, LocalDate debutEnchere, LocalDate finEnchere,
			Integer prixInitial, Integer prixFinal, Utilisateur utilisateur, Categorie categorie) {
		this.nomArticle = nomArticle;
		this.description = description;
		this.debutEnchere = debutEnchere;
		this.finEnchere = finEnchere;
		this.prixInitial = prixInitial;
		this.prixFinal = prixFinal;
		this.utilisateur = utilisateur;
		this.categorie = categorie;
	}


	public Integer getNoArticle() {
		return noArticle;
	}
	public void setNoArticle(Integer noArticle) {
		this.noArticle = noArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
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
	
	public Integer getPrixInitial() {
		return prixInitial;
	}
	public void setPrixInitial(Integer prixInitial) {
		this.prixInitial = prixInitial;
	}

	public Integer getPrixFinal() {
		return prixFinal;
	}
	public void setPrixFinal(Integer prixFinal) {
		this.prixFinal = prixFinal;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	@Override
	public String toString() {
		return "ArticleVendu [no_article=" + noArticle + ", nom_article=" + nomArticle + ", description="
				+ description + ", debutEnchere=" + debutEnchere + ", finEnchere=" + finEnchere + ", prix_initial="
				+ prixInitial + ", prix_final=" + prixFinal + ", utilisateur=" + utilisateur + ", categorie="
				+ categorie + "]";
	}


	
	
	
	

}

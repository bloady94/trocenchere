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
	private Integer noUtilisateur; 
	private Integer noCategorie;
	

	
	public ArticleVendu() {
		super();
	}


	public ArticleVendu(Integer noArticle, String nomArticle, String description, LocalDate debutEnchere,
			LocalDate finEnchere, Integer prixInitial, Integer prixFinal, Integer noUtilisateur, Integer noCategorie) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.debutEnchere = debutEnchere;
		this.finEnchere = finEnchere;
		this.prixInitial = prixInitial;
		this.prixFinal = prixFinal;
		this.noUtilisateur = noUtilisateur;
		this.noCategorie = noCategorie;
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

	public Integer getNoUtilisateur() {
		return noUtilisateur;
	}
	public void setNoUtilisateur(Integer noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public Integer getNoCategorie() {
		return noCategorie;
	}
	public void setNoCategorie(Integer noCategorie) {
		this.noCategorie = noCategorie;
	}


	@Override
	public String toString() {
		return "ArticleVendu [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", debutEnchere=" + debutEnchere + ", finEnchere=" + finEnchere + ", prixInitial=" + prixInitial
				+ ", prixFinal=" + prixFinal + ", noUtilisateur=" + noUtilisateur + ", noCategorie=" + noCategorie
				+ "]";
	}
	
	
	
	
	

}

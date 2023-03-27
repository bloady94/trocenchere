package fr.eni.trocenchere.bo;

import java.time.LocalDate;

public class Enchere {

	
	private Integer no_enchere;
	private LocalDate date_enchere;
	private Integer montant_enchere;
	private Utilisateur no_utilisateur;
	private ArticleVendu no_article;
	
	public Enchere() {
	}

	public Enchere(Integer no_enchere, LocalDate date_enchere, Integer montant_enchere, Utilisateur no_utilisateur,
			ArticleVendu no_article) {
		this.no_enchere = no_enchere;
		this.date_enchere = date_enchere;
		this.montant_enchere = montant_enchere;
		this.no_utilisateur = no_utilisateur;
		this.no_article = no_article;
	}

	public Enchere(LocalDate date_enchere, Integer montant_enchere) {
		this.date_enchere = date_enchere;
		this.montant_enchere = montant_enchere;
	}

	public Integer getNo_enchere() {
		return no_enchere;
	}

	public void setNo_enchere(Integer no_enchere) {
		this.no_enchere = no_enchere;
	}

	public LocalDate getDate_enchere() {
		return date_enchere;
	}

	public void setDate_enchere(LocalDate date_enchere) {
		this.date_enchere = date_enchere;
	}

	public Integer getMontant_enchere() {
		return montant_enchere;
	}

	public void setMontant_enchere(Integer montant_enchere) {
		this.montant_enchere = montant_enchere;
	}

	public Utilisateur getNo_utilisateur() {
		return no_utilisateur;
	}

	public void setNo_utilisateur(Utilisateur no_utilisateur) {
		this.no_utilisateur = no_utilisateur;
	}

	public ArticleVendu getNo_article() {
		return no_article;
	}

	public void setNo_article(ArticleVendu no_article) {
		this.no_article = no_article;
	}

	@Override
	public String toString() {
		return "Enchere [no_enchere=" + no_enchere + ", date_enchere=" + date_enchere + ", montant_enchere="
				+ montant_enchere + "]";
	}
	
	
}

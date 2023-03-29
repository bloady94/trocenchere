package fr.eni.trocenchere.bo;

public class Retrait {

		private String rue;
		private String codePostal;
		private String ville;
		private ArticleVendu article;
		
		public Retrait() {
		}

		public Retrait(String rue, String codePostal, String ville, ArticleVendu article) {
			this.rue = rue;
			this.codePostal = codePostal;
			this.ville = ville;
			this.article = article;
		}

		public String getRue() {
			return rue;
		}

		public void setRue(String rue) {
			this.rue = rue;
		}

		public String getCodePostal() {
			return codePostal;
		}

		public void setCodePostal(String codePostal) {
			this.codePostal = codePostal;
		}

		public String getVille() {
			return ville;
		}

		public void setVille(String ville) {
			this.ville = ville;
		}

		public ArticleVendu getArticle() {
			return article;
		}

		public void setArticle(ArticleVendu article) {
			this.article = article;
		}

		@Override
		public String toString() {
			return "Retrait [rue=" + rue + ", code_postal=" + codePostal + ", ville=" + ville + "]";
		}
		
		
}

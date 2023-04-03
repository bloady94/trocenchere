package fr.eni.trocenchere.modifierProfil;

import fr.eni.trocenchere.BusinessException;
import fr.eni.trocenchere.bo.Utilisateur;

public interface ModifierProfilDAO {
	
	public void update_utilisateur(Utilisateur utilisateur) throws BusinessException;
	}

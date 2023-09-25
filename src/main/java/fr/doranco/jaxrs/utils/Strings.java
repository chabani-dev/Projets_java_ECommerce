package fr.doranco.jaxrs.utils;

import org.json.JSONObject;

import fr.doranco.ecommerce.entity.pojo.Commentaire;

public final class Strings {

	public static String getCommentairesResponseJsonString(Commentaire commentaires) {
		JSONObject json = new JSONObject();
		json.put("id", commentaires.getId())
					.put("texte", commentaires.getTexte())
					.put("note", commentaires.getNote());
					

		return json.toString();
	}

}

package fr.doranco.jaxrs.jersey.server;

import java.net.URISyntaxException;

import javax.ws.rs.core.Response;

public interface ICommentairesWebRessource {

	Response getCommentairesByArticleId(Integer articleId) throws URISyntaxException;

	Response getCommentaires() throws URISyntaxException;

	Response getNbCommandesParVille() throws URISyntaxException;

}
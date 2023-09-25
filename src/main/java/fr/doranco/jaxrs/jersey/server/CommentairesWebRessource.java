package fr.doranco.jaxrs.jersey.server;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.doranco.ecommerce.entity.pojo.Commentaire;



@Path("commentaires")
@Produces(MediaType.TEXT_PLAIN + ";charset=UTF-8")
public class CommentairesWebRessource implements ICommentairesWebRessource{
	
	private final static String CHARSET = ";charset=UTF-8";

	@Override
	
	@GET
    @Path("listeResponse")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON + CHARSET })
	public Response getCommentairesByArticleId(@PathParam ("idArticle") Integer articleId) throws URISyntaxException {
		List<Commentaire> listeCommentaires = new ArrayList<Commentaire>();

		Commentaire commentaire1 = new Commentaire();
		commentaire1.setId(1);
		commentaire1.setTexte("hello ");
		commentaire1.setNote(7);
		listeCommentaires.add(commentaire1);

		Commentaire commentaire2 = new Commentaire();
		commentaire2.setId(2);
		commentaire2.setTexte("derto");
		commentaire2.setNote(8);
     	listeCommentaires.add(commentaire2);

        return Response.ok().entity(listeCommentaires).build();
		
}

	@Override
	@GET
	@Path("commentaires")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON + CHARSET })
	public Response getCommentaires(){
		
		Commentaire commentaire = new Commentaire();
		commentaire.setId(2);
		commentaire.setTexte("not comment");
		commentaire.setNote(2);
		

		return Response.ok().entity(commentaire).build();
	}

	@Override
	@GET
	@Path("commandesPArVille")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON + CHARSET })
	public Response getNbCommandesParVille() throws URISyntaxException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}

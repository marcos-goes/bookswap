package bookswap.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import bookswap.entity.Livro;
import bookswap.util.Dicionario;

@Path("book")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class BookEndpoint {
	
	@Inject
	private Dicionario dicionario;

	@GET	
	public Response buscaLivros(){
		ArrayList<Livro> livros = (ArrayList<Livro>) dicionario.buscaTodos();
		
		if(livros == null || livros.isEmpty())
			throw new WebApplicationException(Status.NOT_FOUND);
		
		return Response.ok(livros).build();
	}
	
	
	@GET
	@Path("{id}")
	public Response buscaLivro( @PathParam("id") Integer id){
		Livro livro =  dicionario.buscaLivro(id);
		
		if(livro == null)
			throw new WebApplicationException(Status.NOT_FOUND);
		
		return Response.ok(livro).build();
	}


	@DELETE
	@Path("{id}")
	public Response excluiLivro( @PathParam("id") Integer id){
		Livro livro =  dicionario.excluiLivro(id);
		
		if(livro == null)
			throw new WebApplicationException(Status.NOT_FOUND);
		
		return Response.noContent().build();
	}
	
	
	@POST
	public Response adicionaLivro(Livro livro) throws URISyntaxException{
		if (dicionario.adicionaLivro(livro) != null)
			throw new WebApplicationException(Status.CONFLICT);
		
		return Response.created(new URI("/book/" + livro.getId())).entity(livro).build();
	}
}

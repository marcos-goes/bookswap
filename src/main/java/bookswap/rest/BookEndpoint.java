package bookswap.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import bookswap.entity.Livro;
import bookswap.util.Dicionario;

@Path("book")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class BookBasics {
	
	@Inject
	private Dicionario dicionario;

	@GET	
	public List<Livro> buscaLivros(){
		return dicionario.buscaTodos();
	}
	
	@GET
	@Path("{id}")
	public Livro buscaLivro( @PathParam("id") Integer id){
		return dicionario.buscaLivro(id);
	}
}

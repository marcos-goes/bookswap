package bookswap.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("book")
public class BookBasics {

	@GET
	@Produces({"application/json","application/xml", "text/plain"})
	public String testaGet(){
		System.out.println("Testa GET...");
		return "TESTEEEEE...";
	}
}

package rio.iplan.contracheque.api;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/infra")
public class InfraEndPoint {

	@Inject
	private EntityManager entityManager;
	
	@GET
	@Path("/versao")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVersao() {

		return Response.ok().entity("1.0.0").build();

	}

	@GET
	@Path("/heartbeat")
	@Produces(MediaType.APPLICATION_JSON)
	public Response heartbeat() {

		return Response.ok("Beating").build();

	}
	
	@GET
	@Path("/database")
	@Produces(MediaType.APPLICATION_JSON)
	public Response heartbeatDatabase() {
		
		entityManager
			.createQuery("select count(*) from FuncionarioTaxiRio", Long.class)
			.getSingleResult();
		
		return Response.ok("Beating Database").build();
		
	}

}

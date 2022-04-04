package rio.iplan.contracheque.api.resource;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/v1/heartbeat")
public class InfraResource {

	@Inject
	private EntityManager entityManager;
	
	@GET
	public Response heartbeat() {
		return Response.ok("Beating").build();
	}
	
	@GET
	@Path("/database")
	public Response heartbeatDatabase() {
		
		entityManager
			.createQuery("select count(*) from FuncionarioTaxiRio", Long.class)
			.getSingleResult();
		
		return Response.ok("Beating Database").build();

	}

}

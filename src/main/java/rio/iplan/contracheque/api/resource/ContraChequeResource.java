package rio.iplan.contracheque.api.resource;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import rio.iplan.contracheque.domain.FuncionarioTaxiRio;

@Path("/v1/contracheque")
public class ContraChequeResource {

    @Inject
    private EntityManager entityManager;

    @GET
    @Path("/funcionarios")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response obterTodosOsFuncionarios() {
    
        Query q = entityManager.createQuery("from FuncionarioTaxiRio f");
        List<FuncionarioTaxiRio> funcionariosTaxiRio = q.getResultList();
        
        return Response.ok().entity(funcionariosTaxiRio).build();
    
    }    
}
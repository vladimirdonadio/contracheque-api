package rio.iplan.contracheque.api;

import javax.inject.Inject;
//import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
//import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
//import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import rio.iplan.contracheque.domain.dto.ContraChequeDTO;
import rio.iplan.contracheque.domain.dto.ListaMesesDTO;
import rio.iplan.contracheque.domain.repository.TodosOsContraCheques;

//import rio.iplan.contracheque.domain.vo.MesContraChequeVO;

@Path("/contracheque")
public class ContraChequeEndPoint {

	@Inject
	private TodosOsContraCheques todosOsContraCheques;

	//@In(create=true)
	//private ContrachequeWSService contrachequeWSService;

	//@In(create=true)
	//private TodasAsImagensContracheque todasAsImagensContracheque;
	
	//@In(create=true)
	//TodosOsFuncionarios todosOsFuncionarios;

	@GET
	@Path("heartbeat")
	@Produces(MediaType.APPLICATION_JSON)
	public Response heartBeat() {
		return Response.ok("API Contracheque Beating").build();
	}

	@GET
	@Path("{cpf}/ultimosdozemeses")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterUltimos12MesesPorCpf(@PathParam("cpf") Long cpf, 
			@HeaderParam("token") String token) {

		try {

			TokenValidator.validarToken(token);
    		ListaMesesDTO retorno = new ListaMesesDTO();

    		retorno.setMes(todosOsContraCheques.obterUltimos12MesesContraChequeVOPorCpf(cpf));
			return Response.ok(retorno).build();

		} catch (TokenInvalidoException|ContrachequeapiException e) {

			return Response.status(422).entity(e.getMessage()).build();

		}

	}

	/*
	@GET
	@Path("{cpf}/funcionario")
	public boolean isFuncionario(@HeaderParam("token") String token, @PathParam("cpf") Long cpf) {

		try {
			TokenValidator.validarToken(token);
			return this.contrachequeWSService.isFuncionario(cpf);
		} catch (TokenInvalidoException|ContrachequeapiException e) {
			return false;
		}

	}
	*/

	/*
	@GET
	@Path("{cpf}/listadecontracheque")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterContrachequesPorPeriodo(@PathParam("cpf") Long cpf,
			@HeaderParam("token") String token,
			@QueryParam("mesAnoInicial") String mesAnoInicial,
			@QueryParam("mesAnoFinal") String mesAnoFinal) {
		
		try {
			TokenValidator.validarToken(token);
			return Response.ok(this.contrachequeWSService.obterListaContraChequeDTOPorCPFePeriodo(cpf, mesAnoInicial, mesAnoFinal)).build();
		} catch (TokenInvalidoException|ContrachequeapiException e) {
			return Response.status(422).entity(e.getMessage()).build();
		}

	}
	*/
	
	/*
	@GET
	@Path("funcionario")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterFuncionarios(
	        @HeaderParam("token") String token,
	        @QueryParam("nome") String nome,
	        @QueryParam("matricula") Long matricula,
	        @QueryParam("cpf") Long cpf,
	        @QueryParam("setor") String setor,
	        @QueryParam("setorGestor") String setorGestor,
	        @QueryParam("matriculas") String matriculas,
			@QueryParam("unico") String unico) {
	    try {
	        TokenValidator.validarToken(token);
	        if (unico!=null && unico.equalsIgnoreCase("true")) {
	        	
	            return Response.ok(this.contrachequeWSService.obterFuncionario((matricula==null?null:matricula.toString()), (cpf==null?null:cpf.toString()))).build();
	        } else {
		        if(matriculas==null || matriculas.isEmpty()) {
		        	
		            return Response.ok(this.contrachequeWSService.obterFuncionarios(nome, (matricula==null?null:matricula.toString()), (cpf==null?null:cpf.toString()), setor, setorGestor)).build();
		        }
	        }
            return Response.ok(this.contrachequeWSService.obterFuncionarios(matriculas)).build();
            
        } catch (TokenInvalidoException|ContrachequeapiException e) {
        	
            return Response.status(422).entity(e.getMessage()).build();
        }
	}
	*/
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterContraChequePorId(@HeaderParam("token") String token, @PathParam("id") Long id) {
		
		try {

			TokenValidator.validarToken(token);

    		ContraChequeDTO retorno = new ContraChequeDTO(todosOsContraCheques.obterPorId(id));
			return Response.ok(retorno).build();

		} catch (TokenInvalidoException|ContrachequeapiException e) {

			return Response.status(422).entity(e.getMessage()).build();

		}

	}
	
	/*
	@GET
	@Path("{cpf}/fontepagadora")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterFontesPagadoras(@HeaderParam("token") String token, @PathParam("cpf") Long cpf) {
		
		try {

			TokenValidator.validarToken(token);

    		ListaEmpresasDTO retorno = new ListaEmpresasDTO();
    		
    		retorno.setEmpresa(this.todosOsContraCheques.obterTodasAsEmpresasPorCpf(cpf));
			return Response.ok(retorno).build();

		} catch (TokenInvalidoException|ContrachequeapiException e) {

			return Response.status(422).entity(e.getMessage()).build();

		}

	}
	*/

	/*
	@GET
	@Path("{cpf}/dirf/{empresa}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterAnosDirf(@HeaderParam("token") String token,
			@PathParam("cpf") Long cpf,
			@PathParam("empresa") Long codEmpresa) {
		
		try {

			TokenValidator.validarToken(token);

    		ListaAnosDirfDTO retorno = new ListaAnosDirfDTO();
    		
    		retorno.setAnoBase(this.todosOsContraCheques.obterUltimos6AnosDirfPorCpfEmpresa(cpf, codEmpresa));

    		return Response.ok(retorno).build();

		} catch (TokenInvalidoException|ContrachequeapiException e) {

			return Response.status(422).entity(e.getMessage()).build();

		}
	}
	*/

	/*
	@GET
	@Path("{cpf}/dirf/{empresa}/{ano}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterDirf(@HeaderParam("token") String token,
			@PathParam("cpf") Long cpf,
			@PathParam("empresa") Long codEmpresa,
			@PathParam("ano") Long anoBase) {
		
		try {

			TokenValidator.validarToken(token);

    		return Response.ok(this.todosOsContraCheques.obterDirfPorCpfEmpresaAnoBase(cpf, codEmpresa, anoBase)).build();

		} catch (TokenInvalidoException|ContrachequeapiException e) {

			return Response.status(422).entity(e.getMessage()).build();

		}
	}
	*/

	/*
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public boolean gravarImagemImpressao(@HeaderParam("token") String token, ImagemContraChequeDTO imagem){

		try {
			TokenValidator.validarToken(token);
			contrachequeWSService.salvarImagemDeImpressao(imagem.cpf2String(), imagem.getCodigoHash(), imagem.getDataImpressao(), imagem.getImagem(), imagem.getTipoImagem().toString());
			return true;

		} catch (TokenInvalidoException|ContrachequeapiException e) {
			return false;
		}

	}
	*/

	/*
	@GET
	@Path("datacargataxirio")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterDataUltimaCargaTaxiRio(@HeaderParam("token") String token) {
        try {

            TokenValidator.validarToken(token);
            
            return Response.ok("{\"dataCarga\":\"" + this.todosOsFuncionarios.obterDataDaUltimaCargaTaxiRio() + "\"}").build();

        } catch (TokenInvalidoException e) {

            return Response.status(422).entity(e.getMessage()).build();

        } catch(Exception e) {
            
            return Response.status(500).entity(e.getMessage()).build();
        }

	}
    */
}

package rio.iplan.contracheque.domain.repository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
//import javax.persistence.Query;

import rio.iplan.contracheque.api.ContrachequeapiException;
import rio.iplan.contracheque.domain.ContraCheque;
import rio.iplan.contracheque.domain.Empresa;
import rio.iplan.contracheque.domain.dto.DirfDTO;
import rio.iplan.contracheque.domain.vo.MesContraChequeVO;

@Named("todosOsContraCheques")
public class TodosOsContraCheques {

    @Inject
	private EntityManager entityManager;
	
	public TodosOsContraCheques() {
	}

	public TodosOsContraCheques(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public ContraCheque porId(Long id) {
		
		return entityManager.find(ContraCheque.class, id);
		
	}

	public ContraCheque obterPorId(Long id) throws ContrachequeapiException {

		try {
			return (ContraCheque)entityManager.createQuery("select c from ContraCheque c "
					+ " where c.id = :id "
					+ " order by c.matricula, c.mesAno, c.id")
					.setParameter("id", id)
					.getSingleResult();

		} catch (NoResultException e) {

			throw new ContrachequeapiException("NÃ£o hÃ¡ contracheque para a matrÃ­cula, mÃªs e tipo de folha informados.");
		}

	}

	@SuppressWarnings("unchecked")
	public List<MesContraChequeVO> obterUltimos12MesesContraChequeVOPorCpf(Long cpf) throws ContrachequeapiException {

		StringBuilder hql = new StringBuilder();

		hql.append("select distinct new " + MesContraChequeVO.class.getName());
		hql.append("(c.id, c.matricula, c.mesAno, c.folha, c.numeroFuncionario, c.empresa, substring(c.mesAno,4,7) + substring(c.mesAno,1,2)) ");
		hql.append(" from ContraCheque c join c.detalhe join c.rodape ");
		hql.append(" where c.cpf = :cpf ");
		hql.append(" order by substring(c.mesAno,4,7) + substring(c.mesAno,1,2) desc");
		
		List<MesContraChequeVO> resultado = this.entityManager.createQuery(hql.toString())
				.setParameter("cpf", cpf)
				.getResultList();
		
		if(resultado.size()==0) return new ArrayList<MesContraChequeVO>();
		
		List<MesContraChequeVO> retorno = new ArrayList<MesContraChequeVO>();
		
		String mes = resultado.get(0).getAnoMes();
		int cont = 0;
		
		for (MesContraChequeVO mesContraChequeVO : resultado) {
		    retorno.add(mesContraChequeVO);
		    if(!mes.equals(mesContraChequeVO.getAnoMes())) {
		        mes = mesContraChequeVO.getAnoMes();
                cont ++;
		    }
		    if(cont>=12) break;
        }
		return retorno;

	}

	@SuppressWarnings("unchecked")
	public List<Empresa> obterTodasAsEmpresasPorCpf(Long cpf) throws ContrachequeapiException {

		String hql = "select distinct d.empresa "
				+ " from Dirf d "
				+ " where d.cpf = :cpf";
		List<Empresa> retorno = entityManager.createQuery(hql)
				.setParameter("cpf", cpf)
				.getResultList();

		if(retorno.size()==0) {
			throw new ContrachequeapiException("NÃ£o hÃ¡ fonte pagadora para matrÃ­cula e cpf informados.");
		}

		return retorno;

	}
	
	@SuppressWarnings("unchecked")
	public List<Long> obterUltimos6AnosDirfPorCpfEmpresa(Long cpf, 
			Long codEmpresa) throws ContrachequeapiException {

		String hql = "select distinct d.anoBase "
				+ " from Dirf d "
				+ " where d.cpf = :cpf "
				+ " and d.empresa.id = :codEmpresa"
				+ " order by d.anoBase desc";

		List<Long> retorno = entityManager.createQuery(hql)
				.setParameter("cpf", cpf)
				.setParameter("codEmpresa", codEmpresa)
				.setMaxResults(6)
				.getResultList();

		if(retorno.size()==0) {
			throw new ContrachequeapiException("NÃ£o hÃ¡ Dirf para matrÃ­cula, cpf e empresa informados.");
		}

		return retorno;

	}

	public DirfDTO obterDirfPorCpfEmpresaAnoBase(Long cpf, 
			Long codEmpresa,
			Long anoBase) throws ContrachequeapiException {

		try {

			String hql = "select distinct new "	+ DirfDTO.class.getName()
					+ "(d) "
					+ " from Dirf d "
					+ " where d.cpf = :cpf "
					+ " and d.empresa.id = :codEmpresa "
					+ " and d.anoBase = :anoBase";

			DirfDTO retorno = (DirfDTO)entityManager.createQuery(hql)
					.setParameter("cpf", cpf)
					.setParameter("codEmpresa", codEmpresa)
					.setParameter("anoBase", anoBase)
					.setMaxResults(1)
					.getSingleResult();

			if(retorno != null) {
				retorno.setMatriculas(
						this.obterMatriculasPorCpfEmpresaAnoBase(cpf, codEmpresa, anoBase)
						.toString().replace("[", "").replace("]", ""));
			}

			return retorno;
			

		} catch (NoResultException e) {

			throw new ContrachequeapiException("NÃ£o hÃ¡ contracheque para a matrÃ­cula, mÃªs e tipo de folha informados.");
		}

	}
	
	@SuppressWarnings("unchecked")
	private List<String> obterMatriculasPorCpfEmpresaAnoBase (Long cpf,
			Long codEmpresa,
			Long anoBase) {
		
		return entityManager.createQuery("select distinct d.matricula "
				+ " from Dirf d "
				+ " where d.cpf = :cpf and "
				+ " d.empresa.id = :codEmpresa and "
				+ " d.anoBase = :anoBase"
				+ " order by d.matricula")
				.setParameter("cpf", cpf)
				.setParameter("codEmpresa", codEmpresa)
				.setParameter("anoBase", anoBase)
				.getResultList();
	}

	/*
	@SuppressWarnings("unchecked")
	public List<ContraChequeDTO> obterContraChequePorCPFePeriodo(Long cpf, String mesAnoInicio, String mesAnoFim) throws ContrachequeapiException {

		if(!MesAnoUtils.isPeriodoValido(mesAnoInicio, mesAnoFim)) {
			throw new ContrachequeapiException("PerÃ­odo de meses invÃ¡lido!");
		}
		
		String sql = "select new " + ContraChequeDTO.class.getName() +
				"(c, (substring(c.mesAno,4,7) + substring(c.mesAno,1,2))) "
				+ " from ContraCheque c "
				+ " where c.cpf = :cpf "
				+ " and (substring(c.mesAno,4,7) + substring(c.mesAno,1,2)) between :anoMesInicio and :anoMesFim "
				+ " order by (substring(c.mesAno,4,7) + substring(c.mesAno,1,2)) desc, c.matricula, c.folha";

		Query query = entityManager.createQuery(sql);
		query.setParameter("cpf", cpf);
		query.setParameter("anoMesInicio", MesAnoUtils.mesAno2AnoMes(mesAnoInicio));
		query.setParameter("anoMesFim", MesAnoUtils.mesAno2AnoMes(mesAnoFim));

		return query.getResultList();

	}

	public boolean isFuncionario(Long cpf) {
		String sql = "select cpf "
				+ " from VW_CONTRA_CHEQUES "
				+ " where cpf = :cpf ";

		Query query = entityManager.createNativeQuery(sql);
		query.setParameter("cpf", cpf);
		query.setMaxResults(1);
		
		return (query.getResultList().size()>0);
		
	}
	*/

}

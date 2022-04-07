package rio.iplan.contracheque.domain.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import rio.iplan.contracheque.api.ContrachequeapiException;
import rio.iplan.contracheque.domain.CabecalhoContraCheque;
import rio.iplan.contracheque.domain.ContraCheque;
import rio.iplan.contracheque.domain.RodapeContraCheque;
import rio.iplan.contracheque.domain.MensagemContraCheque;
import rio.iplan.contracheque.domain.DetalheContraCheque;

public class ContraChequeDTO {

    @Getter@Setter
	private String matricula;

	@Getter@Setter
	private Long numeroFuncionario;

	@Getter@Setter
	private String mesAno;

	@Getter@Setter
	private String folha;

	@Getter@Setter
	private Long cpf;

	@Getter@Setter
	private String empresa;

	@Getter@Setter
	private CabecalhoContraCheque cabecalho;

	@Getter@Setter
	private List<RodapeContraCheque> rodape = new ArrayList<RodapeContraCheque>();

	@Setter@Getter
	private List<DetalheContraCheque> detalhe = new ArrayList<DetalheContraCheque>();
	
	@Setter@Getter
	private List<MensagemContraCheque> mensagem = new ArrayList<MensagemContraCheque>();

	public ContraChequeDTO(ContraCheque contracheque, String anoMes) throws ContrachequeapiException {
		construir(contracheque);
	}

	public ContraChequeDTO(ContraCheque contracheque) throws ContrachequeapiException {
		construir(contracheque);
	}
	
	private void construir(ContraCheque contracheque) throws ContrachequeapiException {
		if(contracheque.getDetalhe().size()==0 || contracheque.getRodape().size()==0) {
			throw new ContrachequeapiException("Contracheque indisponÃ­vel.");
		}
		this.matricula = contracheque.getMatricula();
		this.numeroFuncionario = contracheque.getNumeroFuncionario();
		this.mesAno = contracheque.getMesAno();
		this.folha = contracheque.getFolha();
		this.cpf = contracheque.getCpf();
		this.empresa = contracheque.getEmpresa();
		this.cabecalho = contracheque.getCabecalho();
		this.mensagem = new ArrayList<MensagemContraCheque>(contracheque.getMensagem());
		this.rodape = gerarRodapeComDesconto(contracheque);
		this.detalhe = new ArrayList<DetalheContraCheque>(contracheque.getDetalhe());
	}

	private List<RodapeContraCheque> gerarRodapeComDesconto(ContraCheque contracheque) {

		Set<RodapeContraCheque> retorno = new HashSet<RodapeContraCheque>(contracheque.getRodape());
		retorno.add(new RodapeContraCheque(0L, contracheque.getId(), "Descontos:", BigDecimal.ZERO, this.numeroFuncionario, 997L));

		return new ArrayList<RodapeContraCheque>(retorno);

	}

}

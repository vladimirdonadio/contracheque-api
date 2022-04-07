package rio.iplan.contracheque.domain.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import rio.iplan.contracheque.domain.Dirf;
import rio.iplan.contracheque.domain.Empresa;

public class DirfDTO {

    @Getter@Setter
	private Long id;

	@Getter@Setter
	private Empresa empresa;
	
	@Getter@Setter
	private String endereco;

	@Getter@Setter
	private String cidade;

	@Getter@Setter
	private String uf;

	@Getter@Setter
	private String matriculas;

	@Getter@Setter
	private Long cpf;

	@Getter@Setter
	private String nome;

	@Getter@Setter
	private String codigoNucleo;
	
	@Getter@Setter
	private String nomeNucleo;

	@Getter@Setter
	private String natureza;
	
	@Getter@Setter
	private BigDecimal valorRenda;

	@Getter@Setter
	private String previrio;

	@Getter@Setter
	private BigDecimal valorPensaoAlimenticia;

	@Getter@Setter
	private BigDecimal valorImpostoRetido;

	@Getter@Setter
	private BigDecimal valorSalarioFamilia;

	@Getter@Setter
	private BigDecimal valorProventosReserva;

	@Getter@Setter
	private BigDecimal valorDiarias;

	@Getter@Setter
	private BigDecimal valorProventosAposentados;

	@Getter@Setter
	private BigDecimal valorDecimoTerceiroSalario;

	@Getter@Setter
	private BigDecimal valorImpostoRendaDecimoTerceiroSalario;

	@Getter@Setter
	private BigDecimal valorOutros;

	@Getter@Setter
	private Date dataEmissao;

	@Getter@Setter
	private Long anoBase;

	@Getter@Setter
	private String observacao;

	@Getter@Setter
	private String situacao;

	@Getter@Setter
	private BigDecimal valorRescisao;
	
	@Getter@Setter
	private String nrProcesso;
	
	@Getter@Setter
	private String qtdMeses;
	
	@Getter@Setter
	private String natRend;
	
	@Getter@Setter
	private BigDecimal vlTotRendRRA;
	
	@Getter@Setter
	private BigDecimal vlExclDespAJud;
	
	@Getter@Setter
	private BigDecimal vlDedContrPrev;
	
	@Getter@Setter
	private BigDecimal vlDedPensaoAli;
	
	@Getter@Setter
	private BigDecimal vlImpSobreRendaRetFonte;
	
	@Getter@Setter
	private BigDecimal vlRendIsentoPensao;
	
	@Getter@Setter
	private BigDecimal vlLucrosDiv;

	public DirfDTO(Dirf dirf) {
		this.id = dirf.getId();
		this.empresa = dirf.getEmpresa();
		this.endereco = dirf.getEndereco();
		this.cidade = dirf.getCidade();
		this.uf = dirf.getUf();
		this.cpf = dirf.getCpf();
		this.nome = dirf.getNome();
		this.codigoNucleo = dirf.getCodigoNucleo();
		this.nomeNucleo = dirf.getNomeNucleo();
		this.natureza = dirf.getNatureza();
		this.valorRenda = dirf.getValorRenda();
		this.previrio = dirf.getPrevirio();
		this.valorPensaoAlimenticia = dirf.getValorPensaoAlimenticia();
		this.valorImpostoRetido = dirf.getValorImpostoRetido();
		this.valorSalarioFamilia = dirf.getValorSalarioFamilia();
		this.valorProventosReserva = dirf.getValorProventosReserva();
		this.valorDiarias = dirf.getValorDiarias();
		this.valorProventosAposentados = dirf.getValorProventosAposentados();
		this.valorDecimoTerceiroSalario = dirf.getValorDecimoTerceiroSalario();
		this.valorImpostoRendaDecimoTerceiroSalario = dirf.getValorImpostoRendaDecimoTerceiroSalario();
		this.valorOutros = dirf.getValorOutros();
		this.dataEmissao = dirf.getDataEmissao();
		this.anoBase = dirf.getAnoBase();
		this.observacao = dirf.getObservacao();
		this.situacao = dirf.getSituacao();
		this.valorRescisao = dirf.getValorRescisao();

		this.nrProcesso = dirf.getNrProcesso();
		this.qtdMeses = dirf.getQtdMeses();
		this.natRend = dirf.getNatRend();
		this.vlTotRendRRA = dirf.getVlTotRendRRA();
		this.vlExclDespAJud = dirf.getVlExclDespAJud();
		this.vlDedContrPrev = dirf.getVlDedContrPrev();
		this.vlDedPensaoAli = dirf.getVlDedPensaoAli();
		this.vlImpSobreRendaRetFonte = dirf.getVlImpSobreRendaRetFonte();
		this.vlRendIsentoPensao = dirf.getVlRendIsentoPensao();
		this.vlLucrosDiv = dirf.getVlLucrosDiv();
	}

}

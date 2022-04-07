package rio.iplan.contracheque.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="DIRF")
public class Dirf implements Serializable{
    
	@Getter@Setter
	@Column(name = "ID")
	@Id
	private Long id;

	@Getter@Setter
	@ManyToOne
	@JoinColumn(name = "COD_EMPRESA")
	private Empresa empresa;
	
	@Getter@Setter
	@Column(name = "ENDERECO")
	private String endereco;

	@Getter@Setter
	@Column(name = "CIDADE")
	private String cidade;

	@Getter@Setter
	@Column(name = "UF")
	private String uf;

	@Getter@Setter
	@Column(name = "MATRICULA")
	private String matricula;

	@Getter@Setter
	@Column(name = "CPF")
	private Long cpf;

	@Getter@Setter
	@Column(name = "NOME_SERVIDOR")
	private String nome;

	@Getter@Setter
	@Column(name = "CD_NUCLEO")
	private String codigoNucleo;
	
	@Getter@Setter
	@Column(name = "NM_NUCLEO")
	private String nomeNucleo;

	@Getter@Setter
	@Column(name = "NATUREZA")
	private String natureza;
	
	@Getter@Setter
	@Column(name = "VL_RENDA")
	private BigDecimal valorRenda;

	@Getter@Setter
	@Column(name = "PREVIRIO")
	private String previrio;

	@Getter@Setter
	@Column(name = "VL_PENSAO_ALIMENTICIA")
	private BigDecimal valorPensaoAlimenticia;

	@Getter@Setter
	@Column(name = "VL_IMPOSTO_RETIDO")
	private BigDecimal valorImpostoRetido;

	@Getter@Setter
	@Column(name = "VL_SALARIO_FAMILIA")
	private BigDecimal valorSalarioFamilia;

	@Getter@Setter
	@Column(name = "VL_PROVENTOS_RESERVA")
	private BigDecimal valorProventosReserva;

	@Getter@Setter
	@Column(name = "NR_DIARIAS")
	private BigDecimal valorDiarias;

	@Getter@Setter
	@Column(name = "VL_PROVENTOS_APOSENTADOS")
	private BigDecimal valorProventosAposentados;

	@Getter@Setter
	@Column(name = "VL_13_SALARIO")
	private BigDecimal valorDecimoTerceiroSalario;

	@Getter@Setter
	@Column(name = "VL_IR_13_SALARIO")
	private BigDecimal valorImpostoRendaDecimoTerceiroSalario;

	@Getter@Setter
	@Column(name = "VL_OUTROS")
	private BigDecimal valorOutros;

	@Getter@Setter
	@Column(name = "DT_EMISSAO")
	private Date dataEmissao;

	@Getter@Setter
	@Column(name = "ANO_BASE")
	private Long anoBase;

	@Getter@Setter
	@Column(name = "OBSERVACAO")
	private String observacao;

	@Getter@Setter
	@Column(name = "SITUACAO")
	private String situacao;

	@Getter@Setter
	@Column(name = "VL_IND_RESCISAO")
	private BigDecimal valorRescisao;
	
	@Getter@Setter
	@Column(name = "NR_PROCESSO")
	private String nrProcesso;
	
	@Getter@Setter
	@Column(name = "QTD_Meses")
	private String qtdMeses;
	
	@Getter@Setter
	@Column(name = "Nat_Rend")
	private String natRend;
	
	@Getter@Setter
	@Column(name = "VL_Tot_Rend_RRA")
	private BigDecimal vlTotRendRRA;
	
	@Getter@Setter
	@Column(name = "VL_Excl_Desp_a_Jud")
	private BigDecimal vlExclDespAJud;
	
	@Getter@Setter
	@Column(name = "VL_DedContr_Prev")
	private BigDecimal vlDedContrPrev;
	
	@Getter@Setter
	@Column(name = "VL_Ded_Pensao_Ali")
	private BigDecimal vlDedPensaoAli;
	
	@Getter@Setter
	@Column(name = "VL_Imp_Sobre_Renda_Ret_Fonte")
	private BigDecimal vlImpSobreRendaRetFonte;
	
	@Getter@Setter
	@Column(name = "VL_Rend_Isento_Pensao")
	private BigDecimal vlRendIsentoPensao;
	
	@Getter@Setter
	@Column(name = "VL_Lucros_Div")
	private BigDecimal vlLucrosDiv;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anoBase == null) ? 0 : anoBase.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dirf other = (Dirf) obj;
		if (anoBase == null) {
			if (other.anoBase != null)
				return false;
		} else if (!anoBase.equals(other.anoBase))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		return true;
	}

	@Override
    public String toString() {
        return "Dirf [id=" + id + ", empresa=" + empresa + ", matricula="
                + matricula + ", cpf=" + cpf + ", Nome=" + nome
                + ", nomeNucleo=" + nomeNucleo + ", natureza=" + natureza
                + ", valorRenda=" + valorRenda + ", previrio=" + previrio
                + ", valorPensaoAlimenticia=" + valorPensaoAlimenticia
                + ", valorImpostoRetido=" + valorImpostoRetido
                + ", valorSalarioFamilia=" + valorSalarioFamilia
                + ", valorProventosReserva=" + valorProventosReserva
                + ", valorDiarias=" + valorDiarias
                + ", valorProventosAposentados=" + valorProventosAposentados
                + ", valorDecimoTerceiroSalario=" + valorDecimoTerceiroSalario
                + ", valorImpostoRendaDecimoTerceiroSalario="
                + valorImpostoRendaDecimoTerceiroSalario + ", valorOutros="
                + valorOutros + ", anoBase=" + anoBase + ", situacao="
                + situacao + ", valorRescisao=" + valorRescisao + "]";
    }


}

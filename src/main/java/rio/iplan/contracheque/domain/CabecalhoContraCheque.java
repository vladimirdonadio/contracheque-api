package rio.iplan.contracheque.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="VW_CONTRA_CHEQUE_CABECALHO")
public class CabecalhoContraCheque implements Serializable {

	@Id
	@Getter@Setter
	@Column(name="ID")
	private Long id;

	@Getter@Setter
	@Column(name="NUMFUNC")
	private Long numeroFuncionario;

	@Getter@Setter
	@Column(name="NOME")
	private String nome;

	@Getter@Setter
	@Column(name="MATRIC")
	private String matricula;

	@Getter@Setter
	@Column(name="PISPASEP")
	private Long pisPasep;

	@Getter@Setter
	@Column(name="TIPO_FOLHA")
	private String tipoFolha;

	@Getter@Setter
	@Column(name="MES_ANO")
	private String mesAno;

	@Getter@Setter
	@Column(name="BANCO")
	private String banco;

	@Getter@Setter
	@Column(name="AGENCIA")
	private String agencia;

	@Getter@Setter
	@Column(name="CONTA")
	private String conta;

	@Getter@Setter
	@Column(name="RAZAO")
	private String razao;

	@Setter@Getter
	@Column(name="DATA_NASC")
	private Date dataNascimento;

	@Getter@Setter
	@Column(name="CT_NR")
	private String numeroCarteiraTrabalho;

	@Getter@Setter
	@Column(name="CT_Serie")
	private String serieCarteiraTrabalho;

	@Getter@Setter
	@Column(name="CT_UF")
	private String ufCarteiraTrabalho;

	@Setter@Getter
	@Column(name="DATA_ADM")
	private Date dataAdmissao;

	@Getter@Setter
	@Column(name="NIVEL")
	private String nivel;

	@Getter@Setter
	@Column(name="CARGO_COD")
	private String codigoCargo;

	@Getter@Setter
	@Column(name="CARGO_DESC")
	private String descricaoCargo;

	@Getter@Setter
	@Column(name="TIPO_CC")
	@Enumerated(EnumType.STRING)
	private EnumTipoContraCheque tipoContracheque;

	@Getter@Setter
	@Column(name="LOTACAO")
	private String lotacao;

	@Getter@Setter
	@Column(name="CNPJ")
	private String cnpj;

	@Getter@Setter
	@Column(name="SIGLA_UA")
	private String sigla_UA;

	@Getter@Setter
	@Column(name="ND")
	private Long numeroDoDependente;
	
	@Getter@Setter
	@Column(name="DP_IN")
	private Long dp_in;
	
	@Getter@Setter
	@Column(name="DP_IR")
	private Long dp_ir;

	@Getter@Setter
	@Column(name="DP_SF")
	private Long dp_sf;

	@Getter@Setter
	@Column(name="PREFIXO")
	private String prefixo;

	@Getter@Setter
	@Column(name="REGIME_JURIDICO")
	private String regimeJuridico;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		CabecalhoContraCheque other = (CabecalhoContraCheque) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CabecalhoContraCheque [id=" + id + ", numeroFuncionario="
				+ numeroFuncionario + ", nome=" + nome + ", matricula="
				+ matricula + ", pisPasep=" + pisPasep + ", tipoFolha="
				+ tipoFolha + ", mesAno=" + mesAno + "]";
	}

}
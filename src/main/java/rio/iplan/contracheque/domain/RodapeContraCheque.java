package rio.iplan.contracheque.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="VW_CONTRA_CHEQUE_RODAPE")
public class RodapeContraCheque implements Serializable {
	
	@Id
	@Getter@Setter
	@Column(name="ID")
	private Long id;
	
	@Getter@Setter
	@Column(name="IDFOLHA")
	private Long idFolha;

	@Getter@Setter
	@Column(name="NOMERUBRICA")
	private String nomeRubrica;

	@Getter@Setter
	@Column(name="VALOR")
	private BigDecimal valor;
	
	@Getter@Setter
	@Column(name="NUMFUNC")
	private Long numeroFuncionario;
	
	@Getter@Setter
	@Column(name="RUBRICA")
	private Long rubrica;

	public RodapeContraCheque() {
	}
	
	public RodapeContraCheque(Long id, Long idFolha, String nomeRubrica,
			BigDecimal valor, Long numeroFuncionario, Long rubrica) {
		this.id = id;
		this.idFolha = idFolha;
		this.nomeRubrica = nomeRubrica;
		this.valor = valor;
		this.numeroFuncionario = numeroFuncionario;
		this.rubrica = rubrica;
	}
	
	@Override
	public String toString() {
		return "RodapeContraCheque [id=" + id + ", rubrica=" + rubrica
				+ ", valor=" + valor + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idFolha == null) ? 0 : idFolha.hashCode());
		result = prime * result + ((rubrica == null) ? 0 : rubrica.hashCode());
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
		RodapeContraCheque other = (RodapeContraCheque) obj;
		if (idFolha == null) {
			if (other.idFolha != null)
				return false;
		} else if (!idFolha.equals(other.idFolha))
			return false;
		if (rubrica == null) {
			if (other.rubrica != null)
				return false;
		} else if (!rubrica.equals(other.rubrica))
			return false;
		return true;
	}

}
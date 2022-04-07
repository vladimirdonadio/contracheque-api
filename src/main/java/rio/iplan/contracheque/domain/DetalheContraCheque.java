package rio.iplan.contracheque.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="VW_CONTRA_CHEQUE_DETALHE")
public class DetalheContraCheque implements Serializable {

	@Id
	@Getter@Setter
	@Column(name="ID")
	private Long id;

	@Column(name="NUMFUNC")
	@Getter@Setter
	private Long numeroFuncionario;

	@Column(name="IDFOLHA")
	@Getter@Setter
	private Long idFolha;

	@Column(name="VERBA")
	@Getter@Setter
	private Long verba;

	@Getter@Setter
	@Column(name="DESCRICAO")
	private String descricao; 

	@Getter@Setter
	@Column(name="PROVENTOS")
	private String provento;

	@Getter@Setter
	@Column(name="DESCONTOS")
	private String desconto;

	@Getter@Setter
	@Column(name="FREQUENCIA")
	private String frequencia;

	@Getter@Setter
	@Column(name="VEZES")
	private String vezes;

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
		DetalheContraCheque other = (DetalheContraCheque) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DetalheContraCheque [id=" + id + ", numeroFuncionario="
				+ numeroFuncionario + ", idFolha=" + idFolha + ", verba="
				+ verba + ", descricao=" + descricao + ", provento=" + provento
				+ ", desconto=" + desconto + "]";
	}

}
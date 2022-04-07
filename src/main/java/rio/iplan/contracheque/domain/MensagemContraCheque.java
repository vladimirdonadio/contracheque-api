package rio.iplan.contracheque.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="WEB_MENSAGEM_CC")
public class MensagemContraCheque {

	@Id
	@Getter@Setter
	@Column(name="ID")
	private Long id;

	@Getter@Setter
	@Column(name="IDFOLHA")
	private Long idFolha;

	@Getter@Setter
	@Column(name="MENSAGEM")
	private String texto;

	@Override
	public String toString() {
		return "MensagemContraCheque [id=" + id + ", idFolha=" + idFolha
				+ ", texto=" + texto + "]";
	}

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
		MensagemContraCheque other = (MensagemContraCheque) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}
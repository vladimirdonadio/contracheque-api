package rio.iplan.contracheque.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="EMPRESAS")
public class Empresa implements Serializable{
    
	@Getter@Setter
	@Column(name="COD_EMPRESA")
	@Id
	private Long id;

	@Getter@Setter
	@Column(name="FANTASIA")
	private String nomeFantasia;
	
	@Getter@Setter
	@Column(name="RAZAO")
	private String razaoSocial;
	
	@Getter@Setter
	@Column(name="CGC")
	private String cgc;

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
		Empresa other = (Empresa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Empresa [cÃ³digo=" + id + ", nomeFantasia=" + nomeFantasia
				+ ", razaoSocial=" + razaoSocial + ", cgc=" + cgc + "]";
	}

}

package rio.iplan.contracheque.domain.vo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class MesContraChequeVO implements Serializable{

    private static final long serialVersionUID = 1L;
	
	@Getter@Setter
	private Long id;

	@Getter@Setter
	private String matricula;

	@Getter@Setter
	private String mesAno;

	@Getter@Setter
	private String folha;
	
	@Getter@Setter
	private Long numeroFuncionario;

	@Getter@Setter
	private String empresa;

	public MesContraChequeVO(Long id,
							 String matricula,
							 String mesAno,
							 String folha,
							 Long numeroFuncionario,
							 String empresa,
							 String anoMes) {
		this.id = id;
		this.matricula = matricula;
		this.mesAno = mesAno;
		this.folha = folha;
		this.numeroFuncionario = numeroFuncionario;
		this.empresa = empresa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((folha == null) ? 0 : folha.hashCode());
		result = prime * result
				+ ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((mesAno == null) ? 0 : mesAno.hashCode());
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
		MesContraChequeVO other = (MesContraChequeVO) obj;
		if (folha == null) {
			if (other.folha != null)
				return false;
		} else if (!folha.equals(other.folha))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (mesAno == null) {
			if (other.mesAno != null)
				return false;
		} else if (!mesAno.equals(other.mesAno))
			return false;
		return true;
	}

	public String getAnoMes() {
		return this.mesAno.substring(3) + this.mesAno.substring(0, 2);
	}

	@Override
	public String toString() {
		return "MesContraChequeVO [matricula=" + matricula + ", mesAno="
				+ mesAno + ", folha=" + folha + ", numeroFuncionario="
				+ numeroFuncionario + ", empresa=" + empresa + "]";
	}

}

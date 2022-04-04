package rio.iplan.contracheque.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class FuncionarioPK implements Serializable {

    @Column(name="CPF")
    private String cpf;
    
    @Column(name="MATRICULA_FORM")
    private String matriculaFormatada;
    
    public FuncionarioPK() {
    }

    public FuncionarioPK(String cpf, String matriculaFormatada) {
        super();
        this.setCpf(cpf);
        this.setMatriculaFormatada(matriculaFormatada);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCpf() == null) ? 0 : getCpf().hashCode());
        result = prime * result + ((getMatriculaFormatada() == null) ? 0 : getMatriculaFormatada().hashCode());
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
        FuncionarioPK other = (FuncionarioPK) obj;
        if (getCpf() == null) {
            if (other.getCpf() != null)
                return false;
        } else if (!getCpf().equals(other.getCpf()))
            return false;
        if (getMatriculaFormatada() == null) {
            if (other.getMatriculaFormatada() != null)
                return false;
        } else if (!getMatriculaFormatada().equals(other.getMatriculaFormatada()))
            return false;
        return true;
    }

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getMatriculaFormatada() {
		return matriculaFormatada;
	}

	public void setMatriculaFormatada(String matriculaFormatada) {
		this.matriculaFormatada = matriculaFormatada;
	}
}
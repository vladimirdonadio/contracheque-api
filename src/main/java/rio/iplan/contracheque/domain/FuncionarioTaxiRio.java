package rio.iplan.contracheque.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TAXIRIO")
public class FuncionarioTaxiRio {

	@EmbeddedId
    private FuncionarioPK funcionarioPK;

    @Column(name="MATRICULA")
    private Long matricula;
    
    @Column(name="COD_SETOR")
    private String codigoSetor;
    
    @Column(name="SETOR")
    private String setor;
    
    @Column(name="NOME")
    private String nome;
    
    @Column(name="DATA_CARGA")
    private Date dataCarga;

    public FuncionarioPK getFuncionarioPK() {
		return funcionarioPK;
	}

	public void setFuncionarioPK(FuncionarioPK funcionarioPK) {
		this.funcionarioPK = funcionarioPK;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getCodigoSetor() {
		return codigoSetor;
	}

	public void setCodigoSetor(String codigoSetor) {
		this.codigoSetor = codigoSetor;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataCarga() {
		return dataCarga;
	}

	public void setDataCarga(Date dataCarga) {
		this.dataCarga = dataCarga;
	}

    @Override
    public String toString() {
        return "Funcionario [funcionarioPK=" + funcionarioPK + ", matricula=" + matricula + ", codigoSetor="
                + codigoSetor + ", setor=" + setor + ", nome=" + nome + ", dataCarga=" + dataCarga + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((funcionarioPK == null) ? 0 : funcionarioPK.hashCode());
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
        FuncionarioTaxiRio other = (FuncionarioTaxiRio) obj;
        if (funcionarioPK == null) {
            if (other.funcionarioPK != null)
                return false;
        } else if (!funcionarioPK.equals(other.funcionarioPK))
            return false;
        return true;
    }

}
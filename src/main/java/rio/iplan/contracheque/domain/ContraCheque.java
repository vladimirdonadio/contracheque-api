package rio.iplan.contracheque.domain;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="VW_CONTRA_CHEQUES")
public class ContraCheque implements Serializable{
	@Getter@Setter
	@Column(name="ID")
	@Id
	private Long id;

	@Getter@Setter
	@Column(name="MATRICULA")
	private String matricula;

	@Getter@Setter
	@Column(name="NUMFUNC")
	private Long numeroFuncionario;
	
	@Getter@Setter
	@Column(name="MES_ANO")
	private String mesAno;

	@Getter@Setter
	@Column(name="FOLHA")
	private String folha;

	@Getter@Setter
	@Column(name="CPF")
	private Long cpf;

	@Getter@Setter
	@Column(name="EMPRESA")
	private String empresa;

	@Getter@Setter
	@OneToOne
	@JoinColumn(name = "ID", referencedColumnName = "ID")
	private CabecalhoContraCheque cabecalho;

	@Getter@Setter
	@OneToMany
	@JoinColumn(name = "IDFOLHA")
	private Set<MensagemContraCheque> mensagem = new HashSet<>();

	@Getter@Setter
	@OneToMany
	@JoinColumn(name = "IDFOLHA")
	private Set<RodapeContraCheque> rodape = new HashSet<>();

	@Setter@Getter
	@OneToMany
	@JoinColumn(name = "IDFOLHA")
	private Set<DetalheContraCheque> detalhe = new HashSet<>();

    public String obterSalarioBruto() {
    	
    	if(this.rodape==null){
    		return String.valueOf(0);
    	}
    	
    	DecimalFormat df = new DecimalFormat("#,###.00");
    	
    	Long rubricaSalarioBruto = 996L;
    	
    	for (RodapeContraCheque rodape : this.rodape) {
			
    		if(rodape.getRubrica().equals(rubricaSalarioBruto)){
    			
    			return df.format(rodape.getValor());
    		} 
    		
		}
		
    	return String.valueOf(0);
    }
    
    public String obterSalarioLiquido() {
    	
    	if(this.rodape==null){
    		return String.valueOf(0);
    	}
    	
    	DecimalFormat df = new DecimalFormat("#,###.00");
    	
    	Long rubricaSalarioLiquido = 999L;
    	
    	for (RodapeContraCheque rodape : this.rodape) {
			
    		if(rodape.getRubrica().equals(rubricaSalarioLiquido)){
    			
    			return df.format(rodape.getValor());
    		} 
    		
		}
		
    	return String.valueOf(0);
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
		ContraCheque other = (ContraCheque) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ContraCheque [id=" + id + ", matricula=" + matricula
				+ ", numeroFuncionario=" + numeroFuncionario + ", mesAno="
				+ mesAno + ", folha=" + folha + ", cpf=" + cpf + ", cabecalho="
				+ cabecalho + ", rodape=" + rodape + ", detalhe=" + getDetalhe()
				+ "]";
	}
    
}

package rio.iplan.contracheque.domain;

import lombok.Getter;

public enum EnumTipoContraCheque {
	
	D("Direta"), I("Indireta");

	@Getter
	private String label;

	private EnumTipoContraCheque(String label) {
		this.label = label;
	}

}
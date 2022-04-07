package rio.iplan.contracheque.domain.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import rio.iplan.contracheque.domain.vo.MesContraChequeVO;

public class ListaMesesDTO {
 
    @Getter@Setter
	private List<MesContraChequeVO> mes = new ArrayList<MesContraChequeVO>();

}

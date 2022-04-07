package rio.iplan.contracheque.api;

import java.util.HashMap;
import java.util.Map;

public class TokenValidator {

	public static void validarToken(String token) throws TokenInvalidoException {

		Map<String, String> tokens = new HashMap<String, String>();

		tokens.put("7fec5f3d0db42b75411f20e971f60ebb", "Carioca Digital");

		if (!tokens.containsKey(token)){
			throw new TokenInvalidoException("Token inválido!");
		}
		
	}
    
}

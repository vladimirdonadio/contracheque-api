package rio.iplan.contracheque.api;

public class TokenInvalidoException extends Exception{

	private static final long serialVersionUID = 1L;

	public TokenInvalidoException(String mensagem){
		
		super(mensagem);
		
	}
    
}

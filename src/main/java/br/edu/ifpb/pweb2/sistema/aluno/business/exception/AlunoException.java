package br.edu.ifpb.pweb2.sistema.aluno.business.exception;

public class AlunoException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public AlunoException () {
		super();
	}
	
	public AlunoException (String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}
	
	public AlunoException (String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
	
	public AlunoException (String arg0) {
		super(arg0);
	}
	
	public AlunoException(Throwable arg0) {
		super(arg0);
	}
	
	
	
	

}

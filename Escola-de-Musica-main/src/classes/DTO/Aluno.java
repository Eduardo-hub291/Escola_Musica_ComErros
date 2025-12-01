package classes.DTO;

import java.sql.Date;

public class Aluno extends Unico{

	public Aluno(String cpf, String nome, Date nasc) {
		super(cpf, nome, nasc);		
	//fazer o consultar horarios
	}

	  public String getCpf() {
	        return super.getCpf();
	    }
	
}

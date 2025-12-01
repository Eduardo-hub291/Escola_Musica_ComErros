package classes.DTO;

public class TESTES {

	public static void main(String[] args) {

		Aluno aluno = new Aluno("13286819980", "eduardo", null);
		
		Matricula matricula = new Matricula(aluno, "834753485", 0, 0, null, null);
		
		System.out.println(matricula.toString());
		
		
	}

}

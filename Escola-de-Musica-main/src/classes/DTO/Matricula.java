package classes.DTO;

import java.sql.Date;

public class Matricula {

	private String Aluno_CPF, Professor_CPF;
	private int idTipo, SalaPreferencial;
	private Date Horario, HorarioFim;
	
	
    public Matricula(Aluno aluno, String professorCPF, int idTipo, int salaPreferencial, Date horario, Date horarioFim) {
        this.Aluno_CPF = aluno.getCpf(); 
        this.Professor_CPF = professorCPF;
        this.idTipo = idTipo;
//        this.SalaPreferencial = salaPreferencial;
        this.Horario = horario;
        this.HorarioFim = horarioFim;
    }
	
	
	public String getAluno_CPF() {
		return Aluno_CPF;
	}
	public void setAluno_CPF(String aluno_CPF) {
		Aluno_CPF = aluno_CPF;
	}
	public String getProfessor_CPF() {
		return Professor_CPF;
	}
	public void setProfessor_CPF(String professor_CPF) {
		Professor_CPF = professor_CPF;
	}
	public int getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	public int getSalaPreferencial() {
		return SalaPreferencial;
	}
	public void setSalaPreferencial(int salaPreferencial) {
		SalaPreferencial = salaPreferencial;
	}
	public Date getHorario() {
		return Horario;
	}
	public void setHorario(Date horario) {
		Horario = horario;
	}
	public Date getHorarioFim() {
		return HorarioFim;
	}
	public void setHorarioFim(Date horarioFim) {
		HorarioFim = horarioFim;
	}	
	
	
	
	//CRIAR MÉTODO GERAR MENSALIDADE
}	

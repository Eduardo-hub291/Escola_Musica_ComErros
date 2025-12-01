package classes.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import classes.Conexao.Conexao;
import classes.DTO.Matricula;

public class MatriculaDAO {
	
	 final String NOMEDATABELA = "Matricula";
	    
	    public boolean inserir(Matricula matricula) { 
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "INSERT INTO " + NOMEDATABELA + " (ALUNO_CPF,PROFESSOR_CPF,ID_TIPO,SALA_PREFERENCIAL,HORARIO,HORARIO_FIM) VALUES (?,?,?,?,?,?);";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, matricula.getAluno_CPF()); 
	            ps.setString(2, matricula.getProfessor_CPF());
	            ps.setInt(3, matricula.getIdTipo());
	            ps.setInt(4, matricula.getSalaPreferencial());
	            ps.setDate(5, matricula.getHorario());
	            ps.setDate(6, matricula.getHorarioFim());
	            ps.executeUpdate();
	            ps.close();
	            conn.close();
	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	    public boolean alterar(Matricula matricula) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "UPDATE " + NOMEDATABELA + " SET ALUNO_CPF = ?, PROFESSOR_CPF= ?, ID_TIPO= ?,SALA_PREFERENCIAL= ?, HORARIO = ?, HORARIO_FIM = ? WHERE ALUNO_CPF = ? AND PROFESSOR_CPF = ? AND ID_TIPO = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, matricula.getAluno_CPF());
	            ps.setString(2, matricula.getProfessor_CPF());
	            ps.setInt(3, matricula.getIdTipo());
	            ps.setInt(4, matricula.getSalaPreferencial());
	            ps.setDate(5, matricula.getHorario());
	            ps.setDate(6, matricula.getHorarioFim());
	            ps.executeUpdate();
	            ps.close();
	            conn.close();
	            return true;
	        } catch (Exception e) {
	        	 e.printStackTrace();
	             return false;
	        }
	    }
	    public boolean excluir(Matricula matricula) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE ALUNO_CPF = ? AND PROFESSOR_CPF = ? AND ID_TIPO = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(3, matricula.getIdTipo());
	            ps.executeUpdate();
	            ps.close();
	            conn.close();
	            return true;
	        } catch (Exception e) {
	        	 e.printStackTrace();
	             return false;
	        }
	    }
	    public Matricula procurarPorCodigo(Matricula matricula) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE ALUNO_CPF = ? AND PROFESSOR_CPF = ? AND ID_TIPO = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(3, matricula.getIdTipo());
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	            	Matricula obj = new Matricula(rs.getString(1), rs.getString(2), rs.getDate(5));
	                obj.setAluno_CPF(rs.getString(3));
	                obj.setProfessor_CPF(rs.getString(4));
	                obj.setIdTipo(rs.getInt(5));
	                obj.setSalaPreferencial(rs.getInt(6));
	                obj.setHorario(rs.getDate(7));
	                obj.setHorarioFim(rs.getDate(8));
	                ps.close();
	                rs.close();
	                conn.close();
	                return obj;
	            } else {
	                ps.close();
	                rs.close();
	                conn.close();
	                return null;
	            }
	        } catch (Exception e) {
	        	 e.printStackTrace();
	             return null;
	        }
	    }
//	    public Matricula procurarPorNome(Matricula matricula) {
//	        try {
//	            Connection conn = Conexao.conectar();
//	            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE nome = ?;";
//	            PreparedStatement ps = conn.prepareStatement(sql);
//	            ps.setString(1, unico.getNome());
//	            ResultSet rs = ps.executeQuery();
//	            if (rs.next()) {
//	                Unico obj = new Unico(rs.getString(1), rs.getString(2), rs.getDate(5));
//	                obj.setTelefone(rs.getString(3));
//	                obj.setEmail(rs.getString(4));
//	                ps.close();
//	                rs.close();
//	                conn.close();
//	                return obj;
//	            } else {
//	                ps.close();
//	                rs.close();
//	                conn.close();
//	                return null;
//	            }
//	        } catch (Exception e) {
//	        	 e.printStackTrace();
//	             return null;
//	        }
//	    }
	    public boolean existe(Matricula matricula) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE ALUNO_CPF = ? AND PROFESSOR_CPF = ? AND ID_TIPO = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, matricula.getIdTipo());
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                ps.close();
	                rs.close();
	                conn.close();
	                return true;
	            }
	        } catch (Exception e) {
	           e.printStackTrace();
	            return false;
	        }
	        return false;
	    }
	    public List<Matricula> pesquisarTodos() {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            List<Matricula> listObj = montarLista(rs);  
	            return listObj;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	    public List<Matricula> montarLista(ResultSet rs) {
	        List<Matricula> listObj = new ArrayList<Matricula>();
	        try {
	            while (rs.next()) {
	            	Matricula obj = new Matricula(rs.getString(1), rs.getString(2), rs.getDate(5));
	                obj.setAluno_CPF(rs.getString(3));
	                obj.setProfessor_CPF(rs.getString(4));
	                obj.setIdTipo(rs.getInt(5));
	                obj.setSalaPreferencial(rs.getInt(6));
	                obj.setHorario(rs.getDate(7));
	                obj.setHorarioFim(rs.getDate(8));
	                listObj.add(obj);
	            }
	            return listObj;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
}

package classes.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import classes.Conexao.Conexao;
import classes.DTO.Sala;

public class SalaDAO {
    final String NOMEDATABELA = "Sala";
    
    public boolean inserir(Sala sala) {  //colocar sempre o objeto que ta sendo feito
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (NumeroSala) VALUES (?);"; //seta o SQL q vai rodar no banco. Lembrar de sempre mudar os campos no SQL
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, sala.getNumeroSala()); //substitui os ? no SQL. o numero fala qual o ? que vai pegar em ordem que aparace no texto
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean alterar(Sala sala) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "UPDATE " + NOMEDATABELA + " WHERE NumeroSala = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, sala.getNumeroSala());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
        	 e.printStackTrace();
             return false;
        }
    }
    public boolean excluir(Sala sala) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE NumeroSala = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Sala.getNumeroSala());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
        	 e.printStackTrace();
             return false;
        }
    }
    
    public boolean existe(Sala sala) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE NumeroSala = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Sala.getNumeroSala());
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
    public List<Sala> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Sala> listObj = montarLista(rs);  //mesma coisa do "procura por nome"  mas retorna uma lista. 
            return listObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

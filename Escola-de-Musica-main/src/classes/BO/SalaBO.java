package classes.BO;

import java.util.List;

import classes.DAO.SalaDAO;
import classes.DTO.Sala;

public class SalaBO {
	  public boolean inserir(Sala sala){
	        if (existe(sala) != true) {
	        	SalaDAO marcasDAO = new SalaDAO();
	            return marcasDAO.inserir(sala);
	        }
	        return false;
	    }
	    public boolean alterar(Sala sala){
	    	SalaDAO marcasDAO = new SalaDAO();
	        return marcasDAO.alterar(sala);
	    }
	    public boolean excluir(Sala sala){
	    	SalaDAO marcasDAO = new SalaDAO();
	        return marcasDAO.excluir(sala);
	    }

	    public boolean existe(Sala sala){
	    	SalaDAO marcasDAO = new SalaDAO();
	        return marcasDAO.existe(sala);
	    }
	    public List<Sala> pesquisarTodos(){
	    	SalaDAO marcasDAO = new SalaDAO();
	        return marcasDAO.pesquisarTodos();
	    }
}

package ec.edu.ups.ppw.ProyectoFinal.bussines;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.ppw.ProyectoFinal.dao.FormularioDAO;
import ec.edu.ups.ppw.ProyectoFinal.model.Formulario;

@Stateless
public class GestionFormularioON {

	@Inject
	private FormularioDAO formularioDAO;
	
	public void guardarFormulario(Formulario formulario) {
	
			formulario.setId(siguienteId());
			formularioDAO.insert(formulario);	
			System.out.println(formulario);
		
	}
	
	public int siguienteId() {
		
		List<Formulario> lista = formularioDAO.getList();
		if(lista.isEmpty()) {
			return 0;
		}else {
		
			return lista.get(lista.size()-1).getId()+1;
			
		}
		
		
	}
	
	public List<Formulario> listar(){
		
		return formularioDAO.getList();
		
	}
	
}

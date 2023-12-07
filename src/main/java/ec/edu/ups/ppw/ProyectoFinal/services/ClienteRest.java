package ec.edu.ups.ppw.ProyectoFinal.services;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ec.edu.ups.ppw.ProyectoFinal.bussines.GestionFormularioON;
import ec.edu.ups.ppw.ProyectoFinal.model.Formulario;

@Path("cliente")
public class ClienteRest {

	@Inject
	private GestionFormularioON forON;
	
	@POST
	@Path("formulario")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Respuesta crearFormulario(Formulario formulario) {
		
		Respuesta res = new Respuesta();
		
		try{
			forON.guardarFormulario(formulario);
			res.setCodigo(1);
			res.setMensaje("Bien");
		}catch (Exception e) {
			res.setCodigo(99);
			res.setMensaje("Error al guardar");
		}
		return null;
	}
}

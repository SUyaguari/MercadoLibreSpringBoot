package ec.edu.ups.ppw.ProyectoFinal.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.ppw.ProyectoFinal.bussines.GestionFormularioON;
import ec.edu.ups.ppw.ProyectoFinal.model.Formulario;

@Named
@RequestScoped
public class FormularioBeans {

	@Inject 
	private GestionFormularioON gfON;
	
	private List<Formulario> formularios = new ArrayList<Formulario>();
	
	private Formulario formulario = new Formulario();
	
	@PostConstruct
	public void init() {
		formularios = gfON.listar();
	}

	public Formulario getFormulario() {
		return formulario;
	}

	public void setFormulario(Formulario formulario) {
		this.formulario = formulario;
	}

	public List<Formulario> getFormularios() {
		return formularios;
	}

	public void setFormularios(List<Formulario> formularios) {
		this.formularios = formularios;
	}
	
	public void guardar() {
		
		gfON.guardarFormulario(formulario);
		formulario = new Formulario();
		mensaje("PUERCO", "VAYASE A LA PORONGA");
		this.init();
	}

	public void mensaje(String summary, String detail) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail));
	}
	
}

package ec.edu.ups.ppw.ProyectoFinal.view;


import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ComprarProductoBeans implements Serializable{

	private int cont=1;

	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
		this.cont = cont;
	}
	
	public void sumar() {
		this.cont=this.cont+1;
		System.out.println(this.cont);
	}
	public void restar() {
		if(this.cont>1) {
			this.cont=this.cont-1;
		}
		System.out.println(cont);
	}
}

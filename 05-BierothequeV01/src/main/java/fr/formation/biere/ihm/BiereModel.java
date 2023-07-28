package fr.formation.biere.ihm;

import java.util.ArrayList;
import java.util.List;

import fr.formation.biere.bo.Biere;

public class BiereModel {
	private String message = "";
	private Biere current = new Biere();
	private List<Biere> lstBieres = new ArrayList<>();

	public BiereModel() {
	}

	public BiereModel(String message, Biere current, List<Biere> lstBieres) {
		super();
		this.message = message;
		this.current = current;
		this.lstBieres = lstBieres;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Biere getCurrent() {
		return current;
	}

	public void setCurrent(Biere current) {
		this.current = current;
	}

	public List<Biere> getLstBieres() {
		return lstBieres;
	}

	public void setLstBieres(List<Biere> lstBieres) {
		this.lstBieres = lstBieres;
	}

	@Override
	public String toString() {
		return "BiereModel [message=" + message + ", current=" + current + ", lstBieres=" + lstBieres + "]";
	}

}

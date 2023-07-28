package fr.formation.biere.ihm;

import java.util.ArrayList;
import java.util.List;

import fr.formation.biere.bo.Biere;

public class PanierModel {
	private String message = "";

	private List<Biere> lstBieres = new ArrayList<>();

	public PanierModel() {
	}

	public PanierModel(String message, List<Biere> lstBieres) {
		super();
		this.message = message;
		this.lstBieres = lstBieres;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Biere> getLstBieres() {
		return lstBieres;
	}

	public void setLstBieres(List<Biere> lstBieres) {
		this.lstBieres = lstBieres;
	}

}

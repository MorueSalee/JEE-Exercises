package fr.eni.ecole.ihm;

import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.bo.Sweet;

public class SweetModel {
	private Sweet current;
	private List<Sweet> sweetList = new ArrayList<>();
	private String message = "";
	
	public SweetModel() {
		super();
	}

	public SweetModel(Sweet current, List<Sweet> sweetList, String message) {
		super();
		this.current = current;
		this.sweetList = sweetList;
		this.message = message;
	}

	public Sweet getCurrent() {
		return current;
	}

	public void setCurrent(Sweet current) {
		this.current = current;
	}

	public List<Sweet> getSweetList() {
		return sweetList;
	}

	public void setSweetList(List<Sweet> sweetList) {
		this.sweetList = sweetList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}

package fr.eni.ecole.ihm;

public class PassionModelSing {
	private static PassionModel instance;
	public static PassionModel getInstance() {
		if(instance==null) {
			instance = new PassionModel();
		}
		return instance;
	}
}

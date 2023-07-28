package fr.eni.ecole.bo;

import java.util.List;

public class Person {
	
	private String name;
	private String surname;
	private String sex;
	private List<String> lstPassion;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public List<String> getLstPassion() {
		return lstPassion;
	}
	public void setLstPassion(List<String> lstPassion) {
		this.lstPassion = lstPassion;
	}
	
	public Person() {
	}
	
	public Person(String name, String surname, String sexe) {
		super();
		this.name = name;
		this.surname = surname;
		this.sex = sexe;
	}
	
	public Person(String name, String surname, String sex, List<String> lstPassion) {
		super();
		this.name = name;
		this.surname = surname;
		this.sex = sex;
		this.lstPassion = lstPassion;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", surname=" + surname + ", sex=" + sex + ", lstPassion=" + lstPassion + "]";
	}
}

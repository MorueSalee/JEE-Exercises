package fr.formation.biere.bo;

import java.util.Random;

public class Biere {
	private Integer id;
	private String nom;
	private String couleur;
	private String brasserie;
	private Double alcool;
	private String commentaire;
	private Integer note;
	private Double prix;
	

	public Biere() {
	}

	public Biere(String nom, String couleur, String brasserie, Double alcool, String commentaire, Integer note,
			Double prix) {
		super();
		this.nom = nom;
		this.couleur = couleur;
		this.brasserie = brasserie;
		this.alcool = alcool;
		this.commentaire = commentaire;
		this.note = note;
		this.prix = prix;
	}

	
	public Biere(Integer id, String nom, String couleur, String brasserie, Double alcool, String commentaire,
			Integer note, Double prix) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getBrasserie() {
		return brasserie;
	}

	public void setBrasserie(String brasserie) {
		this.brasserie = brasserie;
	}

	public Double getAlcool() {
		return alcool;
	}

	public void setAlcool(Double alcool) {
		this.alcool = alcool;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}


}

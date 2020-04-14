package com.mutex.selenium.testdata;

public class InfoCompte {
	private InfoCompte(String siret, String raisonSociale,String civilite, String nom,String prenom, String tel, String mail) {
		this.siret = siret;
		this.raisonSociale = raisonSociale;
		this.civilite = civilite;
		this.nom = nom;
		this.prenom=prenom;
		this.tel=tel;
		this.mail=mail;
		
				
	}

	private String siret;
	private String raisonSociale;
	private String civilite;
	private String nom;
	private String prenom;
	private String tel;
	private String mail;
	
	public static InfoCompte infoCompteNonDsn() {
		return new InfoCompte("69202823600028","SA SAINTE FOY","Madame","FORT","AUDE","0181800790","fodie.doucoure@mutex.fr");
	}
	
	
	
	
	
	public String getSiret() {
		return siret;
	}
	public String getRaisonSociale() {
		return raisonSociale;
	}
	public String getCivilite() {
		return civilite;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getTel() {
		return tel;
	}
	public String getMail() {
		return mail;
	}


	

}

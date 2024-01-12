package dades;
//Illya Kunakh
import java.time.LocalDate;

//No es pot crear directament l'objecte activitat, solament subclasses
public abstract class Activitats implements java.io.Serializable {
	
	protected String codi;
	protected String nom;
	protected String lloc;
	protected int codiPostal;
	protected LocalDate data;
	protected String nomEntitat;

	private static int numeroCodi = 100;
	
	public Activitats(String nom, String lloc, int codiPostal, LocalDate data, String nomEntitat) {
		this.nom = nom;
		this.lloc = lloc;
		this.codiPostal = codiPostal;
		this.data = data;
		this.nomEntitat = nomEntitat;

		//codi = tres primeres lletres + numero (ABC100)
		this.codi = nomEntitat.substring(0, 3).toUpperCase() + numeroCodi;
		numeroCodi++;
	}

	public String getCodi() {
		return codi;
	}

	public void setCodi(String codi) {
		this.codi = codi;
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getLloc() {
		return lloc;
	}
	
	public int getCodiPostal() {
		return codiPostal;
	}
	
	public LocalDate getData() {
		return data;
	}
	
	public String getNomEntitat() {
		return nomEntitat;
	}

	public String toString() {
		return "Codi: " + codi + "\nNom: " + nom + "\nLloc: " + lloc + "\nCodi Postal: " + codiPostal + "\nData: " + data + "\nNom Entitat: " + nomEntitat;
	}

	public abstract Activitats copia(); 
}
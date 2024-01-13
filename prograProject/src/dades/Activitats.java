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

	//La part numerica del codi comença per 100 i va incrementant
	private static int numeroCodi = 100;
	
	/**
	 * Constructor Activitats
	 * @param nom
	 * @param lloc
	 * @param codiPostal
	 * @param data
	 * @param nomEntitat
	 */
	public Activitats(String nom, String lloc, int codiPostal, LocalDate data, String nomEntitat) {
		this.nom = nom;
		this.lloc = lloc;
		this.codiPostal = codiPostal;
		this.data = data;
		this.nomEntitat = nomEntitat;

		//codi = tres primeres lletres + numero p.ex (ABC100)
		this.codi = nomEntitat.substring(0, 3).toUpperCase() + numeroCodi;
		numeroCodi++;
	}

	/**
	 * Getter codi
	 * @return codi
	 */
	public String getCodi() {
		return codi;
	}

	/**
	 * Setter codi
	 * @param codi
	 */
	public void setCodi(String codi) {
		this.codi = codi;
	}
	
	/**
	 * getter nom
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Getter lloc
	 * @return lloc
	 */
	public String getLloc() {
		return lloc;
	}
	
	/**
	 * Getter codiPostal
	 * @return codiPostal
	 */
	public int getCodiPostal() {
		return codiPostal;
	}
	
	/**
	 * Getter data
	 * @return data
	 */
	public LocalDate getData() {
		return data;
	}
	
	/**
	 * Getter nomEntitat
	 * @return nomEntitat
	 */
	public String getNomEntitat() {
		return nomEntitat;
	}

	/**
	 * toString 
	 * @return String atributs
	 */
	public String toString() {
		return "Codi: " + codi + "\nNom: " + nom + "\nLloc: " + lloc + "\nCodi Postal: " + codiPostal + "\nData: " + data + "\nNom Entitat: " + nomEntitat;
	}

	/**
	 * Definicio abstracta de copia perque les subclasses la implementin
	 */
	public abstract Activitats copia(); 
}
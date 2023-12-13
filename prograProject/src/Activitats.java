import java.util.Date;

public class Activitats {
	
	protected int codi;
	protected String nom;
	protected String lloc;
	protected int codiPostal;
	protected Date data;
	protected String nomEntitat;
	
	public Activitats(int codi, String nom, String lloc, int codiPostal, Date data, String nomEntitat) {
		this.codi = codi;
		this.nom = nom;
		this.lloc = lloc;
		this.codiPostal = codiPostal;
		this.data = data;
		this.nomEntitat = nomEntitat;
	}

	public int getCodi() {
		return codi;
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
	
	public Date getData() {
		return data;
	}
	
	public String getNomEntitat() {
		return nomEntitat;
	}
	
	public String toString() {
		return "Codi: " + codi + "\nNom: " + nom + "\nLloc: " + lloc + "\nCodi Postal: " + codiPostal + "\nData: " + data + "\nNom Entitat: " + nomEntitat;
	}
}

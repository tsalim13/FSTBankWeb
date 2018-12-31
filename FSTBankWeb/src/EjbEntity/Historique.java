package EjbEntity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Historique implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int id_compte;
	private double soldeAvant;
	private double soldeApres;
	private Date dateTransaction;
	
	private static final long serialVersionUID = 1L;

	public Historique() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSoldeAvant() {
		return soldeAvant;
	}

	public void setSoldeAvant(double soldeAvant) {
		this.soldeAvant = soldeAvant;
	}

	public double getSoldeApres() {
		return soldeApres;
	}

	public void setSoldeApres(double soldeApres) {
		this.soldeApres = soldeApres;
	}

	public Date getDateTransaction() {
		return dateTransaction;
	}

	public void setDateTransaction(Date dateTransaction) {
		this.dateTransaction = dateTransaction;
	}

   
}

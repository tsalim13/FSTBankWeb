package EjbEntity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Historique implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private double soldeTransaction;
	private double soldeTotal;
	private Date dateTransaction;
	
	private static final long serialVersionUID = 1L;

	public Historique() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getSoldeTransaction() {
		return soldeTransaction;
	}

	public void setSoldeTransaction(double soldeTransaction) {
		this.soldeTransaction = soldeTransaction;
	}

	public double getSoldeTotal() {
		return soldeTotal;
	}

	public void setSoldeTotal(double soldeTotal) {
		this.soldeTotal = soldeTotal;
	}

	public Date getDateTransaction() {
		return dateTransaction;
	}

	public void setDateTransaction(Date dateTransaction) {
		this.dateTransaction = dateTransaction;
	}

   
}

package EjbEntity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Historique implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int id_sender;
	private int id_receiver;
	private double trasanction_solde;
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

	public Date getDateTransaction() {
		return dateTransaction;
	}

	public void setDateTransaction(Date dateTransaction) {
		this.dateTransaction = dateTransaction;
	}

	public int getId_sender() {
		return id_sender;
	}

	public void setId_sender(int id_sender) {
		this.id_sender = id_sender;
	}

	public int getId_receiver() {
		return id_receiver;
	}

	public void setId_receiver(int id_receiver) {
		this.id_receiver = id_receiver;
	}

	public double getTrasanction_solde() {
		return trasanction_solde;
	}

	public void setTrasanction_solde(double trasanction_solde) {
		this.trasanction_solde = trasanction_solde;
	}

   
}

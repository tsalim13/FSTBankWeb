package EjbEntity;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.EJB;
import javax.persistence.*;

import EjbBean.ClientRemote;
import EjbBean.ComptePriveBean;
import EjbBean.HistBean;
import EjbBean.HistRemote;

@Entity
public class Historique implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String id_sender;
	private String id_receiver;
	private double trasanction_solde;
	private Date dateTransaction;
	
	private static final long serialVersionUID = 1L;
	
	//static ne sera pas persister (ne seras pas dans la bdd)
	@EJB
	private static HistRemote hist;
	
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

	

	public String getId_sender() {
		return id_sender;
	}

	public void setId_sender(String id_sender) {
		this.id_sender = id_sender;
	}

	public String getId_receiver() {
		return id_receiver;
	}

	public void setId_receiver(String id_receiver) {
		this.id_receiver = id_receiver;
	}

	public double getTrasanction_solde() {
		return trasanction_solde;
	}

	public void setTrasanction_solde(double trasanction_solde) {
		this.trasanction_solde = trasanction_solde;
	} 
}

package EjbEntity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
public class CParticulierPrive  implements Serializable  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Client client ;
	private double solde;
	private String codeIBN;
	private static final long serialVersionUID = 1L;

	public CParticulierPrive() {
		super();
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}

	public String getCodeIBN() {
		return codeIBN;
	}

	public void setCodeIBN(String codeIBN) {
		this.codeIBN = codeIBN;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
   
}

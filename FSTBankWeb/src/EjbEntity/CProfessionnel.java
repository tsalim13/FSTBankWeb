package EjbEntity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class CProfessionnel extends Compte implements Serializable {

	@ManyToOne
	protected Client client ;
	private double solde;
	private String codeIBN;
	
	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public CProfessionnel() {
		super();
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getCodeIBN() {
		return codeIBN;
	}

	public void setCodeIBN(String codeIBN) {
		this.codeIBN = codeIBN;
	}
	

}

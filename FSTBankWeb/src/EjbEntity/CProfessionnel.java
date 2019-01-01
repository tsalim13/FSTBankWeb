package EjbEntity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class CProfessionnel extends Compte implements Serializable {

	@ManyToOne
	protected Client client ;
	private double solde;
	
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

}

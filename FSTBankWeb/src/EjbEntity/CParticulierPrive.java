package EjbEntity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
public class CParticulierPrive extends Compte implements Serializable  {
	
	@ManyToOne
	private Client client ;
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
   
}

package EjbEntity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class CProfessionnel extends Compte implements Serializable {

	@ManyToOne
	protected Client client ;
	private static final long serialVersionUID = 1L;

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

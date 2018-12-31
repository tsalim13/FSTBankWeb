package EjbEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

import javax.persistence.*;

@Entity
public class CParticulierPartage extends Compte implements Serializable {

	@ManyToMany
	@JoinTable(name ="cpartager",
    joinColumns = { @JoinColumn(name = "cp_id") },
    inverseJoinColumns = { @JoinColumn(name = "client_id") })
	private Set<Client> clients;
	private static final long serialVersionUID = 1L;

	public CParticulierPartage() {
		super();
	}

	public Set<Client> getList() {
		return clients;
	}

	public void Set(Set<Client> clientsList) {
		this.clients = clientsList;
	}

}

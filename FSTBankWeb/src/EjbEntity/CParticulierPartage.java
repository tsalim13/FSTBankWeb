package EjbEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

import javax.persistence.*;

@Entity
public class CParticulierPartage  implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToMany
	@JoinTable(name ="cpartager",
    joinColumns = { @JoinColumn(name = "cp_id") },
    inverseJoinColumns = { @JoinColumn(name = "client_id") })
	private Set<Client> clients;
	private double solde;
	private String codeIBN;

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public CParticulierPartage() {
		super();
	}

	public Set<Client> getList() {
		return clients;
	}

	public void Set(Set<Client> clientsList) {
		this.clients = clientsList;
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

package EjbBean;

import java.util.List;


import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import EjbEntity.Client;

@Stateful
public class ClientBean implements ClientRemote{

	@PersistenceContext(unitName = "dsFSTBank")
	EntityManager em;
	
    public ClientBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Client ajouter(Client clr) {
		em.persist(clr);
		return clr;
	}

	@Override
	public void supprimer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifier() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Client> afficher() {
		Query req = em.createQuery("select c from Client c");
		return req.getResultList();
	}

}

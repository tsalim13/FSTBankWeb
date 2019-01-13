package EjbBean;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import EjbEntity.Banquier;
import EjbEntity.Client;

@Stateful
public class ClientBean implements ClientRemote {

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
	public void supprimer(Client clr) {
		
		em.remove(em.merge(clr));

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

	@Override
	public Client find(int id) {
		Client cl = em.find(Client.class, id);
		return cl;

	}

	@Override
	public Client findByMail(String mail) {
		try {
			Query req = em.createQuery("from Client c where c.mail ='" + mail + "'");
			return (Client) req.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
	
	
	public Client clientLogin(String mail, String mdp) {
		try {
			Query req = em.createQuery("from Client c where c.mail='"+ mail+"' and c.mdp='"+mdp+"'");
			return (Client) req.getSingleResult();

		} catch (Exception e) {
			return null;
		}
		
	}
	
}

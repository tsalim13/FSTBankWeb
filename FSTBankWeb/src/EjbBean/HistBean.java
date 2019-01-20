package EjbBean;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import EjbEntity.Historique;
import EjbEntity.ObserverHist;

@Stateful
public class HistBean implements HistRemote, ObserverHist {

	@PersistenceContext
	EntityManager em;

	public HistBean() {

	}

	@Override
	public void update(Historique h) {
		em.persist(h);
	}

	@Override
	public List<Historique> afficher(String iban) {
		Query req = em.createQuery("select h from Historique h where h.id_sender='"+iban+"'");
		return req.getResultList();
	}
	
	@Override
	public List<Historique> afficherR(String iban) {
		Query req = em.createQuery("select h from Historique h where h.id_receiver='"+iban+"'");
		return req.getResultList();
	}

}

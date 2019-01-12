package EjbBean;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}

package EjbBean;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import EjbEntity.Historique;

@Stateful
public class HistBean implements HistRemote{

	@PersistenceContext
	EntityManager em;

	public HistBean() {
		
	}
	
	@Override
	public Historique addHist(Historique h) {
		
		em.persist(h);
		System.out.println("add hist methoooodeee");
		return h;
		
	}

}

package EjbBean;


import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import EjbEntity.Banquier;
import EjbEntity.Client;

@Stateful
public class BanquierBean implements BanquierRemote{
	
	@PersistenceContext(unitName = "dsFSTBank")
	EntityManager em;

	@Override
	public Banquier ajouter(Banquier bnq) {
		em.persist(bnq);
		return bnq;
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
	public List<Banquier> afficher() {
		Query req = em.createQuery("select b from Banquier b");
		return req.getResultList();
		
	}

}

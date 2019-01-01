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
	public Banquier ajouter(Client clr) {
		// TODO Auto-generated method stub
		return null;
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
	public List afficher() {
		Query req = em.createQuery("select * from banquier");
		return req.getResultList();
		
	}

}

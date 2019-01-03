package EjbBean;


import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import EjbEntity.Banquier;


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
	public boolean supprimer(int id) {
		Banquier bnqRmv = em.find(Banquier.class, id);
		if(bnqRmv!=null) {
				em.remove(bnqRmv);
		return true ;		
		}
		return false ;
	}

	@Override
	public boolean modifier(Banquier bnqm) {
		Banquier bnq = em.find(Banquier.class, bnqm.getId());
		if(bnq != null)
		{
			/*if(bnqm.getMail() != null) {bnq.setMail(bnqm.getMail());}
			if(bnqm.getMdp() != null) {bnq.setMdp(bnqm.getMdp());}
			if(bnqm.getNom() != null) {bnq.setNom(bnqm.getNom());}
			if(bnqm.getPrenom() != null) {bnq.setPrenom(bnqm.getPrenom());}
			em.flush();
			return true;*/
			
			em.merge(bnqm);
			em.flush();
			return true ;
			
		}
		return false;
	}

	@Override
	public List<Banquier> afficher() {
		Query req = em.createQuery("select b from Banquier b");
		return req.getResultList();
		
	}

}

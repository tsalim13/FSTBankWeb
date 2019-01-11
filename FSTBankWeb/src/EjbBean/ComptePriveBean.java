package EjbBean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.management.RuntimeErrorException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import EjbEntity.CParticulierPartage;
import EjbEntity.CParticulierPrive;
import EjbEntity.Compte;


@Stateful
public class ComptePriveBean implements ComptePriveRemote{
	
	@PersistenceContext
	EntityManager em;

    public ComptePriveBean() {
    }

	@Override
	public CParticulierPrive addCompte(CParticulierPrive cpp) {
		em.persist(cpp);
		return cpp;
	}

	@Override
	public CParticulierPrive getCompte(int id) {
		CParticulierPrive cp = em.find(CParticulierPrive.class, id);
		if (cp == null) throw new RuntimeException("Compte introuvable");
		return cp;
	}

	@Override
	public List<CParticulierPrive> listComptes() {
		Query req = em.createQuery("select * from cparticulierprive");
		return req.getResultList();
	}

	@Override
	public void verser(int id, double mt) {
		CParticulierPrive cp = getCompte(id);
		cp.setSolde(cp.getSolde()+mt);		
	}

	@Override
	public void retirer(int id, double mt) {
		CParticulierPrive cp = getCompte(id);
		if(cp.getSolde()<mt)throw new RuntimeException("Solde insuffisant");
		cp.setSolde(cp.getSolde()-mt);	
	}

	@Override
	public void virement(int cp, int cp2, double mt) {
		retirer(cp, mt);
		verser(cp2, mt);
	}

	@Override
	public ArrayList<CParticulierPrive> findCompteByClient(int id) {
	
			Query req = em.createQuery("from CParticulierPrive c where c.client.id="+id);
			return (ArrayList<CParticulierPrive>) req.getResultList();
			
		
			
		
	}
  

}

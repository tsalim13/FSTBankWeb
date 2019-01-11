package EjbBean;

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
import EjbEntity.CProfessionnel;
import EjbEntity.Compte;

@Stateful
public class ComptePartageBean implements ComptePartageRemote{
	
	@PersistenceContext
	EntityManager em;

    public ComptePartageBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public CParticulierPartage addCompte(CParticulierPartage cpp) {
		em.persist(cpp);
		return cpp;
	}

	@Override
	public CParticulierPartage getCompte(int id) {
		CParticulierPartage cp = em.find(CParticulierPartage.class, id);
		if (cp == null) throw new RuntimeException("Compte introuvable");
		return cp;
	}

	@Override
	public List<CParticulierPartage> listComptes() {
		Query req = em.createQuery("select * from cparticulierprive");
		return req.getResultList();
	}

	@Override
	public void verser(int id, double mt) {
		CParticulierPartage cp = getCompte(id);
		cp.setSolde(cp.getSolde()+mt);		
	}

	@Override
	public void retirer(int id, double mt) {
		CParticulierPartage cp = getCompte(id);
		if(cp.getSolde()<mt)throw new RuntimeException("Solde insuffisant");
		cp.setSolde(cp.getSolde()-mt);	
	}

	@Override
	public void virement(int cp, int cp2, double mt) {
		retirer(cp, mt);
		verser(cp2, mt);
	}

	@Override
	public CParticulierPartage findCompteByClient(int idClient) {
		try {
			Query req = em.createQuery("from CParticulierPartage c where c.client_id ='" + idClient + "'");
			return (CParticulierPartage) req.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	

}

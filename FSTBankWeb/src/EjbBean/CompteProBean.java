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
import EjbEntity.Client;
import EjbEntity.Compte;

@Stateful
public class CompteProBean implements CompteProRemote {

	@PersistenceContext
	EntityManager em;

	public CompteProBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public CProfessionnel addCompte(CProfessionnel cpp) {
		em.persist(cpp);
		return cpp;
	}

	@Override
	public CProfessionnel getCompte(int id) {
		CProfessionnel cp = em.find(CProfessionnel.class, id);
		if (cp == null)
			throw new RuntimeException("Compte introuvable");
		return cp;
	}

	@Override
	public List<CProfessionnel> listComptes() {
		Query req = em.createQuery("select * from cparticulierprive");
		return req.getResultList();
	}

	@Override
	public void verser(int id, double mt) {
		CProfessionnel cp = getCompte(id);
		cp.setSolde(cp.getSolde() + mt);
	}

	@Override
	public void retirer(int id, double mt) {
		CProfessionnel cp = getCompte(id);
		if (cp.getSolde() < mt)
			throw new RuntimeException("Solde insuffisant");
		cp.setSolde(cp.getSolde() - mt);
	}

	@Override
	public void virement(int cp, int cp2, double mt) {
		retirer(cp, mt);
		verser(cp2, mt);
	}

	@Override
	public CProfessionnel findCompteByClient(int idClient) {
		try {
			Query req = em.createQuery("from CProfessionnel c where c.client_id ='" + idClient + "'");
			return (CProfessionnel) req.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

}

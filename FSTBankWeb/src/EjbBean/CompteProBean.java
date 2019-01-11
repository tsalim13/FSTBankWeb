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
	public boolean verser(int id, double mt) {
		CProfessionnel cpp = em.find(CProfessionnel.class, id);
		if (cpp != null) {
			cpp.setSolde(cpp.getSolde() + mt);
			em.flush();
			return true;
		} else
			return false;
	}

	@Override
	public boolean retirer(int id, double mt, String typeCompte) {
		if (typeCompte.equals("prive")) {
			CParticulierPrive cpp = em.find(CParticulierPrive.class, id);
			if (cpp != null) {
				if (cpp.getSolde() < mt)
					return false;
				cpp.setSolde(cpp.getSolde() - mt);
				em.flush();
				return true;
			}
		}
		else if (typeCompte.equals("partage")) {
			CParticulierPartage cpp = em.find(CParticulierPartage.class, id);	
			if (cpp != null) {
				if (cpp.getSolde() < mt)
					return false;
				cpp.setSolde(cpp.getSolde() - mt);
				em.flush();
				return true;
			}
		}
		else {
			CProfessionnel cpp = em.find(CProfessionnel.class, id);
			if (cpp != null) {
				if (cpp.getSolde() < mt)
					return false;
				cpp.setSolde(cpp.getSolde() - mt);
				em.flush();
				return true;
			}
		}	
		return false;
	}

	@Override
	public boolean virement(int cp, int cp2, double mt, String typeCompte) {
		if (retirer(cp, mt,typeCompte)) {
			if (verser(cp2, mt)) {
				return true;
			}
			else return false;
		}
		else 
			return false;
	}

	@Override
	public ArrayList<CProfessionnel> findCompteByClient(int id) {
		try {
			Query req = em.createQuery("from CProfessionnel c where c.client.id=" + id);
			return (ArrayList<CProfessionnel>) req.getResultList();

		} catch (Exception e) {
			return null;
		}

	}
	@Override
	public CProfessionnel findIdByIBAN(String iban) {
		try {
			Query req = em.createQuery("from CProfessionnel c where c.codeIBN='" + iban + "'");
			return (CProfessionnel) req.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

}

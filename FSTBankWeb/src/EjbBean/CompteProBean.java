package EjbBean;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.management.RuntimeErrorException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Aop.Journalisation;
import EjbEntity.CParticulierPartage;
import EjbEntity.CParticulierPrive;
import EjbEntity.CProfessionnel;
import EjbEntity.Client;
import EjbEntity.Compte;
import EjbEntity.Historique;

@Stateful
public class CompteProBean implements CompteProRemote, ObservableHist {
	@EJB
	HistRemote r;
	private boolean vir = false;

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
		Query req = em.createQuery("select c from CProfessionnel c");
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
	@Interceptors({ Journalisation.class })
	@Override
	public boolean retirer(int id, double mt, String typeCompte) {
		if (typeCompte.equals("prive")) {
			CParticulierPrive cpp = em.find(CParticulierPrive.class, id);
			if (cpp != null) {
				if (cpp.getSolde() < mt)
					return false;
				cpp.setSolde(cpp.getSolde() - mt);
				em.flush();
				if (vir == false)
					notifyHist(id, 0, mt);
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
				if (vir == false)
					notifyHist(id, 0, mt);
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
				if (vir == false)
					notifyHist(id, 0, mt);
				return true;
			}
		}	
		return false;
	}
	@Interceptors({ Journalisation.class })
	@Override
	public boolean virement(int cp, int cp2, double mt, String typeCompte) {
		vir = true;
		if (retirer(cp, mt,typeCompte)) {
			if (verser(cp2, mt)) {
				notifyHist(cp, cp2, mt);
				vir = false;
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

	@Override
	public void notifyHist(int sender, int receiver, double solde) {

		Date d;
		Historique h = new Historique();
		h.setId_sender(sender);
		if (receiver != 0) {
			h.setId_receiver(receiver);
		}
		h.setTrasanction_solde(solde);
		r.update(h);

		
	}

}

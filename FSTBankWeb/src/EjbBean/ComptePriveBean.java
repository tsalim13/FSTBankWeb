package EjbBean;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import EjbEntity.Compte;

import EjbEntity.Historique;
import EjbEntity.ObserverHist;

@Stateful
public class ComptePriveBean implements ComptePriveRemote, ObservableHist {

	// private ArrayList<ObserverHist> histList = new ArrayList<ObserverHist>();
	@EJB
	HistRemote r;
	private boolean vir = false;
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
		if (cp == null)
			throw new RuntimeException("Compte introgfuvable");
		return cp;
	}

	@Override
	public List<CParticulierPrive> listComptes() {
		Query req = em.createQuery("select c from CParticulierPrive c");
		return req.getResultList();
	}

	@Override
	public boolean verser(int id, double mt) {
		CParticulierPrive cpp = em.find(CParticulierPrive.class, id);
		if (cpp != null) {
			cpp.setSolde(cpp.getSolde() + mt);
			em.flush();
			return true;
		} else
			return false;
	}

	@Interceptors({ Journalisation.class })
	public boolean retirer(int id, double mt, String typeCompte, int idc) {
		if (typeCompte.equals("prive")) {
			CParticulierPrive cpp = em.find(CParticulierPrive.class, id);
			if (cpp != null) {
				if (cpp.getSolde() < mt)
					return false;
				cpp.setSolde(cpp.getSolde() - mt);
				em.flush();
				if (vir == false)
					notifyHist(cpp.getCodeIBN(), null, mt);
				return true;
			}
		} else if (typeCompte.equals("partage")) {
			CParticulierPartage cpp = em.find(CParticulierPartage.class, id);
			if (cpp != null) {
				if (cpp.getSolde() < mt)
					return false;
				cpp.setSolde(cpp.getSolde() - mt);
				em.flush();
				if (vir == false)
					notifyHist(cpp.getCodeIBN(), null, mt);
				return true;
			}
		} else {
			CProfessionnel cpp = em.find(CProfessionnel.class, id);
			if (cpp != null) {
				if (cpp.getSolde() < mt)
					return false;
				cpp.setSolde(cpp.getSolde() - mt);
				em.flush();
				if (vir == false)
					notifyHist(cpp.getCodeIBN(), null, mt);
				return true;
			}
		}
		return false;
	}

	@Interceptors({ Journalisation.class })
	@Override
	public boolean virement(int cp, int cp2, double mt, String typeCompte, int idc) {
		vir = true;
		if (retirer(cp, mt, typeCompte, idc)) {
			if (verser(cp2, mt)) {
				CParticulierPrive cpp = em.find(CParticulierPrive.class, cp2);
				if (typeCompte.equals("prive")) {
					CParticulierPrive cpp2 = em.find(CParticulierPrive.class, cp);
					notifyHist(cpp2.getCodeIBN(), cpp.getCodeIBN(), mt);
				}
				else if (typeCompte.equals("pro")) {
					CProfessionnel cpp3 = em.find(CProfessionnel.class, cp);
					notifyHist(cpp3.getCodeIBN(), cpp.getCodeIBN(), mt);					
				}
				else {
					CParticulierPartage cpp4 = em.find(CParticulierPartage.class, cp);
					notifyHist(cpp4.getCodeIBN(), cpp.getCodeIBN(), mt);						
				}				
				vir = false;
				return true;
			} else
				return false;
		} else
			return false;

	}

	@Override
	public ArrayList<CParticulierPrive> findCompteByClient(int id) {
		try {
			Query req = em.createQuery("from CParticulierPrive c where c.client.id=" + id);
			return (ArrayList<CParticulierPrive>) req.getResultList();

		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public CParticulierPrive findIdByIBAN(String iban) {
		try {
			Query req = em.createQuery("from CParticulierPrive c where c.codeIBN='" + iban + "'");
			return (CParticulierPrive) req.getSingleResult();

		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public void notifyHist(String sender, String receiver, double solde) {

		Date dt = null;
		Historique h = new Historique();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String date = sdf.format(new Date());
		try {
			dt = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		h.setDateTransaction(dt);
		h.setId_sender(sender);
		if (receiver != null) {
			h.setId_receiver(receiver);
		}
		h.setTrasanction_solde(solde);
		r.update(h);

	}
}

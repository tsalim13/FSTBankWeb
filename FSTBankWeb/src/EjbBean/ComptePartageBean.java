package EjbBean;

import java.util.ArrayList;
import java.util.Iterator;
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
public class ComptePartageBean implements ComptePartageRemote {

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
		if (cp == null)
			throw new RuntimeException("Compte introuvable");
		return cp;
	}

	@Override
	public List<CParticulierPartage> listComptes() {
		Query req = em.createQuery("select c from CParticulierPartage c");
		return req.getResultList();
	}

	@Override
	public boolean verser(int id, double mt) {
		CParticulierPartage cpp = em.find(CParticulierPartage.class, id);
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
		} else if (typeCompte.equals("partage")) {
			CParticulierPartage cpp = em.find(CParticulierPartage.class, id);
			if (cpp != null) {
				if (cpp.getSolde() < mt)
					return false;
				cpp.setSolde(cpp.getSolde() - mt);
				em.flush();
				return true;
			}
		} else {
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
		if (retirer(cp, mt, typeCompte)) {
			if (verser(cp2, mt)) {
				return true;
			} else
				return false;
		} else
			return false;
	}

	@Override
	public ArrayList<CParticulierPartage> findCompteByClient(int id) {
		try {
			Query req = em.createQuery("from CParticulierPartage cp join cp.clients cl  where cl.id=" + id);

			List<Object[]> res = req.getResultList();
			List<CParticulierPartage> list = new ArrayList<CParticulierPartage>();
			Iterator it = res.iterator();
			while (it.hasNext()) {
				Object[] line = (Object[]) it.next();
				CParticulierPartage cp = (CParticulierPartage) line[0];
				list.add(cp);	
			}
			return (ArrayList<CParticulierPartage>) list;

		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public CParticulierPartage findIdByIBAN(String iban) {
		try {
			Query req = em.createQuery("from CParticulierPartage c where c.codeIBN='" + iban + "'");
			return (CParticulierPartage) req.getSingleResult();

		} catch (Exception e) {
			return null;
		}
	}

}

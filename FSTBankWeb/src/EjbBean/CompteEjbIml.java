package EjbBean;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.management.RuntimeErrorException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import EjbEntity.Compte;

@Stateful(name="dsFSTBank")
@LocalBean
public class CompteEjbIml implements CompteLocal,CompteRemote{
	
	@PersistenceContext(unitName = "dsFSTBank")
	EntityManager em;

    public CompteEjbIml() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Compte addCompte(Compte cp) {
		em.persist(cp);
		return cp;
	}

	@Override
	public Compte getCompte(int id) {
		Compte cp = em.find(Compte.class, id);
		if (cp == null) throw new RuntimeException("Compte introuvable");
		return cp;
	}

	@Override
	public List<Compte> listComptes() {
		Query req = em.createQuery("select * from Compte");
		return req.getResultList();
	}

	@Override
	public void verser(int id, double mt) {
		Compte cp = getCompte(id);
		cp.setSolde(cp.getSolde()+mt);		
	}

	@Override
	public void retirer(int id, double mt) {
		Compte cp = getCompte(id);
		if(cp.getSolde()<mt)throw new RuntimeException("Solde insuffisant");
		cp.setSolde(cp.getSolde()-mt);	
	}

	@Override
	public void virement(int cp, int cp2, double mt) {
		retirer(cp, mt);
		verser(cp2, mt);
	}
    

}

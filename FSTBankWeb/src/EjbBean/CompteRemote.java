package EjbBean;

import java.util.List;

import javax.ejb.Remote;

import EjbEntity.Compte;

@Remote
public interface CompteRemote {
	public Compte addCompte(Compte cp);
	public Compte getCompte(int id);
	public List<Compte> listComptes();
	public void verser(int id, double mt);
	public void retirer(int id, double mt);
	public void virement(int cp, int cp2, double mt);
}

package EjbBean;

import java.util.List;
import javax.ejb.Local;

import EjbEntity.CParticulierPrive;
import EjbEntity.Compte;

@Local
public interface ComptePriveLocal {
	public CParticulierPrive addCompte(CParticulierPrive cpp);
	public CParticulierPrive getCompte(int id);
	public List<CParticulierPrive> listComptes();
	public void verser(int id, double mt);
	public void retirer(int id, double mt);
	public void virement (int cp, int cp2, double mt);
}

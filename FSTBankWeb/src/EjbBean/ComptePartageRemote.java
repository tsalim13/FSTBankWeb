package EjbBean;

import java.util.List;

import javax.ejb.Remote;

import EjbEntity.CParticulierPartage;
import EjbEntity.CParticulierPrive;
import EjbEntity.Compte;

@Remote
public interface ComptePartageRemote {
	public CParticulierPartage addCompte(CParticulierPartage cpp);
	public CParticulierPartage getCompte(int id);
	public List<CParticulierPartage> listComptes();
	public void verser(int id, double mt);
	public void retirer(int id, double mt);
	public void virement(int cp, int cp2, double mt);
	public CParticulierPartage findCompteByClient(int idClient);
}

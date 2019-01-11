package EjbBean;

import java.util.List;

import javax.ejb.Remote;

import EjbEntity.CParticulierPartage;
import EjbEntity.CParticulierPrive;
import EjbEntity.CProfessionnel;
import EjbEntity.Compte;

@Remote
public interface CompteProRemote {
	public CProfessionnel addCompte(CProfessionnel cpp);
	public CProfessionnel getCompte(int id);
	public List<CProfessionnel> listComptes();
	public void verser(int id, double mt);
	public void retirer(int id, double mt);
	public void virement(int cp, int cp2, double mt);
	public CProfessionnel findCompteByClient(int idClient);
}

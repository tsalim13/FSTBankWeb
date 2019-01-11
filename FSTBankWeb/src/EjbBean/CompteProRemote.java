package EjbBean;

import java.util.ArrayList;
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
	public boolean verser(int id, double mt);
	public ArrayList<CProfessionnel> findCompteByClient(int idClient);
	public CProfessionnel findIdByIBAN(String iban);
	boolean virement(int cp, int cp2, double mt, String typeCompte);
	boolean retirer(int id, double mt, String typeCompte);
}

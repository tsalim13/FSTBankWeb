package EjbBean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;

import EjbEntity.CParticulierPrive;
import EjbEntity.CProfessionnel;
import EjbEntity.Compte;

@Remote
public interface ComptePriveRemote {
	public CParticulierPrive addCompte(CParticulierPrive cpp);
	public CParticulierPrive getCompte(int id);
	public List<CParticulierPrive> listComptes();
	public ArrayList<CParticulierPrive> findCompteByClient(int idClient);
	public CParticulierPrive findIdByIBAN(String iban);
	boolean retirer(int id, double mt, String typeCompte);
	boolean verser(int id, double mt);
	boolean virement(int cp, int cp2, double mt, String typeCompte);
	void notifyHist(String sender, String receiver, double solde);
}

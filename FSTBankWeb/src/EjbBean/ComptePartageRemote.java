package EjbBean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;

import EjbEntity.CParticulierPartage;
import EjbEntity.CParticulierPrive;
import EjbEntity.Client;
import EjbEntity.Compte;

@Remote
public interface ComptePartageRemote {
	public CParticulierPartage addCompte(CParticulierPartage cpp);
	public CParticulierPartage getCompte(int id);
	public List<CParticulierPartage> listComptes();
	public boolean verser(int id, double mt);
	public ArrayList<CParticulierPartage> findCompteByClient(int idClient);
	public CParticulierPartage findIdByIBAN(String iban2);
	boolean virement(int cp, int cp2, double mt, String typeCompte, int idc);
	boolean retirer(int id, double mt, String typeCompte, int idc);
	public List listComptes2();
	public List listComptes3();
	public ArrayList<Client> findClientByCompte(int id);
}

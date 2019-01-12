package EjbBean;


import java.util.List;

import javax.ejb.Remote;

import EjbEntity.Banquier;
import EjbEntity.Client;
@Remote
public interface BanquierRemote {
	public Banquier ajouter(Banquier clr);
	public boolean supprimer(int id);
	public List<Banquier> afficher();
	public boolean modifier(Banquier bnqm);
	public Banquier banquierLogin(String mail, String mdp);
}

package EjbBean;


import java.util.List;

import javax.ejb.Remote;

import EjbEntity.Banquier;
import EjbEntity.Client;
@Remote
public interface BanquierRemote {
	public Banquier ajouter(Banquier clr);
	public void supprimer();
	public void modifier();
	public List<Banquier> afficher();
	

	
}

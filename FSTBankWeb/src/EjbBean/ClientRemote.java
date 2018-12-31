package EjbBean;

import java.util.List;
import javax.ejb.Remote;
import EjbEntity.Client;

@Remote
public interface ClientRemote {

	public void ajouter();
	public void supprimer();
	public void modifier();
	public List<Client> afficher();
}

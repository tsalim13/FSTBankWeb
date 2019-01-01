package EjbBean;

import java.util.List;
import javax.ejb.Remote;
import EjbEntity.Client;

@Remote
public interface ClientRemote {

	public Client ajouter(Client clr);
	public void supprimer();
	public void modifier();
	public List<Client> afficher();
}

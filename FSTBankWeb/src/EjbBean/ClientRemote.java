package EjbBean;

import java.util.List;
import javax.ejb.Remote;
import EjbEntity.Client;

@Remote
public interface ClientRemote {

	public Client ajouter(Client clr);
	public void supprimer(Client clr);
	public void modifier();
	public List<Client> afficher();
	public Client find(int id);
	public Client findByMail(String mail);
	public Client clientLogin(String mail, String mdp);
}

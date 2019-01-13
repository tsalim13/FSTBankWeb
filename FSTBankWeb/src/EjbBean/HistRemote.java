package EjbBean;

import java.util.List;

import javax.ejb.Remote;

import EjbEntity.Historique;

@Remote
public interface HistRemote {


	public void update(Historique h);
	public List<Historique> afficher(String iban);
}

package EjbBean;

import javax.ejb.Remote;

import EjbEntity.Historique;

@Remote
public interface HistRemote {


	public void update(Historique h);
}

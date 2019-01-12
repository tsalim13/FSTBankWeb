package EjbBean;

import javax.ejb.Remote;

import EjbEntity.Historique;

@Remote
public interface HistRemote {

	public Historique addHist(Historique h);
}

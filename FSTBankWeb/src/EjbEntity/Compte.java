package EjbEntity;

import javax.persistence.*;

@MappedSuperclass
public abstract class Compte {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}

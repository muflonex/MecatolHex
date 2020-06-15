package modelo.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mecanica database table.
 * 
 */
@Entity
@Table(name="mecanica")
@NamedQuery(name="Mechanic.findAll", query="SELECT m FROM Mechanic m")
public class Mechanic implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_mecanica")
	private int mechanicId;

	@Column(name="nombre")
	private String name;

	//bi-directional many-to-many association to Game
	@ManyToMany
	@JoinTable(
		name="juego_tiene_mecanica"
		, joinColumns={
			@JoinColumn(name="mecanica_id_mecanica")
			}
		, inverseJoinColumns={
			@JoinColumn(name="juego_id_juego")
			}
		)
	private List<Game> games;

	public Mechanic() {
	}

	public Mechanic(int mechanicId, String name) {
		super();
		this.mechanicId = mechanicId;
		this.name = name;
	}

	public int getMechanicId() {
		return this.mechanicId;
	}

	public void setMechanicId(int mechanicId) {
		this.mechanicId = mechanicId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Game> getGames() {
		return this.games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mechanicId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mechanic other = (Mechanic) obj;
		if (mechanicId != other.mechanicId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Mechanic [mechanicId=" + mechanicId + ", name=" + name + ", games=" + games + "]";
	}
	
}
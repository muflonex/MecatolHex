package modelo.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the juego database table.
 * 
 */
@Entity
@Table(name="juego")
@NamedQuery(name="Game.findAll", query="SELECT g FROM Game g")
public class Game implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_juego")
	private int gameId;

	@Column(name="complejidad")
	private int difficulty;

	@Column(name="dependencia_ling")
	private int lingDependency;

	@Column(name="es_expansion")
	private byte isExpansion;

	@Column(name="imagen")
	private String image;

	@Column(name="max_jugadores")
	private int maxPlayers;

	@Column(name="min_edad")
	private int minAge;

	@Column(name="min_jugadores")
	private int minPlayers;

	@Column(name="nombre")
	private String name;

	@Column(name="nombre_original")
	private String originalName;

	@Column(name="tiempo_jugar")
	private int playTime;

	//bi-directional many-to-one association to Copy
	@OneToMany(mappedBy="game")
	private List<Copy> copies;

	//bi-directional many-to-many association to Category
	@ManyToMany
	@JoinTable(
		name="juego_tiene_categoria"
		, joinColumns={
			@JoinColumn(name="juego_id_juego")
			}
		, inverseJoinColumns={
			@JoinColumn(name="categoria_id_categoria")
			}
		)
	private List<Category> categories;

	//bi-directional many-to-one association to Game
	@ManyToOne
	@JoinColumn(name="id_juego_expandido")
	private Game expanded_game;

	//bi-directional many-to-one association to Game
	@OneToMany(mappedBy="expanded_game", cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<Game> expansions;

	//bi-directional many-to-many association to Mechanic
	@ManyToMany(mappedBy="games")
	private List<Mechanic> mechanics;

	public Game() {
	}

	public Game(int gameId, int difficulty, int lingDependency, byte isExpansion, String image, int maxPlayers,
			int minAge, int minPlayers, String name, String originalName, int playTime) {
		super();
		this.gameId = gameId;
		this.difficulty = difficulty;
		this.lingDependency = lingDependency;
		this.isExpansion = isExpansion;
		this.image = image;
		this.maxPlayers = maxPlayers;
		this.minAge = minAge;
		this.minPlayers = minPlayers;
		this.name = name;
		this.originalName = originalName;
		this.playTime = playTime;
	}

	public int getGameId() {
		return this.gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public int getDifficulty() {
		return this.difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public int getLingDependency() {
		return this.lingDependency;
	}

	public void setLingDependency(int lingDependency) {
		this.lingDependency = lingDependency;
	}

	public byte getIsExpansion() {
		return this.isExpansion;
	}

	public void setIsExpansion(byte isExpansion) {
		this.isExpansion = isExpansion;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getMaxPlayers() {
		return this.maxPlayers;
	}

	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}

	public int getMinAge() {
		return this.minAge;
	}

	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}

	public int getMinPlayers() {
		return this.minPlayers;
	}

	public void setMinPlayers(int minPlayers) {
		this.minPlayers = minPlayers;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOriginalName() {
		return this.originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public int getPlayTime() {
		return this.playTime;
	}

	public void setPlayTime(int playTime) {
		this.playTime = playTime;
	}

	public List<Copy> getCopies() {
		return this.copies;
	}

	public void setCopies(List<Copy> copies) {
		this.copies = copies;
	}

	public Copy addCopy(Copy copy) {
		getCopies().add(copy);
		copy.setGame(this);

		return copy;
	}

	public Copy removeCopy(Copy copy) {
		getCopies().remove(copy);
		copy.setGame(null);

		return copy;
	}

	public List<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Game getExpanded_game() {
		return this.expanded_game;
	}

	public void setExpanded_game(Game expanded_game) {
		this.expanded_game = expanded_game;
	}

	public List<Game> getExpansions() {
		return this.expansions;
	}

	public void setExpansions(List<Game> expansions) {
		this.expansions = expansions;
	}

	public Game addExpansion(Game expansion) {
		getExpansions().add(expansion);
		expansion.setExpanded_game(this);

		return expansion;
	}

	public Game removeExpansion(Game expansion) {
		getExpansions().remove(expansion);
		expansion.setExpanded_game(null);

		return expansion;
	}

	public List<Mechanic> getMechanics() {
		return this.mechanics;
	}

	public void setMechanics(List<Mechanic> mechanics) {
		this.mechanics = mechanics;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + gameId;
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
		Game other = (Game) obj;
		if (gameId != other.gameId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Game [gameId=" + gameId + ", difficulty=" + difficulty + ", lingDependency=" + lingDependency
				+ ", isExpansion=" + isExpansion + ", image=" + image + ", maxPlayers=" + maxPlayers + ", minAge="
				+ minAge + ", minPlayers=" + minPlayers + ", name=" + name + ", originalName=" + originalName
				+ ", playTime=" + playTime + ", copies=" + copies + ", categories=" + categories + ", expanded_game="
				+ expanded_game + ", expansions=" + expansions + ", mechanics=" + mechanics + "]";
	}

}
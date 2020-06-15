package modelo.beans;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-06-14T19:30:34.512+0200")
@StaticMetamodel(Game.class)
public class Game_ {
	public static volatile SingularAttribute<Game, Integer> gameId;
	public static volatile SingularAttribute<Game, Integer> difficulty;
	public static volatile SingularAttribute<Game, Integer> lingDependency;
	public static volatile SingularAttribute<Game, Byte> isExpansion;
	public static volatile SingularAttribute<Game, String> image;
	public static volatile SingularAttribute<Game, Integer> maxPlayers;
	public static volatile SingularAttribute<Game, Integer> minAge;
	public static volatile SingularAttribute<Game, Integer> minPlayers;
	public static volatile SingularAttribute<Game, String> name;
	public static volatile SingularAttribute<Game, String> originalName;
	public static volatile SingularAttribute<Game, Integer> playTime;
	public static volatile ListAttribute<Game, Copy> copies;
	public static volatile ListAttribute<Game, Category> categories;
	public static volatile SingularAttribute<Game, Game> expanded_game;
	public static volatile ListAttribute<Game, Game> expansions;
	public static volatile ListAttribute<Game, Mechanic> mechanics;
}

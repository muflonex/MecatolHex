package modelo.beans;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-06-11T01:53:36.052+0200")
@StaticMetamodel(Mechanic.class)
public class Mechanic_ {
	public static volatile SingularAttribute<Mechanic, Integer> mechanicId;
	public static volatile SingularAttribute<Mechanic, String> name;
	public static volatile ListAttribute<Mechanic, Game> games;
}

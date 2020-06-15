package modelo.beans;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-06-11T01:53:36.061+0200")
@StaticMetamodel(Shelf.class)
public class Shelf_ {
	public static volatile SingularAttribute<Shelf, Integer> shelfId;
	public static volatile SingularAttribute<Shelf, Integer> number;
	public static volatile ListAttribute<Shelf, Copy> copies;
	public static volatile SingularAttribute<Shelf, Bookshelf> bookshelf;
}

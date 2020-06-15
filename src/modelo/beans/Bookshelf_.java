package modelo.beans;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-06-11T01:53:36.010+0200")
@StaticMetamodel(Bookshelf.class)
public class Bookshelf_ {
	public static volatile SingularAttribute<Bookshelf, Integer> bookshelfId;
	public static volatile ListAttribute<Bookshelf, Copy> copies;
	public static volatile ListAttribute<Bookshelf, Shelf> shelves;
}

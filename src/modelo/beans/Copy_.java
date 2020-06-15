package modelo.beans;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-06-11T01:53:36.027+0200")
@StaticMetamodel(Copy.class)
public class Copy_ {
	public static volatile SingularAttribute<Copy, Integer> copyId;
	public static volatile SingularAttribute<Copy, Shelf> shelf;
	public static volatile SingularAttribute<Copy, Bookshelf> bookshelf;
	public static volatile SingularAttribute<Copy, Game> game;
	public static volatile SingularAttribute<Copy, User> user;
	public static volatile ListAttribute<Copy, Loan> loans;
}

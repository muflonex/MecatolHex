package modelo.beans;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-06-14T14:28:38.813+0200")
@StaticMetamodel(Loan.class)
public class Loan_ {
	public static volatile SingularAttribute<Loan, Integer> loanId;
	public static volatile SingularAttribute<Loan, Date> endDate;
	public static volatile SingularAttribute<Loan, Date> startDate;
	public static volatile SingularAttribute<Loan, Copy> copy;
	public static volatile SingularAttribute<Loan, User> user;
}

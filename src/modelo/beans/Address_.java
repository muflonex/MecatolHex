package modelo.beans;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-06-11T21:34:14.261+0200")
@StaticMetamodel(Address.class)
public class Address_ {
	public static volatile SingularAttribute<Address, Integer> addressId;
	public static volatile SingularAttribute<Address, String> address;
	public static volatile SingularAttribute<Address, Double> lat;
	public static volatile SingularAttribute<Address, Double> lng;
}

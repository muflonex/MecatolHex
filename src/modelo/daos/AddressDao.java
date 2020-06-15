package modelo.daos;

import java.util.List;

import modelo.beans.Address;

public interface AddressDao {
	public int insert(Address address);
    public Address findById(int userId);
    public List<Address> findAll();
    public int update(Address address);
    public int delete(Address address);
}

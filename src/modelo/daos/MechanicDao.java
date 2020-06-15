package modelo.daos;

import java.util.List;

import modelo.beans.Mechanic;

public interface MechanicDao {
	public int insert(Mechanic mechanic);
    public Mechanic findById(int mechanicId);
    public List<Mechanic> findAll();
    public int update(Mechanic mechanic);
    public int delete(Mechanic mechanic);
}

package modelo.daos;

import java.util.List;

import modelo.beans.Loan;

public interface LoanDao {
	public int insert(Loan loan);
    public Loan findById(int loanId);
    public List<Loan> findAll();
    public List<Loan> findUserActiveLoans(int userId);
    public List<Loan> findUserLoans(int userId);
    public List<Loan> findAllActive();
    public int update(Loan loan);
    public int delete(Loan loan);
}

package edu.oda.service.loan.interfaces;

import edu.oda.model.Loan;

import java.util.List;

public interface ILoanService {
    //CRUD
    Loan create(Loan loan);
    Loan get(String id);
    Loan update(Loan loan);
    Loan delete(String id);
    List<Loan> getAll();
}

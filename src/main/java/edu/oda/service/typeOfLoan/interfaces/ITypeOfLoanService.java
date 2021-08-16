package edu.oda.service.typeOfLoan.interfaces;


import edu.oda.model.TypeOfLoan;

import java.util.List;

public interface ITypeOfLoanService {
    TypeOfLoan create(TypeOfLoan typeOfLoan);
    TypeOfLoan get(String id);
    TypeOfLoan update(TypeOfLoan typeOfLoan);
    TypeOfLoan delete(String id);
    List<TypeOfLoan> getAll();
}

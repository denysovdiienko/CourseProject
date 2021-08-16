package edu.oda.repository;

import edu.oda.model.Client;
import edu.oda.model.Loan;
import edu.oda.model.TypeOfLoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeTypeOfLoanRepository {
    @Autowired
    LoanMongoRepository LoanMongoRepository;
    @Autowired
    ClientMongoRepository ClientMongoRepository;

    private LocalDateTime time = LocalDateTime.now();
    private List<Loan> loans = new ArrayList<>(
            Arrays.asList(
                    new Loan("0","0", 3500, "25/11/2020",
                            "vzyalCreditROfl", time, time ),
                    new Loan("1","1", 27000, "05/04/2021",
                            "roflCredit", time, time ),
                    new Loan("2","2", 10000, "15/03/2021",
                            "HiHiHaHA", time, time ),
                    new Loan("3","3", 50000, "06/16/2021",
                            "RAdikLoh", time, time )
            )
    );

    private List<Client> clients = new ArrayList<>(
            Arrays.asList(
                    new Client("0","Churkin Radyslav", "private", "Schevsenko 32",
                            "0973456322","mother","Chipsoed", time, time ),
                    new Client("1","Oselkin Vova", "work property", "Fransva 2",
                            "0975679321","father","loh", time, time ),
                    new Client("2","Grizman Antuan", "private", "Schevsenko",
                            "0975626341","sister","lowochek", time, time ),
                    new Client("3","Leonelya Messi", "private", "Schevsenko",
                            "0978729654","brother","polniyloh", time, time )
            )
    );
    private List<TypeOfLoan> list = new ArrayList<>(
            Arrays.asList(
                    new TypeOfLoan("0",loans.get(0), clients.get(0),20,"12/05/2021",
                            "Desc0", time, time ),
                    new TypeOfLoan("1",loans.get(1), clients.get(1),15,"14/06/2021",
                            "Desc1", time, time ),
                    new TypeOfLoan("2",loans.get(2), clients.get(2),17,"11/01/2021",
                            "Desc2", time, time ),
                    new TypeOfLoan("3",loans.get(3), clients.get(3),23,"19/05/2021",
                            "Desc3", time, time )
            )
    );
    public TypeOfLoan create(TypeOfLoan typeOfLoan) {
        String id = UUID.randomUUID().toString();
        typeOfLoan.setId(id);
        typeOfLoan.setCreatedAt(LocalDateTime.now());
        typeOfLoan.setUpdatedAt(LocalDateTime.now());
        list.add(typeOfLoan);
        return typeOfLoan;
    }


    public TypeOfLoan get(String id) {
        TypeOfLoan typeOfLoan = list.stream().filter(el -> el.getId().equals(id))
                .findAny().get();
        return typeOfLoan;
    }


    public TypeOfLoan update(TypeOfLoan typeOfLoan) {
        String id = typeOfLoan.getId();
        TypeOfLoan typeOfLoanToUpdate = this.get(id);
        typeOfLoan.setCreatedAt(typeOfLoanToUpdate.getCreatedAt());
        int index = list.indexOf(typeOfLoanToUpdate);
        typeOfLoan.setUpdatedAt(LocalDateTime.now());
        list.remove(typeOfLoanToUpdate);
        list.add(index, typeOfLoan);

        return typeOfLoan;
    }


    public TypeOfLoan delete(String id) {

        TypeOfLoan typeOfLoan =  this.get(id);
        list.remove(typeOfLoan);

        return typeOfLoan;
    }


    public List<TypeOfLoan> getAll() {
        return list;
    }
}

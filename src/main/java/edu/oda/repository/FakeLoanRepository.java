package edu.oda.repository;

import edu.oda.model.Loan;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeLoanRepository {

    private LocalDateTime time = LocalDateTime.now();
    private List<Loan> list = new ArrayList<>(
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

    public Loan create(Loan loan) {
        String id = UUID.randomUUID().toString();
        loan.setId(id);
        loan.setCreatedAt(LocalDateTime.now());
        loan.setUpdatedAt(LocalDateTime.now());
        list.add(loan);
        return loan;
    }


    public Loan get(String id) {
        Loan loan = list.stream().filter(el -> el.getId().equals(id))
                .findAny().get();
        return loan;
    }


    public Loan update(Loan loan) {
        String id = loan.getId();
        Loan readerToUpdate = this.get(id);
        loan.setCreatedAt(readerToUpdate.getCreatedAt());
        int index = list.indexOf(readerToUpdate);
        loan.setUpdatedAt(LocalDateTime.now());
        list.remove(readerToUpdate);
        list.add(index, loan);

        return loan;
    }


    public Loan delete(String id) {

        Loan loan =  this.get(id);
        list.remove(loan);

        return loan;
    }


    public List<Loan> getAll() {
        return list;
    }
}

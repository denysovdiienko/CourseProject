package edu.oda.service.loan.impls;

import edu.oda.model.Loan;
import edu.oda.repository.FakeLoanRepository;
import edu.oda.repository.LoanMongoRepository;
import edu.oda.service.loan.interfaces.ILoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class LoanServiceImpl implements ILoanService {
    @Autowired
    FakeLoanRepository repository;

    @Autowired
    LoanMongoRepository mongoRepository;

    //@PostConstruct
    void init(){
        List<Loan> list = repository.getAll();
        mongoRepository.saveAll(list);
    }
    @Override
    public Loan create(Loan loan) {
        loan.setCreatedAt(LocalDateTime.now());
        loan.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(loan);
    }

    @Override
    public Loan get(String id) {
        return mongoRepository.findById(id).get();
    }

    @Override
    public Loan update(Loan loan) {
        Loan loanToUpdate = this.get(loan.getId());
        LocalDateTime creation = loanToUpdate.getCreatedAt();
        loan.setCreatedAt(creation);
        loan.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(loan);
    }

    @Override
    public Loan delete(String id) {
        Loan loan = this.get(id);
        mongoRepository.deleteById(id);
        return loan;
    }

    @Override
    public List<Loan> getAll() {
        return mongoRepository.findAll();
    }
}

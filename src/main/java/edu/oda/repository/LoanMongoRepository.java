package edu.oda.repository;

import edu.oda.model.Loan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanMongoRepository extends MongoRepository<Loan,String> {
    List<Loan> findByCodeType(String codeType);
}

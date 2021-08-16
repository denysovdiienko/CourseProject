package edu.oda.repository;

import edu.oda.model.TypeOfLoan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfLoanMongoRepository extends MongoRepository<TypeOfLoan, String> {

}

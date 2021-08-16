package edu.oda.repository;

import edu.oda.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientMongoRepository extends MongoRepository<Client,String> {
    List<Client> findByName(String name);
}

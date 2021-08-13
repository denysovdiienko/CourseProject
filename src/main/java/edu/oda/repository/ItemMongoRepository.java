package edu.oda.repository;

import edu.oda.model.Item;
import org.springframework.data.mongodb.core.MongoAdmin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemMongoRepository extends MongoRepository<Item, String> {
}

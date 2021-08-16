package edu.oda.service.client.impls;

import edu.oda.model.Client;
import edu.oda.repository.ClientMongoRepository;
import edu.oda.repository.FakeClientRepository;
import edu.oda.service.client.interfaces.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClientServiceImpl implements IClientService {
    @Autowired
    FakeClientRepository repository;

    @Autowired
    ClientMongoRepository mongoRepository;

    @PostConstruct
    void init(){
        List<Client> list = repository.getAll();
        mongoRepository.saveAll(list);
    }
    @Override
    public Client create(Client client) {
        client.setCreatedAt(LocalDateTime.now());
        client.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(client);
    }

    @Override
    public Client get(String id) {
        return mongoRepository.findById(id).get();
    }

    @Override
    public Client update(Client client) {
        Client clientToUpdate = this.get(client.getId());
        LocalDateTime creation = clientToUpdate.getCreatedAt();
        client.setCreatedAt(creation);
        client.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(client);
    }

    @Override
    public Client delete(String id) {
        Client client = this.get(id);
        mongoRepository.deleteById(id);
        return client;
    }

    @Override
    public List<Client> getAll() {
        return mongoRepository.findAll();
    }
}

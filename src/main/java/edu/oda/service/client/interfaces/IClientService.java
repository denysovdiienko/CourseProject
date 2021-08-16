package edu.oda.service.client.interfaces;

import edu.oda.model.Client;

import java.util.List;

public interface IClientService {
    Client create(Client client);
    Client get(String id);
    Client update(Client client);
    Client delete(String id);
    List<Client> getAll();
}

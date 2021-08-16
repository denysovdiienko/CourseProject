package edu.oda.repository;

import edu.oda.model.Client;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeClientRepository {
    private LocalDateTime time = LocalDateTime.now();
    private List<Client> list = new ArrayList<>(
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

    public Client create(Client client) {
        String id = UUID.randomUUID().toString();
        client.setId(id);
        client.setCreatedAt(LocalDateTime.now());
        client.setUpdatedAt(LocalDateTime.now());
        list.add(client);
        return client;
    }


    public Client get(String id) {
        Client client = list.stream().filter(el -> el.getId().equals(id))
                .findAny().get();
        return client;
    }


    public Client update(Client client) {
        String id = client.getId();
        Client clientToUpdate = this.get(id);
        client.setCreatedAt(clientToUpdate.getCreatedAt());
        int index = list.indexOf(clientToUpdate);
        client.setUpdatedAt(LocalDateTime.now());
        list.remove(clientToUpdate);
        list.add(index, client);

        return client;
    }


    public Client delete(String id) {

        Client client =  this.get(id);
        list.remove(client);

        return client;
    }


    public List<Client> getAll() {
        return list;
    }
}

package edu.oda.controller.rest;

import edu.oda.model.Client;
import edu.oda.service.client.impls.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientRestController {
    @Autowired
    ClientServiceImpl service;

    @RequestMapping("/all")
    public List<Client> getAll(){
        return service.getAll();
    }
    @RequestMapping("/{id}")
    public Client get(@PathVariable("id")String id){
        return service.get(id);
    }
    @RequestMapping("/delete/{id}")
    public Client delete(@PathVariable("id")String id){
        return service.delete(id);
    }
    @PostMapping("/create")
    public Client create(@RequestBody Client client){
        return service.create(client);
    }
    @PostMapping("/update")
    public Client update(@RequestBody Client client){
        return service.update(client);
    }
}

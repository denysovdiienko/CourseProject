package edu.oda.controller.rest;

import edu.oda.model.Item;
import edu.oda.service.item.impls.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemRestController {

    @Autowired
    ItemServiceImpl service;

    @RequestMapping("/all")
    public List<Item> getAll(){
        return service.getAll();
    }

    @RequestMapping("/{id}")
    public Item get(@PathVariable("id") String id){
        return service.get(id);
    }

    @RequestMapping("/delete/{id}")
    public Item delete(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping("/create")
    public Item create(@RequestBody Item item){
        return service.create(item);
    }

    @PostMapping("/update")
    public Item update(@RequestBody Item item){
        return service.update(item);
    }






}
package edu.oda.controller.rest;

import edu.oda.model.TypeOfLoan;
import edu.oda.service.typeOfLoan.impls.TypeOfLoanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/typeofloan")
public class TypeOfLoanRestController {
    @Autowired
    TypeOfLoanServiceImpl service;

    @RequestMapping("/all")
    public List<TypeOfLoan> getAll(){
        return service.getAll();
    }
    @RequestMapping("/{id}")
    public TypeOfLoan get(@PathVariable("id")String id){
        return service.get(id);
    }
    @RequestMapping("/delete/{id}")
    public TypeOfLoan delete(@PathVariable("id")String id){
        return service.delete(id);
    }
    @PostMapping("/create")
    public TypeOfLoan create(@RequestBody TypeOfLoan typeOfLoan){
        return service.create(typeOfLoan);
    }
    @PostMapping("/update")
    public TypeOfLoan update(@RequestBody TypeOfLoan typeOfLoan){
        return service.update(typeOfLoan);
    }
}

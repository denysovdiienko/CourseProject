package edu.oda.controller.rest;

import edu.oda.model.Loan;
import edu.oda.service.loan.impls.LoanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loan")
public class LoanRestController {
    @Autowired
    LoanServiceImpl service;

    @RequestMapping("/all")
    public List<Loan> getAll(){
        return service.getAll();
    }
    @RequestMapping("/{id}")
    public Loan get(@PathVariable("id")String id){
        return service.get(id);
    }
    @RequestMapping("/delete/{id}")
    public Loan delete(@PathVariable("id")String id){
        return service.delete(id);
    }
    @PostMapping("/create")
    public Loan create(@RequestBody Loan loan){
        return service.create(loan);
    }
    @PostMapping("/update")
    public Loan update(@RequestBody Loan loan){
        return service.update(loan);
    }


}

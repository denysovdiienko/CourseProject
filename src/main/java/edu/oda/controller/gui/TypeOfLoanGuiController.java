package edu.oda.controller.gui;

import edu.oda.form.TypeOfLoanCreateForm;
import edu.oda.model.Client;
import edu.oda.model.Loan;
import edu.oda.model.TypeOfLoan;
import edu.oda.form.TypeOfLoanUpdateForm;
import edu.oda.repository.ClientMongoRepository;
import edu.oda.repository.LoanMongoRepository;
import edu.oda.service.typeOfLoan.impls.TypeOfLoanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/gui/typeOfLoan")
public class TypeOfLoanGuiController {
    @Autowired
    private TypeOfLoanServiceImpl service;

    @Autowired
    private ClientMongoRepository clientMongoRepository;

    @Autowired
    private LoanMongoRepository loanMongoRepository;

    @RequestMapping("/all")
    public String getAll(Model model){
        List<TypeOfLoanUpdateForm> typeOfLoans = service.getAll().stream()
                .map(TypeOfLoanUpdateForm::new)
                .collect(Collectors.toList());
        model.addAttribute("typeOfLoans", typeOfLoans);
        return "typeOfLoans";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(Model model, @PathVariable("id") String id){
        service.delete(id);
        return "redirect:/gui/typeOfLoan/all";
    }


    @GetMapping("/create")
    public String create(Model model){
        TypeOfLoanCreateForm formToCreate = new TypeOfLoanCreateForm();
        Map<String, String> clientsMap = getClientsMap();
        Map<String, String> loansMap = getLoansMap();
        model.addAttribute("loans", loansMap);
        model.addAttribute("clients", clientsMap);
        model.addAttribute("form", formToCreate);
        return "typeOfLoan-create";
    }

    @PostMapping("/create")
    public String create( @ModelAttribute("form") TypeOfLoanCreateForm form){
        TypeOfLoan typeOfLoan = new TypeOfLoan();
        Client client = clientMongoRepository.findByName(form.getClient()).get(0);
        String[] loanData = form.getLoan().split(" ");
        Loan loan = loanMongoRepository.findByCodeType(loanData[0])
                .get(0);
        typeOfLoan.setAmount(form.getAmount());
        typeOfLoan.setDateOfIssue(form.getDateOfIssue());
        typeOfLoan.setDescription(form.getDescription());
        typeOfLoan.setLoan(loan);
        typeOfLoan.setClient(client);
        service.create(typeOfLoan);
        return "redirect:/gui/typeOfLoan/all";
    }


    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable("id") String id){
        TypeOfLoanUpdateForm formToUpdate = new TypeOfLoanUpdateForm(service.get(id));
        Map<String, String> clientsMap = getClientsMap();
        Map<String, String> loansMap = getLoansMap();
        model.addAttribute("loans", loansMap);
        model.addAttribute("clients", clientsMap);
        model.addAttribute("form", formToUpdate);
        return "typeOfLoan-update";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("form") TypeOfLoanUpdateForm form, @PathVariable("id") String id){
        TypeOfLoan typeOfLoan = service.get(id);
        Client client = clientMongoRepository.findByName(form.getClient()).get(0);
        String[] loanData = form.getLoan().split(" ");
        Loan loan = loanMongoRepository.findByCodeType(loanData[0])
                .get(0);
        typeOfLoan.setClient(client);
        typeOfLoan.setLoan(loan);
        typeOfLoan.setAmount(form.getAmount());
        typeOfLoan.setDateOfIssue(form.getDateOfIssue());
        typeOfLoan.setDescription(form.getDescription());
        service.update(typeOfLoan);
        return "redirect:/gui/typeOfLoan/all";
    }

    private Map<String, String> getClientsMap() {
        Map<String, String> clientsMap = new LinkedHashMap<>();
        List<Client> clients = clientMongoRepository.findAll();
        clients.stream()
                .map(Client::getName)
                .forEach(stringName -> clientsMap.put(stringName, stringName));
        return clientsMap;
    }

    private Map<String, String> getLoansMap() {
        Map<String, String> loansMap = new LinkedHashMap<>();
        List<Loan> loans = loanMongoRepository.findAll();
        loans.stream()
                .map(loan -> loan.getCodeType() + " ")
                .forEach(stringCodeType -> loansMap.put(stringCodeType, stringCodeType));
        return loansMap;
    }
}

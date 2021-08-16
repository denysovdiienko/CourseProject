package edu.oda.controller.gui;

import edu.oda.form.LoanCreateForm;
import edu.oda.form.LoanUpdateForm;
import edu.oda.model.Loan;
import edu.oda.service.loan.impls.LoanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/gui/loan")
public class LoanGuiCotroller {
    @Autowired
    LoanServiceImpl service;

    @RequestMapping("/all")
    public String getAll(Model model){
        List<Loan> loans = service.getAll();
        model.addAttribute("loans", loans);
        return "loans";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(Model model, @PathVariable("id") String id){
        service.delete(id);

        return "redirect:/gui/loan/all";
    }


    @GetMapping("/create")
    public String create(Model model){
        LoanCreateForm formToCreate = new LoanCreateForm();
        model.addAttribute("form", formToCreate);
        return "loan-create";
    }

    @PostMapping("/create")
    public String create( @ModelAttribute("form") LoanCreateForm form){
        Loan loan = new Loan();
        loan.setCodeType(form.getCodeType());
        loan.setAmount(form.getAmount());
        loan.setDateOfIssue(form.getDateOfIssue());
        loan.setDescription(form.getDescription());


        service.create(loan);

        return "redirect:/gui/loan/all";
    }


    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable("id") String id){
        Loan loan = service.get(id);
        LoanUpdateForm formToUpdate = new LoanUpdateForm();

        formToUpdate.setId(loan.getId());
        formToUpdate.setCodeType(loan.getCodeType());
        formToUpdate.setAmount(loan.getAmount());
        formToUpdate.setDateOfIssue(loan.getDateOfIssue());
        formToUpdate.setDescription(loan.getDescription());
        formToUpdate.setCreatedAt(loan.getCreatedAt());
        formToUpdate.setUpdatedAt(loan.getUpdatedAt());

        model.addAttribute("form", formToUpdate);
        return "loan-update";
    }

    @PostMapping("/update/{id}")
    public String update( @ModelAttribute("form") LoanUpdateForm form){
        Loan loan = new Loan();
        loan.setId(form.getId());
        loan.setCodeType(form.getCodeType());
        loan.setAmount(form.getAmount());
        loan.setDateOfIssue(form.getDateOfIssue());
        loan.setDescription(form.getDescription());
        loan.setCreatedAt(form.getCreatedAt());

        service.update(loan);

        return "redirect:/gui/loan/all";
    }
}

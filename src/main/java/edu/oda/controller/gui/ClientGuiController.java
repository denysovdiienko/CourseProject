package edu.oda.controller.gui;

import edu.oda.form.ClientCreateForm;
import edu.oda.form.ClientUpdateForm;
import edu.oda.model.Client;
import edu.oda.service.client.impls.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/gui/client")
public class ClientGuiController {
    @Autowired
    ClientServiceImpl service;

    @RequestMapping("/all")
    public String getAll(Model model){
        List<Client> clients = service.getAll();
        model.addAttribute("clients", clients);
        return "clients";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(Model model, @PathVariable("id") String id){
        service.delete(id);

        return "redirect:/gui/client/all";
    }


    @GetMapping("/create")
    public String create(Model model){
        ClientCreateForm formToCreate = new ClientCreateForm();
        model.addAttribute("form", formToCreate);
        return "client-create";
    }

    @PostMapping("/create")
    public String create( @ModelAttribute("form") ClientCreateForm form){
        Client client = new Client();
        client.setName(form.getName());
        client.setTypeOfProperty(form.getTypeOfProperty());
        client.setAddress(form.getAddress());
        client.setPhoneNumber(form.getPhoneNumber());
        client.setContactPerson(form.getContactPerson());
        client.setDescription(form.getDescription());

        service.create(client);

        return "redirect:/gui/client/all";
    }


    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable("id") String id){
        Client client = service.get(id);
        ClientUpdateForm formToUpdate = new ClientUpdateForm();

        formToUpdate.setId(client.getId());
        formToUpdate.setName(client.getName());
        formToUpdate.setTypeOfProperty(client.getTypeOfProperty());
        formToUpdate.setAddress(client.getAddress());
        formToUpdate.setPhoneNumber(client.getPhoneNumber());
        formToUpdate.setContactPerson(client.getContactPerson());
        formToUpdate.setDescription(client.getDescription());
        formToUpdate.setCreatedAt(client.getCreatedAt());
        formToUpdate.setUpdatedAt(client.getUpdatedAt());

        model.addAttribute("form", formToUpdate);
        return "client-update";
    }

    @PostMapping("/update/{id}")
    public String update( @ModelAttribute("form") ClientUpdateForm form){
        Client client = new Client();
        client.setId(form.getId());
        client.setName(form.getName());
        client.setTypeOfProperty(form.getTypeOfProperty());
        client.setAddress(form.getAddress());
        client.setPhoneNumber(form.getPhoneNumber());
        client.setContactPerson(form.getContactPerson());
        client.setDescription(form.getDescription());
        client.setCreatedAt(form.getCreatedAt());

        service.update(client);

        return "redirect:/gui/client/all";
    }
}

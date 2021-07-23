package edu.oda.controller.gui;


import edu.oda.model.Item;
import edu.oda.service.item.impls.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/gui/item")
public class ItemGuiController {

    @Autowired
    ItemServiceImpl service;

    @RequestMapping("/all")
    public String getAll(Model model){

        List<Item> items = service.getAll();
        model.addAttribute("items", items);

        return "items";
    }




}
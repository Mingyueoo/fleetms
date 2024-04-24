package com.ming.parameters.controllers;

import com.ming.parameters.models.Contact;
import com.ming.parameters.services.ContactService;
import com.ming.parameters.services.CountryService;
import com.ming.parameters.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ContactController {
    @Autowired
    private ContactService contactService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private StateService stateService;



    //get JSON of a contact
    @GetMapping("/parameters/contact/{id}")
    @ResponseBody
    public Contact getContact(@PathVariable Integer id) {
        return contactService.findById(id);

    }



    //get all contacts
    @GetMapping("/parameters/contacts")
    public String findAll(Model model) {
        List<Contact> contacts = contactService.findAll();
        model.addAttribute("contacts", contacts);
        model.addAttribute("countries",countryService.findAll());
        model.addAttribute("states",stateService.findAll());
        return "parameters/contacts";

    }

    //get into add page
    @GetMapping("/parameters/contactAdd")
    public String addContact() {
        return "parameters/contactAdd";

    }

    //get into edit page
    @GetMapping("/parameters/contacts/Edit/{id}")
    public String editContact(@PathVariable Integer id, Model model) {
        Contact contact = contactService.findById(id);
        model.addAttribute("contact", contact);
        return "parameters/contactEdit";
    }

    // get into detail page
    @GetMapping("/parameters/contacts/Detail/{id}")
    public String detailContact(@PathVariable Integer id, Model model) {
        Contact contact = contactService.findById(id);
        model.addAttribute("contact", contact);
        return "parameters/contactDetails";
    }

    // get into contacts home
    @PostMapping(value = "/parameters/contacts")
    public String save(Contact contact) {
        contactService.save(contact);
        return "redirect:/parameters/contacts";
    }

    // get into contacts home
    @RequestMapping(value = "/parameters/contacts/Delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String delete(@PathVariable Integer id) {
        contactService.delete(id);
        return "redirect:/parameters/contacts";
    }

}

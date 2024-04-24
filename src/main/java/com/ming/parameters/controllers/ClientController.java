package com.ming.parameters.controllers;

import com.ming.parameters.models.Client;
import com.ming.parameters.services.ClientService;
import com.ming.parameters.services.CountryService;
import com.ming.parameters.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private StateService stateService;
    @GetMapping("/parameters/client/{id}")
    @ResponseBody
    public Client getClient(@PathVariable Integer id){
        return clientService.findById(id);

    }

    @GetMapping("/parameters/clients")
    public String finAll(Model model){
        List<Client> clients = clientService.findAll();
        model.addAttribute("clients",clients);
        model.addAttribute("countries",countryService.findAll());
        model.addAttribute("states",stateService.findAll());
        return "parameters/clients";
    }

    @GetMapping("/parameters/clientAdd")
    public String addClient(Model model){

        model.addAttribute("countries", countryService.findAll());
        //model.addAttribute("states",stateService.findAll());
        return "parameters/clientAdd";
    }

    @GetMapping("/parameters/client/Edit/{id}")
    public String editClient(@PathVariable Integer id, Model model){
        Client client = clientService.findById(id);
        model.addAttribute("client",client);
        return "parameters/clients";

    }


    @GetMapping("parameters/client/Detail/{id}")
    public String detailClient(@PathVariable Integer id, Model model){
        Client client = clientService.findById(id);
        model.addAttribute("client",client);
        return "parameters/clientDetails";

    }
    @PostMapping(value = "/parameters/clients")
    public String save(Client client){
        clientService.save(client);
        return "redirect:/parameters/clients";

    }

    @RequestMapping(value = "/parameters/clients/Delete/{id}", method = {RequestMethod.GET,RequestMethod.DELETE})
    public String delete(@PathVariable Integer id){
        clientService.delete(id);
        return "redirect:/parameters/clients";

    }

}

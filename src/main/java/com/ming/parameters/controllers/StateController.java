package com.ming.parameters.controllers;

import com.ming.parameters.models.State;
import com.ming.parameters.services.CountryService;
import com.ming.parameters.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StateController {
    @Autowired
    private StateService stateService;
    @Autowired
    private CountryService countryService;

    public Model addModelAttribute(Model model) {
        model.addAttribute("states", stateService.findAll());
        model.addAttribute("countries", countryService.findAll());
        return model;
    }

    @GetMapping("/parameters/states")
    // @ResponseBody
    public String findAll(Model model) {
        addModelAttribute(model);
        return "parameters/states";
    }

    @GetMapping("/parameters/stateAdd")
    public String addState(Model model) {
        addModelAttribute(model);
        return "parameters/stateAdd";
    }

//    @GetMapping("/parameters/state/{op}/{id}")
//    public String editState(@PathVariable Integer id, @PathVariable String op, Model model) {
//        addModelAttribute(model);
//        model.addAttribute("state", stateService.findById(id));
//
//        return "parameters/states" + op;
//    }

    @GetMapping("/parameters/state/Edit/{id}")
    public String editState(@PathVariable Integer id, Model model) {

        model.addAttribute("state", stateService.findById(id));
        addModelAttribute(model);
        return "parameters/stateEdit" ;
    }


// add state
    @PostMapping(value = "/parameters/states")
    public String addNew(State state) {
        stateService.save(state);
        return "redirect:/parameters/states";
    }

    @GetMapping("/parameters/stateDetails/{id}")
    public String detailsState(@PathVariable Integer id, Model model) {
        State state = stateService.findById(id);
        model.addAttribute("state", state);

        return "parameters/stateDetails";
    }

//    @PostMapping("/states")
//    public String save(State state) {
//        stateService.save(state);
//        return "redirect:/states";
//    }

    @RequestMapping(value = "/parameters/states/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String delete(@PathVariable Integer id) {
        stateService.delete(id);
        return "redirect:/parameters/states";

    }

    @RequestMapping(value = "/states/update/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
    public String update(State state) {
        stateService.save(state);
        return "redirect:/states";

    }
}

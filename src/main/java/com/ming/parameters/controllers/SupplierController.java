package com.ming.parameters.controllers;

import com.ming.parameters.models.Supplier;
import com.ming.parameters.services.CountryService;
import com.ming.parameters.services.StateService;
import com.ming.parameters.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SupplierController {
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private StateService stateService;
    //get Supplier by Id.
    @GetMapping("/parameters/supplier/{id}")
    @ResponseBody
    public Supplier getSupplier(@PathVariable Integer id){
        return supplierService.findById(id);

    }
    //get all suppliers
    @GetMapping("/parameters/suppliers")
    public String finAll(Model model){
        List<Supplier> suppliers = supplierService.findAll();
        model.addAttribute("suppliers",suppliers);
        return "parameters/suppliers";
    }
    //get into add supplier page
    @GetMapping("/parameters/supplierAdd")
    public String addSupplier(Model model){//需要在Supplier页面展示下拉框选择countries
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("states", stateService.findAll());
        return "parameters/supplierAdd";
    }
    //get into supplier edit page
    @GetMapping("/parameters/supplier/Edit/{id}")
    public String editSupplier(@PathVariable Integer id, Model model){
        Supplier supplier = supplierService.findById(id);
        model.addAttribute("supplier",supplier);
        return "parameters/supplierEdit";//再看一下究竟是哪个页面

    }

    //get into supplier details page
    @GetMapping("/parameters/supplier/Details/{id}")
    public String detailsSupplier(@PathVariable Integer id, Model model){
        Supplier supplier = supplierService.findById(id);
        model.addAttribute("supplier",supplier);
        return "parameters/supplierDetails";
    }
    @PostMapping(value ="/parameters/suppliers")
    public String save(Supplier supplier){
        supplierService.save(supplier);
        return "redirect:/parameters/suppliers";
    }
    @RequestMapping(value = "/parameters/suppliers/Delete/{id}", method = {RequestMethod.GET,RequestMethod.DELETE})
    public String delete(@PathVariable Integer id){
        supplierService.delete(id);
        return "redirect:/parameters/suppliers";
    }



}

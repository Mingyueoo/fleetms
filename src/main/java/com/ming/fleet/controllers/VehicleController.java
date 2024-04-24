package com.ming.fleet.controllers;

import com.ming.fleet.models.VehicleType;
import com.ming.fleet.services.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class VehicleController {
    @Autowired
    private VehicleTypeService vehicleTypeService;
    @GetMapping("/fleet/vehicleType/{id}")
    @ResponseBody
    public VehicleType getVehicle(@PathVariable Integer id){
        return vehicleTypeService.findById(id);
    }
    @GetMapping("/fleet/vehicleTypes")
    public String findAll(Model model){
        model.addAttribute("vehicleTypes", vehicleTypeService.findAll());
        return "fleet/vehicleTypes";
    }

    @GetMapping("/fleet/vehicleTypesAdd")
    public String addVehicleTypes(Model model){//没说是否需要添加国家或者地区
        return "fleet/vehicleTypesAdd";

    }
    @GetMapping("/fleet/vehicleTypes/Edit/{id}")
    public String editVehicleTypes(@PathVariable Integer id, Model model){
        model.addAttribute("vehicleTypes", vehicleTypeService.findById(id));
        return "fleet/vehicleTypesEdit";
    }
    @GetMapping("/fleet/vehicleTypes/Details/{id}")
    public  String detailVehicleTypes(@PathVariable Integer id, Model model){
        model.addAttribute("vehicleTypes", vehicleTypeService.findById(id));
        return "fleet/vehicleTypesDetails";
    }
    @PostMapping(value = "/fleet/vehicleTypes")
    public String save(VehicleType vehicleType){
        vehicleTypeService.save(vehicleType);
        return "redirect:/fleet/vehicleTypes";
    }

    @RequestMapping(value = "/fleet/vehicleTypes/Delete/{id}", method = {RequestMethod.GET,RequestMethod.DELETE})
    public String delete(@PathVariable Integer id){
        vehicleTypeService.delete(id);
        return "redirect:/fleet/vehicleTypes";

    }
}

package com.ming.parameters.controllers;

import com.ming.parameters.models.Location;
import com.ming.parameters.services.CountryService;
import com.ming.parameters.services.LocationService;
import com.ming.parameters.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LocationController {
    @Autowired
    private CountryService countryService;
    @Autowired
    private StateService stateService;
    @Autowired
    private LocationService locationService;

    public Model addModelAttribute(Model model){
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("states",stateService.findAll());
        model.addAttribute("locations",locationService.findAll());
        return model;

    }
    //get all locations
    @GetMapping("/parameters/locations")
    public String findAll(Model model){
        addModelAttribute(model);
        return "parameters/locations";

    }
    //add locations-->get into add page.
    @GetMapping("/parameters/locationAdd")
    public String addLocation(Model model){
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("states",stateService.findAll());
//      addModelAttribute(model);//如果只选这个，那么在嵌套筛选的时候，所有的State都会被选进去
      return "parameters/locationAdd";
    }


    //edit location-->get into edit page.
    @GetMapping("/parameters/locations/Edit/{id}")
    public String editLocation(@PathVariable Integer id, Model model){
        model.addAttribute("location",locationService.findById(id));
        addModelAttribute(model);
        return "parameters/locationEdit";

    }

//    @GetMapping("/parameters/locations/{op}/{id}")
//    public String editLocation(@PathVariable Integer id, @PathVariable String op, Model model){
//        Location location = locationService.findById(id);
//
//        model.addAttribute("location",location);
//        addModelAttribute(model);
//        return "parameters/location"+op;//return locationEdit or return locationDetails
//
//    }

    //add new location and back to location home.
    @PostMapping(value = "/parameters/locations")
    public String addNew(Location location){
        locationService.save(location);
        return "redirect:/parameters/locations";
    }

    //look up location details
    @GetMapping("/parameters/locationDetails/{id}")
    public String detailLocation(@PathVariable Integer id, Model model){
        model.addAttribute("location", locationService.findById(id));
        return "parameters/locationDetails";
    }

    //delete a location by Id.
    @RequestMapping(value = "/parameters/locations/Delete/{id}",method = {RequestMethod.GET,RequestMethod.DELETE})
    public String delete(@PathVariable Integer id){
        locationService.delete(id);
        return "redirect:/parameters/locations";
    }

    //update a location, update not need an Id.
    @RequestMapping(value = "/parameters/locations/Update/{id}",method = {RequestMethod.GET,RequestMethod.PUT})
    public String update(Location location){
        locationService.save(location);
        return "redirect:/parameters/locations";
    }

}

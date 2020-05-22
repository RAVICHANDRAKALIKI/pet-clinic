package dev.ravi.petclinic.controllers;


import dev.ravi.petclinic.StringConstants;
import dev.ravi.petclinic.data.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vets")
public class VetController {

    private VetService vetService;

    @Autowired
    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"","/","vet","vet.html"})
    public String getList(Model model) {
        model.addAttribute(StringConstants.APP_NAME_ATTR, StringConstants.APPLICATION_NAME);
        model.addAttribute("vetHeading", "Vets View");
        return "vet";
    }
}

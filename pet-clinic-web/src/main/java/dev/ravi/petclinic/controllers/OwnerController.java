package dev.ravi.petclinic.controllers;

import dev.ravi.petclinic.StringConstants;
import dev.ravi.petclinic.data.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"","/","owner","owner.html"})
    public String getOwners(Model model) {
        model.addAttribute(StringConstants.APP_NAME_ATTR, StringConstants.APPLICATION_NAME);
        model.addAttribute("ownerHeading", "Öwners View");
        return "owner";
    }
}

package dev.ravi.petclinic.controllers;

import dev.ravi.petclinic.StringConstants;
import dev.ravi.petclinic.data.models.Owner;
import dev.ravi.petclinic.data.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private OwnerService ownerService;
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"","/","/list"})
    public String getOwners(Model model) {
        model.addAttribute(StringConstants.APP_NAME_ATTR, StringConstants.APPLICATION_NAME);
        model.addAttribute("ownerHeading", "Owners View");
        model.addAttribute("owners", ownerService.findAll());
        return "owner";
    }

    @RequestMapping("/{ownerId:^[0-9]+$}")
    public String OwnerPets(@PathVariable Long ownerId, Model model) {
        model.addAttribute(StringConstants.APP_NAME_ATTR, StringConstants.APPLICATION_NAME);
        model.addAttribute("ownerPetHeading", "Owner Information View");
        Owner myOwner = null;
        try {
            myOwner = ownerService.findById(ownerId);
        } catch (RuntimeException e) {
            myOwner = new Owner("Owner Not Found","");
            myOwner.setId(0L);
        }
        model.addAttribute("owner", myOwner);
        model.addAttribute("pets", myOwner.getPetList());
        return "ownerPet";
    }
}

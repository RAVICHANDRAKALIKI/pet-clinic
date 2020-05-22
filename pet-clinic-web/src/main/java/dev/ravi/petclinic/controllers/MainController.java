package dev.ravi.petclinic.controllers;

import dev.ravi.petclinic.StringConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping({"/","","index","index.html"})
    public String getMain(Model model) {
        model.addAttribute(StringConstants.APP_NAME_ATTR, StringConstants.APPLICATION_NAME);
        model.addAttribute("MainHeading","Home Page");
        return "index";
    }
}

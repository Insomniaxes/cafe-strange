package be.cafe_strange.controllers;

import be.cafe_strange.interfaces.services.general.GeneralInfoService;
import be.cafe_strange.models.main.GeneralInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/generalInfo")
public class GeneralController {

    private final String VIEW = "/generalInfo";
    private final String FOLDER = "WEB-INF/components/generalInfo";

    @Autowired
    private GeneralInfoService generalInfoService;

    @RequestMapping(method = RequestMethod.GET)
    public String getGeneralInfo(Model model) {
        model.addAttribute("page", FOLDER + "/generalInfo");
        model.addAttribute("info", generalInfoService.findGeneralInfo());
        return VIEW;
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MASTER')")
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editGeneralInfo(Model model) {
        model.addAttribute("page", FOLDER + "/infoForm");
        model.addAttribute("info", generalInfoService.findGeneralInfo());
        return VIEW;
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MASTER')")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateGeneralInfo(GeneralInfo generalInfo) {
        generalInfoService.update(generalInfo);
        return "redirect:/index";
    }

}

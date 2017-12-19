package cafe_strange.controllers;

import cafe_strange.interfaces.services.GeneralInfoService;
import cafe_strange.models.main.GeneralInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/generalinfo")
public class GeneralController {

    @Autowired
    private GeneralInfoService generalInfoService;

    @RequestMapping(method = RequestMethod.GET)
    public String getGeneralInfo(Model model) {
        model.addAttribute("generalInfo", generalInfoService.findGeneralInfo());
        return "/general/generalInfo";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editGeneralInfo(Model model) {
        model.addAttribute("generalInfo", generalInfoService.findGeneralInfo());
        return "/general/generalInfoEdit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateGeneralInfo(GeneralInfo generalInfo) {
        generalInfoService.updatGeneralInfo(generalInfo);
        return "/index";
    }

}

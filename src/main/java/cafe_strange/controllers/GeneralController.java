package cafe_strange.controllers;

import cafe_strange.interfaces.services.general.GeneralInfoService;
import cafe_strange.models.main.GeneralInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/generalInfo")
public class GeneralController {

    private final String VIEW = "/general/info";
    private final String FOLDER = "WEB-INF/components/general/";

    @Autowired
    private GeneralInfoService generalInfoService;

    @RequestMapping(method = RequestMethod.GET)
    public String getGeneralInfo(Model model) {
        model.addAttribute("page", FOLDER + "generalInfo");
        GeneralInfo generalInfo = generalInfoService.findGeneralInfo();
        model.addAttribute("info", generalInfo);
        return VIEW;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editGeneralInfo(Model model) {
        model.addAttribute("page", FOLDER + "infoForm");
        model.addAttribute("info", generalInfoService.findGeneralInfo());
        return VIEW;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateGeneralInfo(GeneralInfo generalInfo) {
        generalInfoService.update(generalInfo);
        return "redirect:/index";
    }

}

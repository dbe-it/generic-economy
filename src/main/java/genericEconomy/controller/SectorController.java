package genericEconomy.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.SessionScope;

import genericEconomy.data.location.Sector;
import genericEconomy.data.repository.BiomRepository;
import genericEconomy.data.repository.SectorRepository;
import genericEconomy.exception.SectorNotFoundException;


@Controller
@RequestMapping(value = "/sector")
@SessionScope
public class SectorController {

    @Autowired
    SectorRepository sectorRepository;

    @Autowired
    BiomRepository biomRepository;

    @RequestMapping(method = GET)
    public String sector(Model model) {
        model.addAttribute("bioms",biomRepository.findAllAndFetchSectorsEagerly());
        return "sector";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String sectorById(@PathVariable Long id, Model model) {
        Sector sector = sectorRepository.findByIdAndFetchModulesEagerly(id);
        if (sector == null) {
            throw new SectorNotFoundException(id);
        }
        model.addAttribute(sector);
        model.addAttribute("bioms",biomRepository.findAllAndFetchSectorsEagerly());
        return "sector";
    }

}

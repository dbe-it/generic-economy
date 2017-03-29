package genericEconomy.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import genericEconomy.data.location.Biom;
import genericEconomy.data.repository.BiomRepository;
import genericEconomy.exception.BiomNotFoundException;


@Controller
@RequestMapping(value = "/biom")
public class BiomController {

    @Autowired
    BiomRepository biomRepository;

    @RequestMapping(method = GET)
    public String biom(Model model) {
        model.addAttribute("bioms", biomRepository.findAllAndFetchSectorsEagerly());
        return "biom";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String biomById(@PathVariable Long id, Model model) {
        Biom biom = biomRepository.findByIdAndFetchSectorsEagerly(id);
        if (biom == null) {
            throw new BiomNotFoundException(id);
        }
        model.addAttribute(biom);
        model.addAttribute("bioms", biomRepository.findAllAndFetchSectorsEagerly());
        return "biom";
    }

    public String testButtonAction() {
        System.out.println("testButtonAction invoked");
        return "anotherPage.xhtml";
    }

    public void testButtonActionListener(ActionEvent event) {
        System.out.println("testButtonActionListener invoked");
    }

}

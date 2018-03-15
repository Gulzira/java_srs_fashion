package kz.kaznitu.lessons.controllers;

import kz.kaznitu.lessons.models.Dress;
import kz.kaznitu.lessons.reposotories.DressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/dress")
public class DressController {
    @Autowired
    private DressRepository dressRepository;
    private long a;

    @RequestMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("dress", new Dress());
        return "dress_add_form";
    }


    @PostMapping("/add")
    public String addDress(@ModelAttribute Dress dress) {
        dressRepository.save(dress);
        return "redirect:/dress/all";
    }


    @GetMapping("/all2")
    public @ResponseBody
    Iterable<Dress> allDresss() {
        return dressRepository.findAll();
    }

    @GetMapping("/all")
    public String allDeliveries2(Model model) {
        List<Dress> deliveries = (List<Dress>) dressRepository.findAll();
        model.addAttribute("dresss", deliveries);
        return "dresss";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteContact(@RequestParam("id") long idd) {
        dressRepository.deleteById(idd);
        return new ModelAndView("redirect:/dress/all");

    }

    @PostMapping("/editDress")
    public String editDress(@ModelAttribute Dress dress) {
        Dress dress1 = new Dress();
        dress1.setTitle(dress.getTitle());
        dress1.setGuest(dress.getGuest());
        dress1.setPrice(dress.getPrice());
        dress1.setSummary(dress.getSummary());
        dress1.setBrand(dress.getBrand());
        return "redirect:/delivery/all2";
    }

    @RequestMapping(value = "/editDress", method = RequestMethod.GET)
    public ModelAndView editDress(Model model, @RequestParam("id") long id) {
        a = id;
        Optional<Dress> dress = (Optional<Dress>) dressRepository.findById(id);
        model.addAttribute("dress", dress);
        return new ModelAndView("editDress");
    }

    @RequestMapping("/editDelivery")
    public String showForm2(Model model) {
        model.addAttribute("dress", new Dress());
        return "editDress";
    }
}


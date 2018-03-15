package kz.kaznitu.lessons.controllers;

import kz.kaznitu.lessons.models.DressInstance;
import kz.kaznitu.lessons.reposotories.DressInstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/dress")
public class DressInstanceController {
    @Autowired
    private DressInstanceRepository dressInstanceRepository;
    private long a;
    @RequestMapping("/add")
    public String showForm(Model model){
        model.addAttribute("dress",new DressInstance());
        return "dress_add_form";
    }


    @PostMapping("/add")
    public String addDress(@ModelAttribute DressInstance dressInstance){
        dressInstanceRepository.save(dressInstance) ;
        return "redirect:/dress/all" ;
    }


    @GetMapping("/all2")
    public @ResponseBody Iterable<DressInstance> allDress(){
        return dressInstanceRepository.findAll() ;
    }

    @GetMapping("/all")
    public String allDress2(Model model){
        List<DressInstance> dressInstances = (List<DressInstance>) dressInstanceRepository.findAll() ;
        model.addAttribute("dresss", dressInstances) ;
        return "dresss" ;
    }

    @RequestMapping(value = "/deleteContact",method = RequestMethod.GET)
    public ModelAndView deleteContact(@RequestParam("id") long idd){
        dressInstanceRepository.deleteById(idd);
        return new ModelAndView("redirect:/dress/all");
    }
    @PostMapping("/editDress")
    public String editTeacher(@ModelAttribute DressInstance dressInstance) {
        DressInstance dressInstance1 = new DressInstance();
        dressInstance1.setId(a);
        dressInstance1.setModel(dressInstance.getModel());
        dressInstance1.setSize(dressInstance.getSize());
        dressInstance1.setBrand(dressInstance.getBrand());
        dressInstanceRepository.save(dressInstance1);
        return "redirect:/dress/all2";
    }

    @RequestMapping(value = "/editDress",method = RequestMethod.GET)
    public ModelAndView editDress(Model model,@RequestParam("id") long id){
        a=id;
        Optional<DressInstance> phone = (Optional<DressInstance>) dressInstanceRepository.findById(id);
        model.addAttribute("dress",phone);
        return new ModelAndView("editDress");
    }
    @RequestMapping("/editDress")
    public String showForm2(Model model){
        model.addAttribute("dress",new DressInstance());
        return "editDress";
    }




}

package kz.kaznitu.lessons.controllers;

import kz.kaznitu.lessons.models.Brand;
import kz.kaznitu.lessons.reposotories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/brand")
public class BrandController {
    @Autowired
    private BrandRepository brandRepository;
    private long a;
    @RequestMapping("/add")
    public String showForm(Model model){
        model.addAttribute("brand",new Brand());
        return "brand_add_form";
    }


    @PostMapping("/add")
    public String addbrand(@ModelAttribute Brand brand){
        brandRepository.save(brand) ;
        return "redirect:/brand/all" ;
    }


    @GetMapping("/all2")
    public @ResponseBody
    Iterable<Brand> allBrand(){
        return brandRepository.findAll() ;
    }

    @GetMapping("/all")
    public String allBrand2(Model model){
        List<Brand> brands = (List<Brand>) brandRepository.findAll() ;
        model.addAttribute("Brands", brands) ;
        return "brands" ;
    }

    @RequestMapping(value = "/deleteContact",method = RequestMethod.GET)
    public ModelAndView deleteContact(@RequestParam("id") long idd){
        brandRepository.deleteById(idd);
        return new ModelAndView("redirect:/brand/all");
    }
    @PostMapping("/editBrand")
    public String editNotebook(@ModelAttribute Brand brand) {
        Brand brand1 = new Brand();
        brand1.setId(a);
        brand1.setName(brand.getName());
        brand1.setStrana(brand.getStrana());
        brandRepository.save(brand);
        return "redirect:/notebook/all2";
    }

    @RequestMapping(value = "/editBrand",method = RequestMethod.GET)
    public ModelAndView editNotebook(Model model,@RequestParam("id") long id){
        a=id;
        Optional<Brand> notebook = (Optional<Brand>) brandRepository.findById(id);
        model.addAttribute("Brand",notebook);
        return new ModelAndView("editBrand");
    }
    @RequestMapping("/editBrand")
    public String showForm2(Model model){
        model.addAttribute("Brand",new Brand());
        return "editBrand";
    }




}


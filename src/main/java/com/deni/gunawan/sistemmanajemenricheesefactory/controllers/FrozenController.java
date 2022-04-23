package com.deni.gunawan.sistemmanajemenricheesefactory.controllers;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Frozen;
import com.deni.gunawan.sistemmanajemenricheesefactory.services.FrozenService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/frozen")
@Slf4j
public class FrozenController {

        private FrozenService frozenService;

        @GetMapping(value = "/index")
        public String getList(ModelMap map){
            map.addAttribute("list", frozenService.getList());
            return "pages/frozen/index";
        }

        @GetMapping(value = "/form")
        public String getForm(ModelMap map){
            Frozen frozen = new Frozen();
            map.addAttribute("frozen", frozen);
            return "pages/frozen/form";
        }

    @GetMapping(value = "/form/{id}")
    public String showEditForm(Model model, @PathVariable(value = "id") String id){
        try {
            Frozen frozen = frozenService.findById(id)
                    .orElseThrow(()
                            -> new IllegalArgumentException("Gagal Get Data Id : " + id));
            model.addAttribute("frozen", frozen);
            return "pages/frozen/edit";
        }catch (Exception e){
            return "pages/frozen/index";
        }
    }

    @PostMapping("/update/{id}")
    public String updateData(Model model, @ModelAttribute(value = "frozen") Frozen frozen) {
        {
            model.addAttribute("frozen", frozen);
            frozenService.save(frozen);
            return "redirect:/frozen/index";
        }
    }
        @GetMapping(value = "/delete/{id}")
        public String remove(@PathVariable(value = "id") String id){
            this.frozenService.delete(id);
            return "redirect:/frozen/index";
        }

        @PostMapping(value = "/submit")
        public String saved(@Valid @ModelAttribute Frozen frozen,
                            BindingResult result){
            if(result.hasErrors()){
                return "pages/frozen/form";
            }
            frozenService.save(frozen);
            return "redirect:/frozen/index";
        }


        // public generateExcel
        // public GeneratePDF
}

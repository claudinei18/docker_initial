package com.example.tddtutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class SalarioMinimoController {

    @Autowired
    SalarioMinimoService salarioMinimoService;

    @GetMapping("/salarios")
    @ResponseBody
    public String index() {
        return "index";
    }

    @GetMapping("/salarios/novo")
    public String save(Model model, @ModelAttribute("salarioMinimo") SalarioMinimo salarioMinimo) {
        return "save";
    }

    @PostMapping("/salarios")
    public String save(@Valid @ModelAttribute("salarioMinimo") SalarioMinimo salarioMinimo, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        try {
            salarioMinimoService.save(salarioMinimo);
            redirectAttributes.addFlashAttribute("sucesso", "Salário salvo com sucesso.");
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "Problema ao salvar salário.");
        }
        return "redirect:/salarios/novo";
    }
}

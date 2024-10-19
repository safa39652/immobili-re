package com.example.demo.controller;


import com.example.demo.*;.model.Annonce;
import com.immobilier.repository.AnnonceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AnnonceRepository annonceRepository;

    @GetMapping("/annonces")
    public String listerAnnonces(Model model) {
        model.addAttribute("annonces", annonceRepository.findAll());
        return "admin/liste_annonces"; // Vue Thymeleaf
    }

    @GetMapping("/annonces/ajouter")
    public String afficherFormAjout(Model model) {
        model.addAttribute("annonce", new Annonce());
        return "admin/ajouter_annonce"; // Vue Thymeleaf
    }

    @PostMapping("/annonces/ajouter")
    public String ajouterAnnonce(@ModelAttribute Annonce annonce) {
        annonceRepository.save(annonce);
        return "redirect:/admin/annonces";
    }

    // Méthodes pour modifier et supprimer des annonces
}

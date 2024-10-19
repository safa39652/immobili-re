package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Annonce;
import com.example.demo.repository.AnnonceRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AnnonceRepository annonceRepository;

    // Afficher la liste des annonces
    @GetMapping("/annonces")
    public String listerAnnonces(Model model) {
        model.addAttribute("annonces", annonceRepository.findAll());
        return "admin/liste_annonces"; // Vue Thymeleaf pour la liste des annonces
    }

    // Afficher le formulaire pour ajouter une nouvelle annonce
    @GetMapping("/annonces/ajouter")
    public String afficherFormAjout(Model model) {
        model.addAttribute("annonce", new Annonce());
        return "admin/ajouter_annonce"; // Vue Thymeleaf pour ajouter une annonce
    }

    // Traiter l'ajout d'une nouvelle annonce
    @PostMapping("/annonces/ajouter")
    public String ajouterAnnonce(@ModelAttribute Annonce annonce) {
        annonceRepository.save(annonce);
        return "redirect:/admin/annonces"; // Rediriger vers la liste des annonces après l'ajout
    }

    // Afficher le formulaire pour modifier une annonce existante
    @GetMapping("/annonces/modifier/{id}")
    public String modifierAnnonce(@PathVariable Long id, Model model) {
        Annonce annonce = annonceRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Annonce non trouvée : " + id));
        model.addAttribute("annonce", annonce);
        return "admin/ajouter_annonce"; // Réutilise le même formulaire pour modifier une annonce
    }

    // Traiter la suppression d'une annonce
    @GetMapping("/annonces/supprimer/{id}")
    public String supprimerAnnonce(@PathVariable Long id) {
        annonceRepository.deleteById(id);
        return "redirect:/admin/annonces"; // Rediriger vers la liste après suppression
    }
}

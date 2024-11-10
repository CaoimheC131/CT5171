// src/main/java/com/<your_first_name>/spetitions/controller/PetitionController.java
package com.caoimhe.petitions.controller;

import com.caoimhe.petitions.petitions.model.Petition;
import com.caoimhe.petitions.petitions.repository.PetitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/petitions")
public class PetitionController {

    @Autowired
    private PetitionRepository petitionRepository;

    // View all petitions
    @GetMapping
    public String viewAllPetitions(Model model) {
        model.addAttribute("petitions", petitionRepository.findAll());
        return "petitions";
    }

    // View a single petition and sign
    @GetMapping("/{id}")
    public String viewPetition(@PathVariable Long id, Model model) {
        petitionRepository.findById(id).ifPresent(petition -> model.addAttribute("petition", petition));
        return "petition";
    }

    // Create new petition form
    @GetMapping("/new")
    public String createPetitionForm(Model model) {
        model.addAttribute("petition", new Petition(null, "", ""));
        return "createPetition";
    }

    // Handle submission of new petition
    @PostMapping("/new")
    public String createPetition(@ModelAttribute Petition petition) {
        petitionRepository.save(petition);
        return "redirect:/petitions";
    }

    // Search petitions by title
    @GetMapping("/search")
    public String searchPetitions(@RequestParam String keyword, Model model) {
        List<Petition> results = petitionRepository.findAll().stream()
                .filter(p -> p.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
        model.addAttribute("results", results);
        return "searchResults";
    }
}

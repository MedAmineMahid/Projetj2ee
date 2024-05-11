package gym.projetj2ee.controllers;

import gym.projetj2ee.entities.Adhesion;
import gym.projetj2ee.entities.EntraineurPersonnel;
import gym.projetj2ee.repositories.AdhesionRepository;
import gym.projetj2ee.repositories.EntraineurPersonnelRepository;
import gym.projetj2ee.services.AdhesionServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {
    private final AdhesionServiceImpl adhesionService;
    private final AdhesionRepository adhesionRepository;

    public HomeController(AdhesionServiceImpl adhesionService, AdhesionRepository adhesionRepository) {
        this.adhesionService = adhesionService;
        this.adhesionRepository = adhesionRepository;
    }


    @GetMapping("/")
    public String home() {
        return "home";  // Retourne home.html
    }

    @GetMapping("/services")
    public String services() {
        return "services";  // Retourne services.html
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";  // Retourne contact.html
    }

    @GetMapping("/Adhesions")
    public String Adhesions(Model model) {
            List<Adhesion> adhesions = adhesionService.getAllAdhesion();
            model.addAttribute("adhesions", adhesions); // Note the plural attribute name "adhesions"
       // System.out.println(adhesions);
        return "home";
    }


    @PostMapping("/submit-contact")
    public ModelAndView submitContact(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("subject") String subject,
            @RequestParam("message") String message) {
        // Ici, implémentez la logique pour traiter les informations du formulaire
        System.out.println("Message reçu de : " + name + ", Email : " + email);
        System.out.println("Sujet : " + subject);
        System.out.println("Message : " + message);

        // Après le traitement, redirigez vers une page ou retournez avec un message de confirmation
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "Merci, votre message a été envoyé avec succès.");
        modelAndView.setViewName("contact"); // Redirige vers la même page avec un message de confirmation
        return modelAndView;
    }
}

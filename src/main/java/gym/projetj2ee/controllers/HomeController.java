package gym.projetj2ee.controllers;

import gym.projetj2ee.repositories.AdhesionRepository;
import gym.projetj2ee.repositories.RendezVousRepository;
import gym.projetj2ee.services.AdhesionService;
import gym.projetj2ee.services.ClientService;
import gym.projetj2ee.services.EntrainneurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@RequestMapping("/Client/home")

@Controller
public class HomeController {
    private final EntrainneurService entrainneurService;
    private final RendezVousRepository rendezVousRepository; // Inject the repository
private final AdhesionService adhesionService;
private final AdhesionRepository adhesionRepository;
    public HomeController(EntrainneurService entrainneurService, RendezVousRepository rendezVousRepository, AdhesionService adhesionService, AdhesionRepository adhesionRepository) {
        this.entrainneurService = entrainneurService;
        this.rendezVousRepository = rendezVousRepository;
        this.adhesionService = adhesionService;
        this.adhesionRepository = adhesionRepository;
    }


    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("entraineures", entrainneurService.getAllEntraineurs());
        model.addAttribute("adhesions", adhesionService.getAllAdhesion());

        return "Client/home";  // Return the correct Thymeleaf template path

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

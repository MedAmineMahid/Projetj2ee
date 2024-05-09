package gym.projetj2ee.controllers;

import gym.projetj2ee.entities.Client;
import gym.projetj2ee.entities.RendezVous;
import gym.projetj2ee.repositories.RendezVousRepository;
import gym.projetj2ee.services.ClientService;
import gym.projetj2ee.services.RendezVousService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.UUID;

@Controller
@RequestMapping("/Admin/dashboard")
public class DashboardController {

    private final ClientService clientService;
    private final RendezVousService rendezVousService;
    private final RendezVousRepository rendezVousRepository; // Inject the repository

    public DashboardController(ClientService clientService, RendezVousService rendezVousService, RendezVousRepository rendezVousRepository) {
        this.clientService = clientService;
        this.rendezVousService = rendezVousService;
        this.rendezVousRepository = rendezVousRepository; // Initialize the repository
    }
    @PostMapping("/client/save")
    public String saveClient(@ModelAttribute Client client, Model model) {
        client.setUserid((UUID.randomUUID().toString()));

        clientService.saveClient(client);
        return "redirect:/Admin/dashboard"; // Redirect to dashboard after saving
    }


    @RequestMapping("/client/edit/{userid}")
    public String editClient(@PathVariable String userid, Client client) {
        clientService.updateClient(client);
        return "Admin/dashboard"; // adjust path if needed
    }

    @RequestMapping("/client/delete/{userid}")
    public String deleteClient(@PathVariable String userid, Client client) {
        clientService.deleteClientById(userid);
        return "redirect:/Admin/dashboard"; // redirect to main dashboard after deletion
    }
    @PostMapping("/rendezvous/save")
    public String saveRendezVous(@ModelAttribute @Valid RendezVous rendezVous, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "error"; // Return error page or handle validation errors appropriately
        }

        // Validate and convert time string to ZonedDateTime
        String timeString = rendezVous.getTime().toString(); // Assuming getTime() returns ZonedDateTime directly
        LocalTime localTime = LocalTime.parse(timeString);
        ZonedDateTime time = ZonedDateTime.now().with(localTime);

        rendezVous.setTime(time);

        rendezVousService.saveRendezVous(rendezVous);
        return "redirect:/Admin/dashboard"; // Redirect to dashboard after saving
    }


    @RequestMapping("/rendezVous/edit/{id}")
    public String editRendezVous(@PathVariable Long id, RendezVous rendezVous) {
        rendezVousService.updateRendezVous(rendezVous);
        return "Admin/dashboard"; // adjust path if needed
    }

    @RequestMapping("/rendezVous/delete/{id}")
    public String deleteRendezVous(@PathVariable Long id, RendezVous rendezVous) {
        rendezVousService.deleteRendezVousById(id);
        return "redirect:/Admin/dashboard"; // redirect to main dashboard after deletion
    }

    @GetMapping("")
    public String showDashboard(Model model) {
        model.addAttribute("clients", clientService.getAllClients());
        model.addAttribute("rendezvousList", rendezVousService.getAllRendezVous());
        model.addAttribute("client", new Client()); // For the form to add or edit clients
        model.addAttribute("rendezvous", new RendezVous()); // For the form to add rendezvous
        return "Admin/dashboard"; // Note the path here matches the folder structure under /templates,;/
    }



}

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

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
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

    @PostMapping("/client/changeState") // Add new mapping for changing client state to paid
    public String changeClientState(@RequestParam String userid) {
        Client client = clientService.getClientById(userid);
        client.setPaid(true); // Set the client's paid status to true
        clientService.updateClient(client); // Update the client
        return "redirect:/Admin/dashboard"; // Redirect to dashboard after changing state
    }

    @RequestMapping("/client/delete/{userid}")
    public String deleteClient(@PathVariable String userid, Client client) {
        clientService.deleteClientById(userid);
        return "redirect:/Admin/dashboard"; // redirect to main dashboard after deletion
    }
    @PostMapping("/rendezvous/save")
    public String saveRendezVous(@RequestParam("clientId") String clientId,
                                 @RequestParam("time") String time,
                                 @RequestParam("date") String date,
                                 Model model) {
        Client client = clientService.getClientById(clientId);
        if (client == null) {
            model.addAttribute("error", "Client not found");
            return "error";
        }

        RendezVous rendezVous = new RendezVous();
        rendezVous.setClient(client);
        rendezVous.setDate(date);
        rendezVous.setTime(time);

        rendezVousService.saveRendezVous(rendezVous);

        return "redirect:/Admin/dashboard";
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
        List<Client> clients = clientService.getAllClients();

        long paidCount = clients.stream().filter(Client::isPaid).count();
        long unpaidCount = clients.size() - paidCount;
        model.addAttribute("clients", clients);
        model.addAttribute("paidCount", paidCount);
        model.addAttribute("unpaidCount", unpaidCount);
        model.addAttribute("rendezvousList", rendezVousService.getAllRendezVous());
        model.addAttribute("client", new Client()); // For the form to add or edit clients
        model.addAttribute("rendezvous", new RendezVous()); // For the form to add rendezvous
        return "Admin/dashboard"; // Note the path here matches the folder structure under /templates,/
    }
}

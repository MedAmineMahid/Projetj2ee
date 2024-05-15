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
    private final RendezVousRepository rendezVousRepository;
    public DashboardController(ClientService clientService, RendezVousService rendezVousService, RendezVousRepository rendezVousRepository) {
        this.clientService = clientService;
        this.rendezVousService = rendezVousService;
        this.rendezVousRepository = rendezVousRepository;
    }
    @PostMapping("/client/save")
    public String saveClient(@ModelAttribute Client client, Model model) {
        client.setUserid((UUID.randomUUID().toString()));

        clientService.saveClient(client);
        return "redirect:/Admin/dashboard";     }

    @PostMapping("/client/changeState")
    public String changeClientState(@RequestParam String userid) {
        Client client = clientService.getClientById(userid);
        client.setPaid(true);
        clientService.updateClient(client);
        return "redirect:/Admin/dashboard";  }

    @RequestMapping("/client/delete/{userid}")
    public String deleteClient(@PathVariable String userid, Client client) {
        clientService.deleteClientById(userid);
        return "redirect:/Admin/dashboard";
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
        model.addAttribute("client", new Client());
        model.addAttribute("rendezvous", new RendezVous());
        return "Admin/dashboard"; }
}

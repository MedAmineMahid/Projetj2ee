package gym.projetj2ee.controllers;

import gym.projetj2ee.entities.Client;
import gym.projetj2ee.entities.RendezVous;
import gym.projetj2ee.repositories.RendezVousRepository;
import gym.projetj2ee.services.ClientService;
import gym.projetj2ee.services.RendezVousService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RendezVousController {
    private final ClientService clientService;
    private final RendezVousService rendezVousService;
    private final RendezVousRepository rendezVousRepository;

    public RendezVousController(ClientService clientService,RendezVousService rendezVousService, RendezVousRepository rendezVousRepository) {
        this.clientService = clientService;
        this.rendezVousService = rendezVousService;
        this.rendezVousRepository = rendezVousRepository;
    }



    @RequestMapping("/Admin/rendezvous")
    public String rendezVous(Model model){
        List<Client> clients = clientService.getAllClients();


        model.addAttribute("clients", clients);

        model.addAttribute("rendezvousList", rendezVousService.getAllRendezVous());
        model.addAttribute("client", new Client()); // For the form to add or edit clients
        model.addAttribute("rendezvous", new RendezVous()); // For the form to add rendezvous
        return "Admin/rendezVous"; // Note the path here matches the folder structure under /templates,/
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

        return "redirect:/Admin/rendezvous";
    }


    @RequestMapping("/rendezvous/delete/{id}")
    public String deleteRendezVous(@PathVariable Long id, RendezVous rendezVous) {
        rendezVousService.deleteRendezVousById(id);
        return "redirect:/Admin/rendezvous"; // redirect to main dashboard after deletion
    }

}

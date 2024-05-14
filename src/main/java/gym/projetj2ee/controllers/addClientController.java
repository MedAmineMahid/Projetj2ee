package gym.projetj2ee.controllers;

import gym.projetj2ee.entities.Client;
import gym.projetj2ee.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@AllArgsConstructor
public class addClientController {
    private final ClientService clientService;
    @RequestMapping("/Admin/addClient")
    public String CreateCustomer(){
        return "/Admin/addClient";
    }

    @PostMapping("/client/save")
    public String saveClient(@ModelAttribute Client client, Model model) {
        client.setUserid((UUID.randomUUID().toString()));

        clientService.saveClient(client);
        return "redirect:/Admin/dashboard"; // Redirect to dashboard after saving
    }
}

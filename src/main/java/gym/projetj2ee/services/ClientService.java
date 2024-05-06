package gym.projetj2ee.services;

import gym.projetj2ee.entities.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {
    Client saveClient(Client client);
    Client updateClient(Client client);
    void deleteClientById(String userid);
    void deleteAllClient();
    Client getClientById(String userid);
    List <Client> getAllClients();
}

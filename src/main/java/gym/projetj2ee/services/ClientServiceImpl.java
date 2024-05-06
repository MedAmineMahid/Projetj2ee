package gym.projetj2ee.services;

import gym.projetj2ee.entities.Client;
import gym.projetj2ee.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService{
    private ClientRepository clientRepository;
    @Override
    public Client saveClient(Client client){
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void deleteClientById(String userid) {
        clientRepository.deleteById(userid);
    }

    @Override
    public void deleteAllClient() {
        clientRepository.deleteAll();
    }

    @Override
    public Client getClientById(String userid) {
        return clientRepository.findById(userid).get();
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
}

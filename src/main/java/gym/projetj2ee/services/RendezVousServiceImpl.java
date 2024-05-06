package gym.projetj2ee.services;

import gym.projetj2ee.entities.Client;
import gym.projetj2ee.entities.RendezVous;
import gym.projetj2ee.repositories.ClientRepository;
import gym.projetj2ee.repositories.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RendezVousServiceImpl implements RendezVousService {
    @Autowired
    public RendezVousServiceImpl(RendezVousRepository rendezVousRepository) {
        this.rendezVousRepository = rendezVousRepository;
    }


    private RendezVousRepository rendezVousRepository;
    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }
    @Override
    public RendezVous updateRendezVous(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }
    @Override
    public void deleteRendezVousById(Long id) {
        rendezVousRepository.deleteById(id);
    }

    @Override
    public List<RendezVous> getAllRendezVous() {
        return rendezVousRepository.findAll();
    }

    @Override
    public RendezVous getRendezVousById(Long id) {
        return rendezVousRepository.findById(id).get();
    }
}

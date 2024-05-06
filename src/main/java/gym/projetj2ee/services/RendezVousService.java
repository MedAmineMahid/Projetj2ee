package gym.projetj2ee.services;

import gym.projetj2ee.entities.RendezVous;

import java.util.List;

public interface RendezVousService {
    RendezVous saveRendezVous(RendezVous rendezVous);
    RendezVous updateRendezVous(RendezVous rendezVous);
    void deleteRendezVousById(Long id);
    List<RendezVous> getAllRendezVous();
    RendezVous getRendezVousById(Long id);
}

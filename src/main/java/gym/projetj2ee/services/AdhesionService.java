package gym.projetj2ee.services;

import gym.projetj2ee.entities.Adhesion;
import gym.projetj2ee.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdhesionService {
    Adhesion saveAdhesion(Adhesion adhesion);
    Adhesion updateAdhesion(Adhesion adhesion);
    void deleteAdhesionById(Long id);
    void deleteAllAdhesion();
    Adhesion getAdhesionById(Long id);
    List<Adhesion> getAllAdhesion();
}

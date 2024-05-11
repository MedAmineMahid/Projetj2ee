package gym.projetj2ee.services;

import gym.projetj2ee.entities.Adhesion;
import gym.projetj2ee.repositories.AdhesionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdhesionServiceImpl implements AdhesionService {
    private AdhesionRepository adhesionRepository;


    @Override
    public Adhesion saveAdhesion(Adhesion adhesion) {
        return adhesionRepository.save(adhesion);    }

    @Override
    public Adhesion updateAdhesion(Adhesion adhesion) {
        return adhesionRepository.save(adhesion);    }

    @Override
    public void deleteAdhesionById(Long id) {
        adhesionRepository.deleteById(id);
    }

    @Override
    public void deleteAllAdhesion() {
        adhesionRepository.deleteAll();
    }

    @Override
    public Adhesion getAdhesionById(Long id) {
        return adhesionRepository.findById(id).orElse(null);    }

    @Override
    public List<Adhesion> getAllAdhesion() {
        return adhesionRepository.findAll();
    }
}

package gym.projetj2ee.services;

import gym.projetj2ee.entities.EntraineurPersonnel;
import gym.projetj2ee.repositories.EntraineurPersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EntraineurServiceImpl implements EntrainneurService {
  @Autowired
    private EntraineurPersonnelRepository entraineurPersonnelRepository;

    @Override
    public EntraineurPersonnel saveEntraineur(EntraineurPersonnel entraineur) {
        return entraineurPersonnelRepository.save(entraineur);
    }

    @Override
    public EntraineurPersonnel getEntraineurById(long id) {
        return entraineurPersonnelRepository.getReferenceById(id);
    }

    @Override
    public List<EntraineurPersonnel> getAllEntraineurs() {
        return entraineurPersonnelRepository.findAll();
    }

    @Override
    public void deleteEntraineur(long id) {
        entraineurPersonnelRepository.deleteById(id);

    }

    @Override
    public EntraineurPersonnel updateEntraineur(EntraineurPersonnel entraineur) {
       return entraineurPersonnelRepository.save(entraineur);
    }
}
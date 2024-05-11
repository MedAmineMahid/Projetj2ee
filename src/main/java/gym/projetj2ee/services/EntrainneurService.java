package gym.projetj2ee.services;

import gym.projetj2ee.entities.EntraineurPersonnel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EntrainneurService {
    public EntraineurPersonnel saveEntraineur(EntraineurPersonnel entraineur);
  public EntraineurPersonnel getEntraineurById(long id);
  public List<EntraineurPersonnel> getAllEntraineurs();
public void deleteEntraineur(long id);
public EntraineurPersonnel updateEntraineur(EntraineurPersonnel entraineur);
}


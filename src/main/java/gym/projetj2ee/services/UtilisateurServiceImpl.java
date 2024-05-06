/*package gym.projetj2ee.services;

import gym.projetj2ee.entities.User;
import gym.projetj2ee.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService{
    private UserRepository userRepository;
    @Override
    public User saveUtilisateur(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUtilisateur(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUtilisateurById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void deleteAllUtilisateur() {
        userRepository.deleteAll();
    }

    @Override
    public User getUtilisateurById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAllUtilisateurs() {
        return userRepository.findAll();
    }
}
*/
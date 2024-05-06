package gym.projetj2ee.services;

import gym.projetj2ee.entities.User;

import java.util.List;

public interface UtilisateurService {
    User saveUtilisateur(User user);
    User updateUtilisateur(User user);
    void deleteUtilisateurById(Long id);
    void deleteAllUtilisateur();
    User getUtilisateurById(Long id);
    List<User> getAllUtilisateurs();
}

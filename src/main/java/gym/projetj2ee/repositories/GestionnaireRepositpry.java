package gym.projetj2ee.repositories;

import gym.projetj2ee.entities.Gestionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GestionnaireRepositpry extends JpaRepository<Gestionnaire,Long> {
}

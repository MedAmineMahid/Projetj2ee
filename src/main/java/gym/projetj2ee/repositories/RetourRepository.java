package gym.projetj2ee.repositories;

import gym.projetj2ee.entities.Retour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetourRepository extends JpaRepository<Retour,Long> {
}

package gym.projetj2ee.repositories;

import gym.projetj2ee.entities.Planification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanificationRepository extends JpaRepository<Planification,Long> {
}

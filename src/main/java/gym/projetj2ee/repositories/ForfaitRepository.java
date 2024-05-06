package gym.projetj2ee.repositories;

import gym.projetj2ee.entities.Forfait;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForfaitRepository extends JpaRepository<Forfait,Long> {
}

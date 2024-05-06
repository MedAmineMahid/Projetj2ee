package gym.projetj2ee.repositories;

import gym.projetj2ee.entities.SeanceEntrainement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeanceEntrainementRepository extends JpaRepository<SeanceEntrainement,Long> {
}

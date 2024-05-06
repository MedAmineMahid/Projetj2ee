package gym.projetj2ee.repositories;

import gym.projetj2ee.entities.CoursGymnase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursGymnaseRepository extends JpaRepository<CoursGymnase,Long> {
}

package gym.projetj2ee.repositories;

import gym.projetj2ee.entities.Adhesion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdhesionRepository extends JpaRepository<Adhesion,Long> {
    boolean existsByType(String type);
}

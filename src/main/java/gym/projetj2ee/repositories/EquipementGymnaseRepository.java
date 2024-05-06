package gym.projetj2ee.repositories;

import gym.projetj2ee.entities.EquipementGymnase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipementGymnaseRepository extends JpaRepository<EquipementGymnase,Long> {
}

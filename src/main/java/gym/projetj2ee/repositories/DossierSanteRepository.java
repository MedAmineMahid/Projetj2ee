package gym.projetj2ee.repositories;

import gym.projetj2ee.entities.DossierSante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DossierSanteRepository extends JpaRepository<DossierSante,Long> {
}

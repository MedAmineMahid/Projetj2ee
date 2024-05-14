package gym.projetj2ee.repositories;

import gym.projetj2ee.entities.EntraineurPersonnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntraineurPersonnelRepository extends JpaRepository<EntraineurPersonnel,Long> {
    boolean existsByFirstNameAndLastName(String firstName, String lastName);

}

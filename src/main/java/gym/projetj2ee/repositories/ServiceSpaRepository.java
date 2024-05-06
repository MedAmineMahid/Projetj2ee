package gym.projetj2ee.repositories;

import gym.projetj2ee.entities.ServiceSpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceSpaRepository extends JpaRepository<ServiceSpa,Long> {
}

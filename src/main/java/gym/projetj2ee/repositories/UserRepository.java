package gym.projetj2ee.repositories;

import gym.projetj2ee.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User user= new User();
    User findByUsername(String username);
    User save(User user);
    void delete(User user);

    boolean existsByUsername(String adminUsername);
}
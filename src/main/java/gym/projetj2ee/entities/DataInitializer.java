package gym.projetj2ee.entities;

import gym.projetj2ee.repositories.AdhesionRepository;
import gym.projetj2ee.repositories.EntraineurPersonnelRepository;
import gym.projetj2ee.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initializeData(EntraineurPersonnelRepository entraineurRepository,
                                            AdhesionRepository adhesionRepository,
                                            UserRepository userRepository) {
        return args -> {
            // Initialize EntraineurPersonnel objects
            List<EntraineurPersonnel> entraineurs = Arrays.asList(
                    new EntraineurPersonnel(null, "John", "Doe", "1234567890", "Experienced fitness trainer", "General Fitness", null, null),
                    new EntraineurPersonnel(null, "Jane", "Smith", "0987654321", "Specialist in weight loss", "Weight Loss", null, null),
                    new EntraineurPersonnel(null, "Emily", "Johnson", "1122334455", "Expert in muscle building", "Muscle Building", null, null)
            );

            for (EntraineurPersonnel entraineur : entraineurs) {
                if (!entraineurRepository.existsByFirstNameAndLastName(entraineur.getFirstName(), entraineur.getLastName())) {
                    entraineurRepository.save(entraineur);
                }
            }

            // Initialize Adhesion objects
            List<Adhesion> adhesions = Arrays.asList(
                    new Adhesion(null, "Basic Membership", 30, 150.0, null),
                    new Adhesion(null, "Premium Membership", 300, 200.0, null)
            );

            for (Adhesion adhesion : adhesions) {
                if (!adhesionRepository.existsByType(adhesion.getType())) {
                    adhesionRepository.save(adhesion);
                }
            }

            // Initialize Admin user
            String adminUsername = "admin";
            String adminPassword = "123";
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // Assuming you have this configured

            adminPassword= passwordEncoder.encode(adminPassword);// In a real application, hash the password before saving

            if (!userRepository.existsByUsername(adminUsername)) {
                User admin = new User("adminid",adminUsername, adminPassword);
                userRepository.save(admin);
            }
        };
    }
}

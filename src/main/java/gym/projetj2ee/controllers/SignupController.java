package gym.projetj2ee.controllers;


import gym.projetj2ee.entities.User;
import gym.projetj2ee.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.Serializable;
import java.util.UUID;

@Controller
public class SignupController {

    private final UserRepository userRepository;

    public SignupController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("newUser", new User()); // Form binding object
        return "signup";
    }

    @PostMapping("/signup")
    public String handleSignup(@Valid @ModelAttribute("newUser") User userData, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            // Validation failed, return signup form with errors
            return "signup";
        }

        User user = userData; // No conversion needed
        user.setUserid(UUID.randomUUID().toString());

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // Assuming you have this configured
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Save the user using the repository
        userRepository.save(user);

        model.addAttribute("successMessage", "User registration successful!");
        return "redirect:/login";
    }
}

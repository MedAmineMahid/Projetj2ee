package gym.projetj2ee.controllers;
import ch.qos.logback.core.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.naming.AuthenticationException;
@Controller
public class LoginController {


    private AuthenticationManager authenticationManager;

    @GetMapping("/login")
    public String login() {
        return "se_connecter";
    }

    @PostMapping("/login")
    public String handleLogin(String username, String password,@ModelAttribute Model model) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        return "redirect:/Admin/dashboard";
    }
}

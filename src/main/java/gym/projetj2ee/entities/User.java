package gym.projetj2ee.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // Stratégie d'héritage
@DiscriminatorColumn(name="UTILISATEUR")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class User implements UserDetails {
    @Id
    private String userid;

    public User(String userid, String username, String password) {
        this.userid = userid;
        this.username = username;
        this.password = password;
    }

    private String username;
    private String email;
    private String password;
    @OneToMany(mappedBy = "user",fetch=FetchType.LAZY)
    private List<Retour> retours = new ArrayList<>();
    @OneToMany(mappedBy = "user",fetch=FetchType.LAZY)
    private List<Forfait> forfaits = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

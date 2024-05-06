package gym.projetj2ee.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Gestionnaire extends User{

    @OneToMany(mappedBy = "gestionnaire",fetch=FetchType.LAZY)
    private List<Planification> planifications = new ArrayList<>();
}

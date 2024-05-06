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
@Builder
public class EquipementGymnase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;
    private int quantite;
    @ManyToMany
    @JoinTable(name="COURSGYMNASES_EQUIPEMENTGYMNASE")
    private List<CoursGymnase> coursGymnases = new ArrayList<>();
}

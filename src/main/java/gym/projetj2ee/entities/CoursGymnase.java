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
public class CoursGymnase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String horaire;
    @ManyToMany(mappedBy = "coursGymnases",fetch=FetchType.LAZY)
    private List<EquipementGymnase> equipementGymnases = new ArrayList<>();
}

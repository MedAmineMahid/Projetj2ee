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
public class EntraineurPersonnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String bio;
    private String specialization;
    @OneToMany(mappedBy = "entraineurPersonnel",fetch=FetchType.LAZY)
    private List<SeanceEntrainement> seanceEntrainements =  new ArrayList<>();
    @ManyToMany
    @JoinTable(name="CLIENTS_ENTRAINEURPERSONNELS")
    private List<Client> clients = new ArrayList<>();
}

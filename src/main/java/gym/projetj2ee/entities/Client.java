package gym.projetj2ee.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("CLIENT")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Client extends User {
    private boolean paid;


    @OneToMany(mappedBy = "client",fetch=FetchType.LAZY)
    private List<Adhesion> adhesions = new ArrayList<>();
    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
    private List<DossierSante> dossiersantes = new ArrayList<>();
    @OneToMany(mappedBy = "client",fetch=FetchType.LAZY)
    private List<Facture> factures = new ArrayList<>();
    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
    private List<Paiement> paiements = new ArrayList<>();
    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
    private List<RendezVous> rendezVousList = new ArrayList<>();
    @ManyToMany(mappedBy = "clients",fetch = FetchType.LAZY)
    private List<ServiceSpa> serviceSpaList = new ArrayList<>();
    @ManyToMany(mappedBy = "clients",fetch = FetchType.LAZY)
    private List<EntraineurPersonnel> entraineurPersonnelList = new ArrayList<>();
}

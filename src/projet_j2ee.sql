-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 15 mai 2024 à 12:03
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `projet j2ee`
--

-- --------------------------------------------------------

--
-- Structure de la table `adhesion`
--

CREATE TABLE `adhesion` (
  `id` bigint(20) NOT NULL,
  `duree` int(11) NOT NULL,
  `prix` double DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `client_userid` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `adhesion`
--

INSERT INTO `adhesion` (`id`, `duree`, `prix`, `type`, `client_userid`) VALUES
(1, 30, 150, 'Basic Membership', NULL),
(2, 300, 200, 'Premium Membership', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `paid` bit(1) NOT NULL,
  `userid` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`paid`, `userid`, `name`) VALUES
(b'0', '74dbd6e1-af3f-4fc2-9030-93c6c9f099d8', 'dd'),
(b'0', 'c6c82f18-061f-4fe9-a88b-5ed8762911aa', 'said'),
(b'0', 'defb976a-a2ac-478a-b128-48b32e7c0216', 'sd');

-- --------------------------------------------------------

--
-- Structure de la table `clients_entraineurpersonnels`
--

CREATE TABLE `clients_entraineurpersonnels` (
  `entraineur_personnel_list_id` bigint(20) NOT NULL,
  `clients_userid` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `clients_servicespas`
--

CREATE TABLE `clients_servicespas` (
  `service_spa_list_id` bigint(20) NOT NULL,
  `clients_userid` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `coursgymnases_equipementgymnase`
--

CREATE TABLE `coursgymnases_equipementgymnase` (
  `equipement_gymnases_id` bigint(20) NOT NULL,
  `cours_gymnases_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `cours_gymnase`
--

CREATE TABLE `cours_gymnase` (
  `id` bigint(20) NOT NULL,
  `horaire` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `dossier_sante`
--

CREATE TABLE `dossier_sante` (
  `id` bigint(20) NOT NULL,
  `date` datetime(6) DEFAULT NULL,
  `id_client` bigint(20) DEFAULT NULL,
  `poids` double NOT NULL,
  `taille` double NOT NULL,
  `tension_arterielle` varchar(255) DEFAULT NULL,
  `client_userid` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `entraineur_personnel`
--

CREATE TABLE `entraineur_personnel` (
  `id` bigint(20) NOT NULL,
  `bio` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `specialization` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `entraineur_personnel`
--

INSERT INTO `entraineur_personnel` (`id`, `bio`, `first_name`, `last_name`, `phone_number`, `specialization`) VALUES
(1, 'Experienced fitness trainer', 'John', 'Doe', '1234567890', 'General Fitness'),
(2, 'Specialist in weight loss', 'Jane', 'Smith', '0987654321', 'Weight Loss'),
(3, 'Expert in muscle building', 'Emily', 'Johnson', '1122334455', 'Muscle Building');

-- --------------------------------------------------------

--
-- Structure de la table `equipement_gymnase`
--

CREATE TABLE `equipement_gymnase` (
  `id` bigint(20) NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `quantite` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

CREATE TABLE `facture` (
  `id` bigint(20) NOT NULL,
  `date_echeance` datetime(6) DEFAULT NULL,
  `id_client` bigint(20) DEFAULT NULL,
  `montant` double DEFAULT NULL,
  `client_userid` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `forfait`
--

CREATE TABLE `forfait` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `prix` double DEFAULT NULL,
  `user_userid` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `gestionnaire`
--

CREATE TABLE `gestionnaire` (
  `userid` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `gestionnaire_adhesion`
--

CREATE TABLE `gestionnaire_adhesion` (
  `id` bigint(20) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `paiement`
--

CREATE TABLE `paiement` (
  `id` bigint(20) NOT NULL,
  `client_userid` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `planification`
--

CREATE TABLE `planification` (
  `id` bigint(20) NOT NULL,
  `date` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `gestionnaire_userid` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `rendez_vous`
--

CREATE TABLE `rendez_vous` (
  `id` bigint(20) NOT NULL,
  `date` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `client_userid` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `retour`
--

CREATE TABLE `retour` (
  `id` bigint(20) NOT NULL,
  `commentaire` varchar(255) DEFAULT NULL,
  `evaluation` int(11) NOT NULL,
  `user_userid` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `name` enum('ADMIN','USER') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `seance_entrainement`
--

CREATE TABLE `seance_entrainement` (
  `id` bigint(20) NOT NULL,
  `date` datetime(6) DEFAULT NULL,
  `id_client` bigint(20) DEFAULT NULL,
  `id_entraineur` bigint(20) DEFAULT NULL,
  `time` datetime(6) DEFAULT NULL,
  `entraineur_personnel_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `service_spa`
--

CREATE TABLE `service_spa` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `duree` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `utilisateur` varchar(31) NOT NULL,
  `userid` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`utilisateur`, `userid`, `email`, `password`, `username`) VALUES
('CLIENT', '74dbd6e1-af3f-4fc2-9030-93c6c9f099d8', 'med.amine.mahid@gmail.com', NULL, NULL),
('User', 'adminid', NULL, '$2a$10$MisKYD8VOe.nSp/Hofhske35IZnVdyefN5pFhDy7.1/OUFp2fJwl2', 'admin'),
('CLIENT', 'c6c82f18-061f-4fe9-a88b-5ed8762911aa', 'med.amine.mahid@gmail.com', NULL, NULL),
('CLIENT', 'defb976a-a2ac-478a-b128-48b32e7c0216', 'med.amine.mahid@gmail.com', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `user_roles`
--

CREATE TABLE `user_roles` (
  `user_id` varchar(255) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `adhesion`
--
ALTER TABLE `adhesion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK64accw837jsiieuiowh2kpilu` (`client_userid`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`userid`);

--
-- Index pour la table `clients_entraineurpersonnels`
--
ALTER TABLE `clients_entraineurpersonnels`
  ADD KEY `FKtadg2bf94cmlu7g63uhdlnoa0` (`clients_userid`),
  ADD KEY `FKcs07g45krqsriw8mbu9173vit` (`entraineur_personnel_list_id`);

--
-- Index pour la table `clients_servicespas`
--
ALTER TABLE `clients_servicespas`
  ADD KEY `FKad3wtj66trwuk8fl20lqdb5pa` (`clients_userid`),
  ADD KEY `FKibss984j9io9sbmmelt8x44qf` (`service_spa_list_id`);

--
-- Index pour la table `coursgymnases_equipementgymnase`
--
ALTER TABLE `coursgymnases_equipementgymnase`
  ADD KEY `FKbnk3iv8tso998caong6dfnky0` (`cours_gymnases_id`),
  ADD KEY `FKgepcuhh8wuu28oprsjlxnux5d` (`equipement_gymnases_id`);

--
-- Index pour la table `cours_gymnase`
--
ALTER TABLE `cours_gymnase`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `dossier_sante`
--
ALTER TABLE `dossier_sante`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKe4x2uyvc4yoprag8fo8sapie2` (`client_userid`);

--
-- Index pour la table `entraineur_personnel`
--
ALTER TABLE `entraineur_personnel`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `equipement_gymnase`
--
ALTER TABLE `equipement_gymnase`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `facture`
--
ALTER TABLE `facture`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKnjequod9e02dfai5mlshfsg2x` (`client_userid`);

--
-- Index pour la table `forfait`
--
ALTER TABLE `forfait`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKuk6br2d6dnls936q7xjwhkwo` (`user_userid`);

--
-- Index pour la table `gestionnaire`
--
ALTER TABLE `gestionnaire`
  ADD PRIMARY KEY (`userid`);

--
-- Index pour la table `gestionnaire_adhesion`
--
ALTER TABLE `gestionnaire_adhesion`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `paiement`
--
ALTER TABLE `paiement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKsx8mcanvqtwie14cys6s7kbpv` (`client_userid`);

--
-- Index pour la table `planification`
--
ALTER TABLE `planification`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKl6fccgkrhyj7e8tv9ti9hui9h` (`gestionnaire_userid`);

--
-- Index pour la table `rendez_vous`
--
ALTER TABLE `rendez_vous`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKb7e5066yh0rcvakr0tyoo67bm` (`client_userid`);

--
-- Index pour la table `retour`
--
ALTER TABLE `retour`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK7jqfee4kb78you9cthgmormki` (`user_userid`);

--
-- Index pour la table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_8sewwnpamngi6b1dwaa88askk` (`name`);

--
-- Index pour la table `seance_entrainement`
--
ALTER TABLE `seance_entrainement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKrmjp1dir24q9itkyxvlhy182x` (`entraineur_personnel_id`);

--
-- Index pour la table `service_spa`
--
ALTER TABLE `service_spa`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userid`);

--
-- Index pour la table `user_roles`
--
ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `FKrhfovtciq1l558cw6udg0h0d3` (`role_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `adhesion`
--
ALTER TABLE `adhesion`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `cours_gymnase`
--
ALTER TABLE `cours_gymnase`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `dossier_sante`
--
ALTER TABLE `dossier_sante`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `entraineur_personnel`
--
ALTER TABLE `entraineur_personnel`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `equipement_gymnase`
--
ALTER TABLE `equipement_gymnase`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `facture`
--
ALTER TABLE `facture`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `forfait`
--
ALTER TABLE `forfait`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `gestionnaire_adhesion`
--
ALTER TABLE `gestionnaire_adhesion`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `paiement`
--
ALTER TABLE `paiement`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `planification`
--
ALTER TABLE `planification`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `rendez_vous`
--
ALTER TABLE `rendez_vous`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `retour`
--
ALTER TABLE `retour`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `role`
--
ALTER TABLE `role`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `seance_entrainement`
--
ALTER TABLE `seance_entrainement`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `service_spa`
--
ALTER TABLE `service_spa`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `adhesion`
--
ALTER TABLE `adhesion`
  ADD CONSTRAINT `FK64accw837jsiieuiowh2kpilu` FOREIGN KEY (`client_userid`) REFERENCES `client` (`userid`);

--
-- Contraintes pour la table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `FKd22l2drkrh2xbvrpc0ywwq2mp` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`);

--
-- Contraintes pour la table `clients_entraineurpersonnels`
--
ALTER TABLE `clients_entraineurpersonnels`
  ADD CONSTRAINT `FKcs07g45krqsriw8mbu9173vit` FOREIGN KEY (`entraineur_personnel_list_id`) REFERENCES `entraineur_personnel` (`id`),
  ADD CONSTRAINT `FKtadg2bf94cmlu7g63uhdlnoa0` FOREIGN KEY (`clients_userid`) REFERENCES `client` (`userid`);

--
-- Contraintes pour la table `clients_servicespas`
--
ALTER TABLE `clients_servicespas`
  ADD CONSTRAINT `FKad3wtj66trwuk8fl20lqdb5pa` FOREIGN KEY (`clients_userid`) REFERENCES `client` (`userid`),
  ADD CONSTRAINT `FKibss984j9io9sbmmelt8x44qf` FOREIGN KEY (`service_spa_list_id`) REFERENCES `service_spa` (`id`);

--
-- Contraintes pour la table `coursgymnases_equipementgymnase`
--
ALTER TABLE `coursgymnases_equipementgymnase`
  ADD CONSTRAINT `FKbnk3iv8tso998caong6dfnky0` FOREIGN KEY (`cours_gymnases_id`) REFERENCES `cours_gymnase` (`id`),
  ADD CONSTRAINT `FKgepcuhh8wuu28oprsjlxnux5d` FOREIGN KEY (`equipement_gymnases_id`) REFERENCES `equipement_gymnase` (`id`);

--
-- Contraintes pour la table `dossier_sante`
--
ALTER TABLE `dossier_sante`
  ADD CONSTRAINT `FKe4x2uyvc4yoprag8fo8sapie2` FOREIGN KEY (`client_userid`) REFERENCES `client` (`userid`);

--
-- Contraintes pour la table `facture`
--
ALTER TABLE `facture`
  ADD CONSTRAINT `FKnjequod9e02dfai5mlshfsg2x` FOREIGN KEY (`client_userid`) REFERENCES `client` (`userid`);

--
-- Contraintes pour la table `forfait`
--
ALTER TABLE `forfait`
  ADD CONSTRAINT `FKuk6br2d6dnls936q7xjwhkwo` FOREIGN KEY (`user_userid`) REFERENCES `user` (`userid`);

--
-- Contraintes pour la table `gestionnaire`
--
ALTER TABLE `gestionnaire`
  ADD CONSTRAINT `FK1v7f4uencleirjim98lvr5no1` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`);

--
-- Contraintes pour la table `paiement`
--
ALTER TABLE `paiement`
  ADD CONSTRAINT `FKsx8mcanvqtwie14cys6s7kbpv` FOREIGN KEY (`client_userid`) REFERENCES `client` (`userid`);

--
-- Contraintes pour la table `planification`
--
ALTER TABLE `planification`
  ADD CONSTRAINT `FKl6fccgkrhyj7e8tv9ti9hui9h` FOREIGN KEY (`gestionnaire_userid`) REFERENCES `gestionnaire` (`userid`);

--
-- Contraintes pour la table `rendez_vous`
--
ALTER TABLE `rendez_vous`
  ADD CONSTRAINT `FKb7e5066yh0rcvakr0tyoo67bm` FOREIGN KEY (`client_userid`) REFERENCES `client` (`userid`);

--
-- Contraintes pour la table `retour`
--
ALTER TABLE `retour`
  ADD CONSTRAINT `FK7jqfee4kb78you9cthgmormki` FOREIGN KEY (`user_userid`) REFERENCES `user` (`userid`);

--
-- Contraintes pour la table `seance_entrainement`
--
ALTER TABLE `seance_entrainement`
  ADD CONSTRAINT `FKrmjp1dir24q9itkyxvlhy182x` FOREIGN KEY (`entraineur_personnel_id`) REFERENCES `entraineur_personnel` (`id`);

--
-- Contraintes pour la table `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `FK55itppkw3i07do3h7qoclqd4k` FOREIGN KEY (`user_id`) REFERENCES `user` (`userid`),
  ADD CONSTRAINT `FKrhfovtciq1l558cw6udg0h0d3` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

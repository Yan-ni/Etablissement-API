package com.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Remarque {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String texte;
  @Enumerated(EnumType.STRING)
  private Etat etat;
  private int timestamp;

  @ManyToOne(optional = false)
  @JoinColumn(name = "salle_id")
  private Salle salle;

  @ManyToOne(optional = false)
  @JoinColumn(name = "formateur_id")
  private Utilisateur formateur;
}

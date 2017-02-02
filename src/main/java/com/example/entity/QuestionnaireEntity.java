package com.example.entity;

import java.sql.Timestamp;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * Created by Lou-Evans on 27/01/2017.
 */
@Entity
@Table(name = "questionnaire", schema = "public")
@Data
public class QuestionnaireEntity {
    private String entreprise;
    private String nom_questionnaire;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private UUID id;

    private Timestamp date_fin;
    private Timestamp date_debut;
}

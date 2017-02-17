package com.example.entity;

import java.sql.Timestamp;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

/**
 * Created by Lou-Evans on 27/01/2017.
 */
@Entity
@Table(name = "questionnaire", schema = "public")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionnaireEntity {
    private String entreprise;
    private String nom_questionnaire;

    @Id
    @Column(name="id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID id;

    private Timestamp date_fin;
    private Timestamp date_debut;
}

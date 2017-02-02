package com.example.entity;

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
@Table(name = "question", schema = "public")
@Data
public class QuestionEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private UUID id;

    private String intitule;
    private Integer id_questionnaire;
    private Integer id_sous_question;
}

package com.example.entity;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

/**
 * Created by Lou-Evans on 27/01/2017.
 */
@Entity
@Table(name = "reponse", schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReponseEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID id;
    private String reponse;
    private UUID id_question;
    private UUID id_compte;
}

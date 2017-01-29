package com.example.webservice;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Lou-Evans on 27/01/2017.
 */
public class Questionnaire {
    private String nom_questionnaire;
    private String entreprise;
    private Timestamp date_fin;
    private Timestamp date_debut;
    private List<Question> questions;

}

package com.example.webservice;

import lombok.Data;

/**
 * Created by Lou-Evans on 27/01/2017.
 */
@Data
public class Question {
    private Integer id;
    private String intitule;
    private Integer id_sous_question; 
}

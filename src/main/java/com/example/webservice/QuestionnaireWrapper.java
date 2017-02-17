package com.example.webservice;

import java.util.List;
import com.example.entity.QuestionEntity;
import com.example.entity.QuestionnaireEntity;
import lombok.Builder;
import lombok.Data;

/**
 * Created by Lou-Evans on 14/02/2017.
 */
@Data
@Builder
public class QuestionnaireWrapper {

    private QuestionnaireEntity questionnaire;
    private int pourcentage;
    private List<QuestionEntity> questions;
}

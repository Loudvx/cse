package com.example.webservice;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import com.example.entity.QuestionEntity;
import com.example.entity.QuestionnaireEntity;
import com.example.entity.ReponseEntity;
import com.example.repository.QuestionRepository;
import com.example.repository.QuestionnaireRepository;
import com.example.repository.ReponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Lou-Evans on 02/02/2017.
 */

@RestController
public class WebServiceController {

    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ReponseRepository reponseRepository;

    //-------------------Retrieve All questionnaires--------------------------------------------------------

    @GET
    @RequestMapping(value = "/questionnaire", method = RequestMethod.GET)
    public ResponseEntity<List<QuestionnaireWrapper>> listAllQuestionnaire() {
        List<QuestionnaireEntity> questionnairestmp = questionnaireRepository.findAll();
        List<QuestionnaireWrapper> questionnaires = new ArrayList<>();
        for(QuestionnaireEntity questionnaire : questionnairestmp) {
            questionnaires.add(QuestionnaireWrapper.builder()
                    .questionnaire(questionnaire)
                    .pourcentage(pourcentageQuestionnaire(questionnaire.getId()))
                    .build())
            ;
        }
        if(questionnaires == null){
            return new ResponseEntity<List<QuestionnaireWrapper>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<QuestionnaireWrapper>>(questionnaires, HttpStatus.OK);
    }

    //-------------------Retrieve One questionnaire--------------------------------------------------------

    @GET
    @RequestMapping(value = "/questionnaire/{id}", method = RequestMethod.GET)
    public ResponseEntity<QuestionnaireWrapper> listOneQuestionnaire(@PathVariable("id") UUID id) {
        QuestionnaireEntity questionnaire = questionnaireRepository.findOne(id);
        List<QuestionEntity> questions = questionRepository.findByIdQuestionnaire(id);

        QuestionnaireWrapper questionnaireWrapper = QuestionnaireWrapper.builder()
                .questionnaire(questionnaire)
                .questions(questions)
                .build()
        ;

        if(questionnaire == null){
            return new ResponseEntity<QuestionnaireWrapper>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<QuestionnaireWrapper>(questionnaireWrapper, HttpStatus.OK);
    }

    //-------------------Save a questionnaire--------------------------------------------------------

    @POST
    @RequestMapping(value = "/questionnaire", method = RequestMethod.POST)
    public ResponseEntity listAllQuestionnaire(@RequestBody Questionnaire questionnaire) {
        List<QuestionEntity> questionEntities = new ArrayList<>();
        QuestionnaireEntity questionnaireEntity = QuestionnaireEntity.builder()
                .nom_questionnaire(questionnaire.getNom_questionnaire())
                .date_debut(questionnaire.getDate_debut())
                .date_fin(questionnaire.getDate_fin())
                .entreprise(questionnaire.getEntreprise())
                .build()
        ;
        questionnaireRepository.save(questionnaireEntity);
        UUID id = questionnaireRepository.findIdByName(questionnaireEntity.getNom_questionnaire());
        for(int cpt=0;cpt<questionnaire.getQuestions().size();cpt++) {
            questionEntities.add(QuestionEntity.builder().intitule(questionnaire.getQuestions().get(cpt).getIntitule()).id_questionnaire(id).id(UUID.randomUUID()).build());
        }

        questionRepository.save(questionEntities);
        return new ResponseEntity(HttpStatus.OK);
    }

    private int pourcentageQuestionnaire(UUID cpt) {

        List<QuestionEntity> questionEntities = questionRepository.findByIdQuestionnaireAndIdSousQuestionIsNull(UUID.fromString("a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11"));
        List<ReponseEntity> reponseEntities = reponseRepository.findById_compte(UUID.fromString("a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a18"));
        int val = 0;
        for(int cpt1=0;cpt1<questionEntities.size();cpt1++) {
            for(int cpt2=0;cpt2<reponseEntities.size();cpt2++) {
                if(questionEntities.get(cpt1).getId().equals(reponseEntities.get(cpt2).getId_question())) {
                    val++;
                }
            }
        }
        if(val==0) {
            return 0;
        }
        return 100;
    }
}

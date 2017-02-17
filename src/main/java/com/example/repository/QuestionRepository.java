package com.example.repository;

import java.util.List;
import java.util.UUID;
import com.example.entity.QuestionEntity;
import com.example.entity.QuestionnaireEntity;
import com.example.webservice.Questionnaire;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Lou-Evans on 27/01/2017.
 */
public interface QuestionRepository extends CrudRepository<QuestionEntity, UUID> {

    @Query("select u from QuestionEntity u where u.id_questionnaire = ?1 AND u.id_sous_question IS NULL")
    List<QuestionEntity> findByIdQuestionnaireAndIdSousQuestionIsNull(UUID uuid);

    @Query("select u from QuestionEntity u where u.id_questionnaire = ?1")
    List<QuestionEntity> findByIdQuestionnaire(UUID uuid);
}

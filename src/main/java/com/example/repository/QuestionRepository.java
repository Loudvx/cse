package com.example.repository;

import java.util.UUID;
import com.example.entity.QuestionEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Lou-Evans on 27/01/2017.
 */
public interface QuestionRepository extends CrudRepository<QuestionEntity, UUID> {
    //Optional<Questionnaire> findByIdQuestionnaire();
}

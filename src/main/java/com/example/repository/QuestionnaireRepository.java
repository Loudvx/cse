package com.example.repository;

import java.util.List;
import java.util.UUID;
import com.example.entity.QuestionnaireEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Lou-Evans on 27/01/2017.
 */
public interface QuestionnaireRepository extends CrudRepository<QuestionnaireEntity, UUID> {

    List<QuestionnaireEntity> findAll();
}

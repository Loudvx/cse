package com.example.repository;

import java.util.UUID;
import com.example.entity.ReponseEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Lou-Evans on 27/01/2017.
 */
public interface ReponseRepository extends CrudRepository<ReponseEntity, UUID> {
    //Optional<Questionnaire> findByIdQuestion();
}

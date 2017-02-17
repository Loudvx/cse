package com.example.repository;

import java.util.List;
import java.util.UUID;
import com.example.entity.ReponseEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Lou-Evans on 27/01/2017.
 */
public interface ReponseRepository extends CrudRepository<ReponseEntity, UUID> {

    @Query("select u from ReponseEntity u where u.id_compte = ?1")
    List<ReponseEntity> findById_compte(UUID id);
}

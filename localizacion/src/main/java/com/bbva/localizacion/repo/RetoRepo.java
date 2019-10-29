package com.bbva.localizacion.repo;

import java.util.Optional;

import com.bbva.localizacion.model.RetoDocument;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetoRepo extends CrudRepository<RetoDocument, String>{
    Optional<RetoDocument> findByLocalizacion(String localizacion);
    
}
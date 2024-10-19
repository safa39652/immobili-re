package com.example.demo.repository;



import com.e.model.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, Long> {
    List<Annonce> findByPrixBetween(Double minPrix, Double maxPrix);
    List<Annonce> findByLocalisation(String localisation);
}


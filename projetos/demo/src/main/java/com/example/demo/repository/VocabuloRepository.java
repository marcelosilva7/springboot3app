package com.example.demo.repository;

import com.example.demo.model.Vocabulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VocabuloRepository extends JpaRepository <Vocabulo, Long> {

    public Vocabulo findByid (Long id);

    public List<Vocabulo> findVocabuloByTermo (String termo);

}

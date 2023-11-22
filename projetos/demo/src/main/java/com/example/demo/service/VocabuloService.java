package com.example.demo.service;

import com.example.demo.model.Vocabulo;
import com.example.demo.repository.VocabuloRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VocabuloService {


    final private VocabuloRepository vocabuloRepository;


    public VocabuloService(VocabuloRepository vocabuloRepository) {
        this.vocabuloRepository = vocabuloRepository;
    }

    public Vocabulo salvar (Vocabulo vocabulo){
        return vocabuloRepository.save(vocabulo);

    }

    public List<Vocabulo> buscarTodos(){
        return vocabuloRepository.findAll();

    }

    public Vocabulo buscarPorId(Long id){
        return vocabuloRepository.findByid(id);
    }

    public List<Vocabulo> buscarPorTermo(String termo){
        return  vocabuloRepository.findVocabuloByTermo(termo);
    }

}

package com.example.demo.controller;


import com.example.demo.model.Vocabulo;
import com.example.demo.service.VocabuloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/vocabulo")
@CrossOrigin
public class VocabuloController {

    final VocabuloService vocabuloService;

    public VocabuloController(VocabuloService vocabuloService) {
        this.vocabuloService = vocabuloService;
    }


    @GetMapping
    public ResponseEntity<List<Vocabulo>> buscarTudo(){
        return ResponseEntity.status(HttpStatus.OK).body(vocabuloService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<Object> novoChecklist(@RequestBody Vocabulo vocabulo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vocabuloService.salvar(vocabulo));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> buscarPorId(@PathVariable("id") Long id) {
        Vocabulo vocabuloOptional = vocabuloService.buscarPorId(id);
        if (vocabuloOptional == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum vocábulo foi encontrado para os critérios fornecidos");
        }
        return ResponseEntity.status(HttpStatus.OK).body(vocabuloOptional);
    }

    @GetMapping(value = "/termo/{termo}")
    public ResponseEntity<List<Vocabulo>> buscarPorTermo(@PathVariable("termo") String termo) {

        List<Vocabulo> listVocabulo = vocabuloService.buscarPorTermo(termo);

        if (listVocabulo.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(listVocabulo);
        }

        return ResponseEntity.status(HttpStatus.OK).body(listVocabulo);

    }
}

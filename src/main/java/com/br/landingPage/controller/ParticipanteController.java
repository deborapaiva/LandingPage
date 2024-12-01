package com.br.landingPage.controller;

import com.br.landingPage.models.Participante;
import com.br.landingPage.services.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/participante")
public class ParticipanteController {

    @Autowired
    private ParticipanteService participanteService;

    //CADASTRAR PARTICIPANTE NOVO
    @PostMapping("/cadastrar")
    public Participante cadastrarNovoParticipante(@RequestBody Participante participante){
        return participanteService.cadastrarNovoParticipante(participante);
    }

    //ATUALIZAR PARTICIPANTE
    @PutMapping("/{codParticipante}")
    public Participante atualizarParticipante(@PathVariable String codParticipante, @RequestBody Participante participanteAtualizado){
        return participanteService.atualizarParticipante(codParticipante, participanteAtualizado);
    }

    //DELETAR POR ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletarParticipante(@PathVariable Long id){
        participanteService.deletarParticipante(id);
        return ResponseEntity.noContent().build();
    }

    //BUSCAR TODOS
    @GetMapping("/todos")
    public List<Participante> buscarTodosParticipante(){
        return participanteService.buscarTodosParticipante();
    }

    //BUSCAR POR NOME
    @GetMapping("/nome")
    public ResponseEntity<Participante> buscarParticipantePorNome(@PathVariable String nome){
        return new ResponseEntity<Participante>(participanteService.buscarParticipantePorNome(nome), HttpStatus.OK);
    }

    //BUSCAR POR CODIGO PARTICIPANTE
    @GetMapping("/codParticipante")
    public ResponseEntity<Participante> buscarParticipantePorCodigo(@PathVariable String codParticipante){
        return new ResponseEntity<Participante>(participanteService.buscarParticipantePorCodigo(codParticipante), HttpStatus.OK);
    }

}

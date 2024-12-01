package com.br.landingPage.controller;

import com.br.landingPage.models.Projeto;
import com.br.landingPage.services.ProjetoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projeto")
public class ProjetoController {
    @Autowired
    private ProjetoServices projetoServices;

    //CADASTRAR NOVO PROJETO
    @PostMapping("/cadastrar")
    public Projeto cadastrarNovoProjeto(@RequestBody Projeto projeto){
        return projetoServices.cadastrarNovoProjeto(projeto);
    }

    //ATUALIZAR PROJETO
    @PutMapping("/{codProjeto}")
    public Projeto atualizarProjeto(@PathVariable String codProjeto, @RequestBody Projeto projetoAtualizado){
        return projetoServices.atualizarProjeto(codProjeto, projetoAtualizado);
    }

    //DELETAR POR ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletarProjeto(@PathVariable Long id){
        projetoServices.deletarProjeto(id);
        return ResponseEntity.noContent().build();
    }

    //BUSCAR TODOS
    @GetMapping("/todos")
    public List<Projeto> buscarTodosProjetos(){
        return projetoServices.buscarTodosProjetos();
    }

    //BUSCAR POR TITULO
    @GetMapping("/titulo")
    public ResponseEntity<Projeto> buscarPorTitulo(@PathVariable String titulo){
        return new ResponseEntity<>(projetoServices.buscarPorTitulo(titulo), HttpStatus.OK);
    }

    //BUSCAR POR CODIGO PROJETO
    @GetMapping("/codProjeto")
    public ResponseEntity<Projeto> buscarPorCodProjeto(@PathVariable String codProjeto){
        return new ResponseEntity<Projeto>(projetoServices.buscarPorCodProjeto(codProjeto), HttpStatus.OK);
    }
}

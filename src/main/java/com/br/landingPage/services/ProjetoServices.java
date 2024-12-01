package com.br.landingPage.services;

import com.br.landingPage.models.Participante;
import com.br.landingPage.models.Projeto;
import com.br.landingPage.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoServices {
    @Autowired
    private ProjetoRepository projetoRepository;
    private Projeto projetoAtualizado;


    //CADASTRAR NOVO PROJETO
    public Projeto cadastrarNovoProjeto(Projeto projeto){
        //Implementar Validação
        return projetoRepository.save(projeto);
    }

    //BUSCAR POR TITULO
    public Projeto buscarPorTitulo(String titulo){
        return projetoRepository.findByTitulo(titulo);
    }

    //BUSCAR POR ID
    public Projeto buscarPorId(long id){
        return projetoRepository.findById(id);
    }

    //BUSCAR POR LINGUAGEM
    public Projeto buscarPorLinguagem(String linguagem){
        return projetoRepository.findByLinguagens(linguagem);
    }

    //BUSCAR POR CODIGO
    public Projeto buscarPorCodProjeto(String codProjeto){
        return projetoRepository.findByCodProjeto(codProjeto);
    }

    //ATUALIZAR PROJETO
    public Projeto atualizarProjeto(String codProjeto, Projeto projetoAtualizado){
        //Implementar Validação
        Projeto projetoExistente = projetoRepository.findByCodProjeto(codProjeto);

        projetoExistente.setTitulo(projetoAtualizado.getTitulo());
        projetoExistente.setDescricaoProjeto(projetoAtualizado.getDescricaoProjeto());
        projetoExistente.setLingaguens(projetoAtualizado.getLingaguens());

        return projetoRepository.save(projetoExistente);
    }

    //DELETAR POR ID
    public void deletarProjeto(long id){
        Projeto projetoExistente = projetoRepository.findById(id);
        projetoRepository.delete(projetoExistente);
    }

    //BUSCAR TODOS
    public List<Projeto> buscarTodosProjetos(){
        return projetoRepository.findAll();
    }

}

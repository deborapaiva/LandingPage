package com.br.landingPage.services;

import com.br.landingPage.models.Participante;
import com.br.landingPage.repository.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipanteService {
    @Autowired
    private ParticipanteRepository participanteRepository;
    private Participante participanteAtualizado;

    //CADASTRAR PARTICIPANTE NOVO
    public Participante cadastrarNovoParticipante(Participante participante){
        //Inserir validação
        return participanteRepository.save(participante);
    }

    //ATUALIZAR PARTICIPANTE
    public Participante atualizarParticipante(String codParticipante, Participante participanteAtualizado){
        Participante participanteExistente = participanteRepository.findByCodigoParticipante(codParticipante);

        participanteExistente.setNome(participanteAtualizado.getNome());
        participanteExistente.setSobrenome(participanteAtualizado.getSobrenome());
        participanteExistente.setDescricao(participanteAtualizado.getDescricao());
        participanteExistente.setGithub(participanteAtualizado.getGithub());
        participanteExistente.setLinkedin(participanteAtualizado.getLinkedin());

        return participanteRepository.save(participanteExistente);
    }

    //DELETAR POR ID
    public void deletarParticipante(long id){
        Participante participanteExistente = participanteRepository.findById(id);
        participanteRepository.delete(participanteExistente);
    }

    //BUSCAR POR NOME
    public Participante buscarParticipantePorNome(String nome){
        return participanteRepository.finByNome(nome);
    }

    //BUSCAR POR CODIGO
    public Participante buscarParticipantePorCodigo(String codParticipante){
        return participanteRepository.findByCodigoParticipante(codParticipante);
    }

    //BUSCAR TODOS
    public List<Participante> buscarTodosParticipante(){
        return participanteRepository.findAll();
    }

}

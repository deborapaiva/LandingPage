package com.br.landingPage.repository;

import com.br.landingPage.models.Participante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipanteRepository extends JpaRepository<Participante, Long> {
    Participante findById(long id);
    Participante finByNome(String nome);
    Participante findByCodigoParticipante(String codParticipante);

}

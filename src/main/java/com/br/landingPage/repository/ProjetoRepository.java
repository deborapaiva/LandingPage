package com.br.landingPage.repository;

import com.br.landingPage.models.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
    Projeto findById(long id);
    Projeto findByTitulo(String titulo);
    Projeto findByLinguagens(String linguagens);
    Projeto findByCodProjeto(String codProjeto);
}

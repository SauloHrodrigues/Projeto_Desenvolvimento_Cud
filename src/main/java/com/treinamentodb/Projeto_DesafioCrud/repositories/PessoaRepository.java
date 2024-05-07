package com.treinamentodb.Projeto_DesafioCrud.repositories;

import com.treinamentodb.Projeto_DesafioCrud.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}

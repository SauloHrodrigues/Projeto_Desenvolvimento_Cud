package com.treinamentodb.Projeto_DesafioCrud.dto;
public record PessoaRequestDto(
        String nome,
        String nascimento,
        String cpf,
        EnderecoRequestDto endereco
) {}

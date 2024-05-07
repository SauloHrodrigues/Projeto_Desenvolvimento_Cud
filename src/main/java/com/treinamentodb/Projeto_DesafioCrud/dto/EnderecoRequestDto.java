package com.treinamentodb.Projeto_DesafioCrud.dto;

public record EnderecoRequestDto(

        String rua,
        String numero,
        String cidade,
        String cep,
        String estado

) {
}

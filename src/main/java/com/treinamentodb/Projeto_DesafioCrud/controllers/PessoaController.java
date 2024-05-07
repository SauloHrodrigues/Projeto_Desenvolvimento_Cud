package com.treinamentodb.Projeto_DesafioCrud.controllers;

import com.treinamentodb.Projeto_DesafioCrud.dto.PessoaRequestDto;
import com.treinamentodb.Projeto_DesafioCrud.dto.PessoaResponseDto;
import com.treinamentodb.Projeto_DesafioCrud.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {
    @Autowired
    private PessoaService service;
//    CRUD -> create, read, update, delete

//    create
    @PostMapping
    public PessoaResponseDto salvarNovaPessoa(@RequestBody PessoaRequestDto dto ){
        return service.gravar(dto);
    }

//     Read
    @GetMapping
    public List<PessoaResponseDto> listarPessoasCadastradas(){
        return service.listarPessoasCadastradas();
    }

//    updade
    @PutMapping("/{id}")
    public PessoaResponseDto alterarPessoa(@PathVariable("id") Long id, @RequestBody PessoaRequestDto pessoaAlterada){
        return service.alterar(id,pessoaAlterada);
    }

//    delete
    @DeleteMapping("/{id}")
    public boolean deletarPessoa(@PathVariable("id") Long id){
        return service.apagarPessoa(id);
    }

}
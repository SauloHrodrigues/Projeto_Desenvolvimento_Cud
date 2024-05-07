package com.treinamentodb.Projeto_DesafioCrud.service;

import com.treinamentodb.Projeto_DesafioCrud.dto.PessoaRequestDto;
import com.treinamentodb.Projeto_DesafioCrud.dto.PessoaResponseDto;
import com.treinamentodb.Projeto_DesafioCrud.models.Endereco;
import com.treinamentodb.Projeto_DesafioCrud.models.Pessoa;
import com.treinamentodb.Projeto_DesafioCrud.repositories.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaResponseDto gravar(PessoaRequestDto request){
        Pessoa pessoa = new Pessoa();

//        pessoa.setNome(request.getNome());
        Endereco endereco = new Endereco();
        BeanUtils.copyProperties(request.endereco(),endereco);
        BeanUtils.copyProperties(request,pessoa); //
        pessoa.getEnderecos().add(endereco);
        pessoaRepository.save(pessoa);
        Pessoa pessoaSalva = new Pessoa();
        for(Pessoa p : pessoaRepository.findAll()){
            if(p.getNome().equalsIgnoreCase(request.nome())){
                pessoaSalva = p;
                break;
            }
        }
        return new PessoaResponseDto(pessoaSalva);
    }

    public PessoaResponseDto alterar(Long id, PessoaRequestDto pessoaAlterada){
        Pessoa pessoaBuscada = pessoaRepository.findById(id).orElse(null);

        if(pessoaBuscada != null){
            Endereco endereco = new Endereco();
//            BeanUtils.copyProperties(pessoaAlterada.getEndereco(),endereco);
            BeanUtils.copyProperties(pessoaAlterada,pessoaBuscada); //
            pessoaBuscada.getEnderecos().add(endereco);

            pessoaRepository.save(pessoaBuscada);
            return new PessoaResponseDto(pessoaRepository.findById(id).get());
        }
        return null;
    }

    public List<PessoaResponseDto> listarPessoasCadastradas() {
        List<PessoaResponseDto> pessoaDtoList= new ArrayList<>();
        for (Pessoa p : pessoaRepository.findAll()){
            pessoaDtoList.add(new PessoaResponseDto(p));
        }
        return pessoaDtoList;
    }

    public boolean apagarPessoa(Long id) {
        Pessoa pessoaBuscada = pessoaRepository.findById(id).orElse(null);
        if(pessoaBuscada != null){
           pessoaRepository.deleteById(id);
           return true;
        }
        return false;
    }
}
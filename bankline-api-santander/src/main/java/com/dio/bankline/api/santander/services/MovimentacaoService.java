package com.dio.bankline.api.santander.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.bankline.api.santander.dto.NovaMovimentacao;
import com.dio.bankline.api.santander.model.Correntista;
import com.dio.bankline.api.santander.model.Movimentacao;
import com.dio.bankline.api.santander.model.MovimentacaoTipo;
import com.dio.bankline.api.santander.repository.CorrentistaRepository;
import com.dio.bankline.api.santander.repository.MovimentacaoRepository;

@Service
public class MovimentacaoService {
	
	@Autowired
	private MovimentacaoRepository repository;
	
	@Autowired
	private CorrentistaRepository correntistaRepository;
	
	public void save(NovaMovimentacao novaMovimentacao) {
		
		Movimentacao movimentacao = new Movimentacao();
		
		Double valor = novaMovimentacao.getTipo()== MovimentacaoTipo.RECEITA ? novaMovimentacao.getValor() : novaMovimentacao.getValor() * -1;
		
		movimentacao.setDataHora(LocalDateTime.now());
		movimentacao.setDescricao(novaMovimentacao.getDescricao());
		movimentacao.setIdConta(novaMovimentacao.getIdConta());
		movimentacao.setTipo(novaMovimentacao.getTipo());
		movimentacao.setValor(valor);
		
		Correntista correntista = correntistaRepository.findById(novaMovimentacao.getIdConta()).orElse(null);
		
		if(correntista != null) {
			
			correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
			correntistaRepository.save(correntista);
			
		}
		
		repository.save(movimentacao);
		
	}
	

}

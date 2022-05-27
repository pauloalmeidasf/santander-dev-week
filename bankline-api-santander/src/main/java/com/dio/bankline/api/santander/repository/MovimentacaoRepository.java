package com.dio.bankline.api.santander.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dio.bankline.api.santander.model.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository <Movimentacao, Integer> {
	
	public List<Movimentacao> findByIdConta(Integer idConta);

}

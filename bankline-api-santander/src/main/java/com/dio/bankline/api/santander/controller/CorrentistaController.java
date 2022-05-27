package com.dio.bankline.api.santander.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.bankline.api.santander.dto.NovoCorrentista;
import com.dio.bankline.api.santander.model.Correntista;
import com.dio.bankline.api.santander.repository.CorrentistaRepository;
import com.dio.bankline.api.santander.services.CorrentistaService;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {
	
	@Autowired
	private CorrentistaRepository repository;
	
	@Autowired
	private CorrentistaService service;
	
	@GetMapping
	public List<Correntista> findAll(){
		
		return repository.findAll();
		
	}
	
	@PostMapping
	public void save(@RequestBody NovoCorrentista correntista) {
		
		service.save(correntista);
		
	}

}

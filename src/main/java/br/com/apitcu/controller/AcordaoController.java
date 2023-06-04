package br.com.apitcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apitcu.model.Acordao;
import br.com.apitcu.repository.AcordaoRepository;
import br.com.apitcu.service.AcordaoService;

@RestController
@RequestMapping("acordao")
public class AcordaoController {
	
	@Autowired
	private AcordaoService acordaoService;
	@Autowired
	private AcordaoRepository acordaoRepository;
	
	@GetMapping("/{num}/{quantidade}")
	public void acordao(@PathVariable Long num, @PathVariable Long quantidade) {
		List<Acordao> acordaos = acordaoService.encontrarAcordaos(num, quantidade);
		for (Acordao acordao : acordaos) {
			acordaoRepository.save(acordao);
		}
	}
}

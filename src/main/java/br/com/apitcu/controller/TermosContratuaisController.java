package br.com.apitcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apitcu.model.TermosContratuais;
import br.com.apitcu.repository.TermosContratuaisRepository;
import br.com.apitcu.service.TermosContratuaisService;

@RestController
@RequestMapping("termos-contratuais")
public class TermosContratuaisController {
	
	@Autowired
	private TermosContratuaisService termosContratuaisService;
	@Autowired
	private TermosContratuaisRepository termosContratuaisRepository;
	
	@GetMapping("/listar")
	public void acordao() {
		List<TermosContratuais> termosContratuais = termosContratuaisService.retornarTermos();
		for (TermosContratuais termoContratual : termosContratuais) {
			termosContratuaisRepository.save(termoContratual);
		}
	}
}

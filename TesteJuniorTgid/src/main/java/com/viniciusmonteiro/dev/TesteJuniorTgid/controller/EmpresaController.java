package com.viniciusmonteiro.dev.TesteJuniorTgid.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.viniciusmonteiro.dev.TesteJuniorTgid.models.Empresa;
import com.viniciusmonteiro.dev.TesteJuniorTgid.models.Empresa.CreateEmpresa;
import com.viniciusmonteiro.dev.TesteJuniorTgid.models.Empresa.UpdateEmpresa;
import com.viniciusmonteiro.dev.TesteJuniorTgid.services.EmpresaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/empresa")
@Validated
public class EmpresaController {
	
	
	
	@Autowired
	private EmpresaService empresaService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Empresa> getEmpresaById(@PathVariable Long id){
		Empresa object = this.empresaService.getEmpresaById(id);
		return ResponseEntity.ok().body(object);
	}
	
	@PostMapping
	@Validated(CreateEmpresa.class)
	public ResponseEntity<Void> postEmpresa(@Valid @RequestBody Empresa object){
		this.empresaService.createEmpresa(object);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(object.getIdEmpresa()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	@Validated(UpdateEmpresa.class)
	public ResponseEntity<Void> updateEmpresa( @Valid @RequestBody Empresa object, @PathVariable Long id){
		object.setIdEmpresa(id);
		this.empresaService.updateEmpresa(object);
		return ResponseEntity.ok().build();
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmpresa(@PathVariable Long id){
		this.empresaService.deleteEmpresa(id);
		return ResponseEntity.noContent().build();
	}
	
}


	

	
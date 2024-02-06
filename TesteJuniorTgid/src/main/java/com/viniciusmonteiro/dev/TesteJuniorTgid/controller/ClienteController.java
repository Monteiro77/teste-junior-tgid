package com.viniciusmonteiro.dev.TesteJuniorTgid.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.viniciusmonteiro.dev.TesteJuniorTgid.models.Cliente;
import com.viniciusmonteiro.dev.TesteJuniorTgid.models.Cliente.CreateClient;
import com.viniciusmonteiro.dev.TesteJuniorTgid.services.ClienteService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/cliente")
@Validated
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable Long id){
		Cliente object = this.clienteService.getClienteById(id);
		return ResponseEntity.ok().body(object);
	}
	
	@PostMapping
	@Validated(CreateClient.class)
	public ResponseEntity<Void> postCliente(@Valid @RequestBody Cliente object){
		this.clienteService.createCliente(object);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(object.getIdCliente()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@PutMapping("/{id}")
	@Validated(CreateClient.class)
	public ResponseEntity<Void> updateCliente(@Valid @RequestBody Cliente object, @PathVariable Long id){
		object.setIdCliente(id);
		this.clienteService.updateCliente(object);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCliente(@PathVariable Long id){
		this.clienteService.deleteCliente(id);
		return ResponseEntity.noContent().build();
	}
	
	
	

}

package com.viniciusmonteiro.dev.TesteJuniorTgid.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.viniciusmonteiro.dev.TesteJuniorTgid.models.Cliente;
import com.viniciusmonteiro.dev.TesteJuniorTgid.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente getClienteById(long id) {
		Optional<Cliente> cliente = this.clienteRepository.findById(id);
		
		return cliente.orElseThrow(() -> new RuntimeException(
				"Usuário não encontrado ou inexistente"));
	}
	
	@Transactional
	public Cliente createCliente(Cliente object) {
		object.setIdCliente(null);
		object = this.clienteRepository.save(object);
		return object;
	}
	
	
	@Transactional
	public Cliente updateCliente(Cliente object) {
		Cliente newObject = getClienteById(object.getIdCliente());
		newObject.setNome(object.getNome());
		newObject.setCpf(object.getCpf());
		
		return this.clienteRepository.save(newObject);	
	}
	
	public void deleteCliente(Long id) {
		getClienteById(id);
		try {
			this.clienteRepository.deleteById(id);
		}catch(Exception error){
			throw new RuntimeException("Não foi possível deletar o cliente pois o mesmo não existe");
		}
	}
	
}

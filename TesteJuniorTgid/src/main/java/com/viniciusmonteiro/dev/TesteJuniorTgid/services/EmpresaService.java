package com.viniciusmonteiro.dev.TesteJuniorTgid.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.viniciusmonteiro.dev.TesteJuniorTgid.models.Empresa;
import com.viniciusmonteiro.dev.TesteJuniorTgid.repositories.EmpresaRepository;

@Service
public class EmpresaService {
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	public Empresa getEmpresaById(Long id) {
		Optional<Empresa> empresa = this.empresaRepository.findById(id);
		
		return empresa.orElseThrow(() -> new RuntimeException(
				"Usuário não encontrado ou inexistente"
				));
		
	}
	
	@Transactional
	public Empresa createEmpresa(Empresa object) {
		object.setIdEmpresa(null);
		object = this.empresaRepository.save(object);
		return object;
	
	}
	
	@Transactional
	public Empresa updateEmpresa(Empresa object) {
		Empresa newObject = getEmpresaById(object.getIdEmpresa());
		newObject.setRazaoSocial(object.getRazaoSocial());
		newObject.setTaxa(object.getTaxa());
		
		return this.empresaRepository.save(newObject);
		
		
	}
	
	public void deleteEmpresa(Long id) {
		getEmpresaById(id);
		try {
			this.empresaRepository.deleteById(id);
		}catch (Exception error) {
			throw new RuntimeException("Não foi possível deletar a empresa, pois a mesma não existe");
		}
	}
	
	

}

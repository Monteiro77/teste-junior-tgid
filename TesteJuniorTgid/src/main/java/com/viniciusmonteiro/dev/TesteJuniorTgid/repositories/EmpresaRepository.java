package com.viniciusmonteiro.dev.TesteJuniorTgid.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viniciusmonteiro.dev.TesteJuniorTgid.models.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	 
}

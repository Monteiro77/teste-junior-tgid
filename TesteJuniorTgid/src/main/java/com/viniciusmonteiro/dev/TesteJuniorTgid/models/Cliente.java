package com.viniciusmonteiro.dev.TesteJuniorTgid.models;

import java.util.Objects;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = Cliente.TABLE_NAME)
public class Cliente {
	
	public static final String TABLE_NAME = "tbl_cliente";
	
	public interface CreateClient{}
	
	public interface UpdateCliente{}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private Long idCliente;
	
	@Column(name = "nome", nullable = false, length = 255)
	@NotNull(groups = CreateClient.class)
	@NotEmpty(groups = CreateClient.class)
	private String nome;
	
	@Column(name = "cpf", nullable = false, unique = true, length = 11)
	@NotNull(groups = CreateClient.class)
	@NotEmpty(groups = CreateClient.class)
	private String cpf;
	
	@Column(name = "saldo")
	private long saldo;
	
	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;
	
	
	
	public Cliente() {	
	}
	
	public Cliente(Long idCliente, String nome, String cpf, long saldo, Empresa empresa) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.cpf = cpf;
		this.saldo = saldo;
		this.empresa = empresa;
	}
	
	
	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public long getSaldo() {
		return saldo;
	}

	public void setSaldo(long saldo) {
		this.saldo = saldo;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.idCliente == null ? 0 : this.idCliente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		
		Cliente other = (Cliente) obj;
		
		if(this.idCliente == null) {
			if(other.idCliente != null)
				return false;
			else if(!this.idCliente.equals(other.idCliente))
				return false;			
		}
		
		return Objects.equals(cpf, other.cpf) && Objects.equals(idCliente, other.idCliente)
				&& Objects.equals(nome, other.nome) && saldo == other.saldo;
	}
	
	
	
	
	
	

}

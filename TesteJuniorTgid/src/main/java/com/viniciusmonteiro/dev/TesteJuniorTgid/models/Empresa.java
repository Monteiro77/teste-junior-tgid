package com.viniciusmonteiro.dev.TesteJuniorTgid.models;



import java.util.Objects;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = Empresa.TABLE_NAME)
public class Empresa {
	public static final String TABLE_NAME = "tbl_empresa";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name =  "id", unique = true)
	private Long idEmpresa;
	
	
	@Column(name = "razao_social", nullable = false, unique = true, length = 150)
	@Nonnull
	private String razaoSocial;
	
	
	@Column(name = "cnpj", nullable = false, length = 11)
	@Nonnull
	private Long cnpj;
	
	
	@Column(name = "saldo")
	private Long saldo; 
	
	
	@Column(name = "taxa", length = 6, nullable = false)
	private Integer taxa;
	
	public Empresa() {
		
	}

	

	public Empresa(Long idEmpresa, String razaoSocial, Long cnpj, Long saldo, Integer taxa) {
		super();
		this.idEmpresa = idEmpresa;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.saldo = saldo;
		this.taxa = taxa;
	}



	public Long getIdEmpresa() {
		return idEmpresa;
	}


	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}


	public String getRazaoSocial() {
		return razaoSocial;
	}


	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}


	public Long getCnpj() {
		return cnpj;
	}


	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}


	public Long getSaldo() {
		return saldo;
	}


	public void setSaldo(Long saldo) {
		this.saldo = saldo;
	}


	public Integer getTaxa() {
		return taxa;
	}


	public void setTaxa(Integer taxa) {
		this.taxa = taxa;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.idEmpresa == null ? 0 : this.idEmpresa.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (object == null)
			return false;
		if (getClass() != object.getClass())
			return false;
		
		Empresa other = (Empresa) object;
		
		if(this.idEmpresa == null) {
			if(other.idEmpresa != null)
				return false;
			else if(!this.idEmpresa.equals(other.idEmpresa))
				return false;
		}
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(idEmpresa, other.idEmpresa)
				&& Objects.equals(razaoSocial, other.razaoSocial) && Objects.equals(saldo, other.saldo)
				&& Objects.equals(taxa, other.taxa);
	}
	
	
	
	
	
	
}

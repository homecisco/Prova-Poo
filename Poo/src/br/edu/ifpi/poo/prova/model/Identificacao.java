package br.edu.ifpi.poo.prova.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.junit.Test;

@Entity
@NamedQueries({
	@NamedQuery(name="Identificacao.buscarTodos", query="SELECT i FROM Identificacao i"),
	@NamedQuery(name="Identificacao.buscarPorCpf", query="SELECT i FROM Identificacao i WHERE i.cpf = :cpf")
})
public class Identificacao {
	@Id
	@GeneratedValue
	private Long id;
	private String Nome;
	private String cpf;
	private String data;
	private String cep;

	public Identificacao() {
		super();
	}

	public Identificacao(String nome, String cpf, String data, String cep) {
		super();
		Nome = nome;
		this.cpf = cpf;
		this.data = data;
		this.cep = cep;
	}

	public Identificacao(Long id, String nome, String cpf, String data,
			String cep) {
		super();
		this.id = id;
		Nome = nome;
		this.cpf = cpf;
		this.data = data;
		this.cep = cep;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getCep() {  //9, 6
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	//TESTANDO ExpressõesRegulares
	
	//Test ValidaNome
	public boolean ValidarNome(){
		String regex = "[a-z]*";
		return this.Nome.toLowerCase().matches(regex);
	}
	
	//Test ValidaCPF
	public boolean ValidarCpf(){
		String regex = "\\d{3}.\\d{3}.\\d{3}-\\d{2}";
		return this.cpf.toLowerCase().matches(regex);
	}
	
	//Test ValidarNomeNulo
	public Identificacao(String Nome){
		if(Nome == null || (Nome.isEmpty())){
			throw new IllegalArgumentException("Francisco");
		}
		this.Nome = Nome;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Nome == null) ? 0 : Nome.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Identificacao other = (Identificacao) obj;
		if (Nome == null) {
			if (other.Nome != null)
				return false;
		} else if (!Nome.equals(other.Nome))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Identificacao [id=" + id + ", Nome=" + Nome + ", cpf=" + cpf
				+ ", data=" + data + ", cep=" + cep + "]";
	}

}

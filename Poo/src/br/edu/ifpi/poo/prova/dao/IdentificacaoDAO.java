package br.edu.ifpi.poo.prova.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.edu.ifpi.poo.prova.model.Identificacao;


public class IdentificacaoDAO {
	private EntityManager em = Persistence.createEntityManagerFactory(
			"identificacao-jpa").createEntityManager();

	public void fechar() {
		em.close();
	}

	public void commit() {
		em.getTransaction().commit();
	}

	public void iniciar() {
		em.getTransaction().begin();
	}

	public void salvar(Identificacao i) {
		em.persist(i);
	}

	public void apagar(Identificacao i) {
		em.remove(i);
	}
	
	public void atualizar(Identificacao i){
		em.merge(i);
	}
	
	public Identificacao procurar(Long id){
		return em.find(Identificacao.class, id);
	}
	
	public List<Identificacao> listarTodos(){
		Query query = em.createNamedQuery("Pessoa.buscarTodos");
		return query.getResultList();
	}
	
	public Identificacao procurarPorCpf(String cpf){
		Query query = em.createNamedQuery("Pessoa.buscarPorCpf");
		query.setParameter("cpf", cpf);
		return (Identificacao) query.getSingleResult();
	}

}

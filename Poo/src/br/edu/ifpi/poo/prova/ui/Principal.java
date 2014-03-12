package br.edu.ifpi.poo.prova.ui;

import java.util.List;

import br.edu.ifpi.poo.prova.dao.IdentificacaoDAO;
import br.edu.ifpi.poo.prova.model.Identificacao;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IdentificacaoDAO pdao = new IdentificacaoDAO();
		Identificacao i;
		pdao.iniciar(); 
		i = new Identificacao("Francisco", "05412375945", "26-11-1993", "64208-585");
		pdao.salvar(i);
		i = new Identificacao("Francisco", "05412375945", "26-11-1993", "64208-585");
		pdao.salvar(i);
		pdao.commit();
		
		List<Identificacao> l = pdao.listarTodos();
		for(Identificacao identificacao : l){
			System.out.println(identificacao);
		}
		
		i = pdao.procurar(10L);
		i.setCpf("05412375945");
		pdao.atualizar(i);
		System.out.println(i);
	}

}

package br.edu.up.aula4etapa.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import br.edu.up.aula4etapa.entity.Revenda;

public class RevendaDao {

	public void salvar(Revenda comp) {
		EntityManager em = Conexao.getInstance().createEntityManager();
		em.getTransaction().begin();
		em.persist(comp);
		em.getTransaction().commit();
	}
	
	public Revenda buscar(Integer id) {
		EntityManager em = Conexao.getInstance().createEntityManager();
		
		Revenda plano = em.find(Revenda.class, id);
		return plano;
	}
	
	public ArrayList<Revenda> listar(){
		EntityManager em = Conexao.getInstance().createEntityManager();
		Query q = em.createQuery("from Revenda");
		
		return new ArrayList<Revenda>(q.getResultList());
	}
	
	public void alterar(Revenda comp) {
		EntityManager em = Conexao.getInstance().createEntityManager();
		em.getTransaction().begin();
		em.merge(comp);
		em.getTransaction().commit();
	}
	
	public void remover(Integer id) {
		EntityManager em = Conexao.getInstance().createEntityManager();
		em.getTransaction().begin();
		Revenda comp = em.find(Revenda.class, id);
		em.remove(comp);
		em.getTransaction().commit();
	}

}

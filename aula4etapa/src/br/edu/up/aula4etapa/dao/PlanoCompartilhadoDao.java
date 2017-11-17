package br.edu.up.aula4etapa.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import aula4etapa.Jogo;
import br.edu.up.aula4etapa.entity.PlanoComp;

public class PlanoCompartilhadoDao {

	
	
	public void salvar(PlanoComp comp) {
		EntityManager em = Conexao.getInstance().createEntityManager();
		em.getTransaction().begin();
		em.persist(comp);
		em.getTransaction().commit();
	}
	
	public PlanoComp buscar(Integer id) {
		EntityManager em = Conexao.getInstance().createEntityManager();
		
		PlanoComp plano = em.find(PlanoComp.class, id);
		return plano;
	}
	
	public ArrayList<PlanoComp> listar(){
		EntityManager em = Conexao.getInstance().createEntityManager();
		Query q = em.createQuery("from PlanoComp");
		
		return new ArrayList<PlanoComp>(q.getResultList());
	}
	
	public void alterar(PlanoComp comp) {
		EntityManager em = Conexao.getInstance().createEntityManager();
		em.getTransaction().begin();
		em.merge(comp);
		em.getTransaction().commit();
	}
	
	public void remover(Integer id) {
		EntityManager em = Conexao.getInstance().createEntityManager();
		em.getTransaction().begin();
		PlanoComp comp = em.find(PlanoComp.class, id);
		em.remove(comp);
		em.getTransaction().commit();
	}
}

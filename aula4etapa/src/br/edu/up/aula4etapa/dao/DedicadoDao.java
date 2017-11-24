package br.edu.up.aula4etapa.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.up.aula4etapa.entity.Dedicado;
import br.edu.up.aula4etapa.entity.PlanoComp;

public class DedicadoDao {

	
	public void salvar(Dedicado dedic) {
		EntityManager em = Conexao.getInstance().createEntityManager();
		em.getTransaction().begin();
		em.persist(dedic);
		em.getTransaction().commit();
	}
	
	public Dedicado buscar(Integer id) {
		EntityManager em = Conexao.getInstance().createEntityManager();
		
		Dedicado dedic = em.find(Dedicado.class, id);
		return dedic;
	}

	public ArrayList<Dedicado> listar() {
		EntityManager em = Conexao.getInstance().createEntityManager();
		Query q = em.createQuery("from Dedicado");
		
		return new ArrayList<Dedicado>(q.getResultList());
	}

	public void alterar(Dedicado dedic) {
		// TODO Auto-generated method stub
		EntityManager em = Conexao.getInstance().createEntityManager();
		em.getTransaction().begin();
		em.merge(dedic);
		em.getTransaction().commit();
	}

	public void remover(Integer id) {
		// TODO Auto-generated method stub
		EntityManager em = Conexao.getInstance().createEntityManager();
		em.getTransaction().begin();
		Dedicado dedic = em.find(Dedicado.class, id);
		em.remove(dedic);
		em.getTransaction().commit();
		
	}
	
	
	
}

package br.com.fiap.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GenericDAO;

public class GenericDAOImpl<T,K> implements GenericDAO<T, K> {
	protected EntityManager em;
	
private Class<T> clazz;
	
	@SuppressWarnings("all")
	public GenericDAOImpl(EntityManager em) {		
		this.em = em;
		clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
							.getActualTypeArguments()[0];
	}
	@Override
	public void insert(T entity) {
		try{
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		}catch(Exception e){
			if(em.getTransaction().isActive()){
				em.getTransaction().rollback();
			}
		}
		
	}

	@Override
	public T findById(K id) {
		
		return em.find(clazz, id);
	}
	

}

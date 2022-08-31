package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entities.Category;
import entities.User;
import utils.jpaUtils;

public class categoryDao {
	private EntityManager em;
	public  categoryDao() {
		this.em=jpaUtils.getEntityManager();
	}
	public void create(Category entity) {
		try {
			this.em.getTransaction().begin();
			this.em.persist(entity);
			this.em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
			throw e ;
		}
	}
	public List<Category> getAll() {
		TypedQuery<Category> query = this.em.createNamedQuery("Category.findAll", Category.class);
		return query.getResultList();
	}
	public void delete(Category entity) {
		try {
			this.em.getTransaction().begin();
			this.em.remove(entity);
			this.em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
			throw e ;
		}
	}
	public Category finById(int id) {
		return this.em.find(Category.class, id);
	}
	public void update(Category entity) {
		try {
			this.em.getTransaction().begin();
			this.em.merge(entity);
			this.em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
			throw e ;
		}
	}
}

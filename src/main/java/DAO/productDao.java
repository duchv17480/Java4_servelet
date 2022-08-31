 package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entities.Category;
import entities.Product;
import entities.User;
import utils.jpaUtils;

public class productDao {
	private EntityManager en;

	public  productDao() {
		this.en = jpaUtils.getEntityManager();
	}

	public void create(Product entity) throws Exception {
		try {
			this.en.getTransaction().begin();
			this.en.persist(entity);
			this.en.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.en.getTransaction().rollback();
			throw e;
		}

	}

	public List<Product> getAll() {
//		String jpql = "select obj from categories obj";
		TypedQuery<Product> query = this.en.createNamedQuery("Product.findAll", Product.class);
		return query.getResultList();
	}

	public Product findById(int id) {
		return this.en.find(Product.class, id);
	}

	public void update(Product entity) throws Exception {
		try {
			this.en.getTransaction().begin();
			this.en.merge(entity);
			this.en.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.en.getTransaction().rollback();
			throw e;
		}
	}

	public void delete(Product entity) throws Exception {
		try {
			this.en.getTransaction().begin();
			this.en.remove(entity);
			this.en.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.en.getTransaction().rollback();
			throw e;
		}
	}
	public List<Category> allTen(){
		String jpql = "SELECT obj FROM Category obj";
		TypedQuery<Category> query = this.en.createQuery(jpql,Category.class);
		return query.getResultList();
		
		
	}

}

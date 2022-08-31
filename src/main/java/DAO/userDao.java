package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entities.User;
import utils.jpaUtils;

public class userDao {
	private EntityManager em;

	public userDao() {
		this.em = jpaUtils.getEntityManager();
	}

	public void create(User entity) {
		try {
			this.em.getTransaction().begin();
			this.em.persist(entity);
			this.em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
			throw e;

		}
	}

	public List<User> getAll() {
		String jqpl = "select obj from User obj";
		TypedQuery<User> query = this.em.createQuery(jqpl, User.class);
		return query.getResultList();
	}

	public void delete(User entity) throws Exception {
		try {
			this.em.getTransaction().begin();
			this.em.remove(entity);
			this.em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
			throw e;
		}

	}

	public void update(User entity) throws Exception {
		try {
			this.em.getTransaction().begin();
			this.em.merge(entity);
			this.em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
			throw e;
		}

	}

	public User findById(int id) {
		return this.em.find(User.class, id);

	}

	public User findByEmail(String email) {
		String jpql = "SELECT obj FROM User obj  WHERE obj.email = :email";
		TypedQuery<User> query = this.em.createQuery(jpql, User.class);
		query.setParameter("email", email);
		return query.getSingleResult();
	}
}

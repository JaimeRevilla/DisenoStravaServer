package es.deusto.ingenieria.sd.strava.dao;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import es.deusto.ingenieria.sd.strava.server.data.domain.Reto;
import es.deusto.ingenieria.sd.strava.server.data.domain.Sesion;
import es.deusto.ingenieria.sd.strava.server.data.domain.Usuario;

public class StravaDAO implements IStravaDAO{
	
	private EntityManagerFactory emf;
	private static StravaDAO instance;
	

	public StravaDAO() {
		 emf = Persistence.createEntityManagerFactory("Persistencia");
	}

	
	public static StravaDAO getInstance() {
		if(instance == null) {
			instance = new StravaDAO();
		}
		return instance;
	}
	@Override
	public void storeUsuario(Usuario usuario) {
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	try {
		tx.begin();
		System.out.println("   * Storing an usuario: " + usuario);
		tx.commit();
	} catch (Exception ex) {
		System.out.println("   $ Error storing an usuario: " + ex.getMessage());
	} finally {
		if (tx != null && tx.isActive()) {
			tx.rollback();
		}

		em.close();
	}
		
	}
	

	@Override
	public Usuario getUsuario(String mail, String password) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Usuario usuario = null;

		try {
			System.out.println("   * Querying a usuario: " + mail);

			tx.begin();
			Query q = em.createQuery("SELECT FROM " + Usuario.class.getName() + " WHERE email == '" + mail + "' and password == '" + password + "'");
			usuario = (Usuario) q.getSingleResult();
			tx.commit();

		} catch (Exception ex) {
			System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
			return null;
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			em.close();
		}
		return usuario;
	}

	@Override
	public Usuario getUsuario(String mail) {
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		Usuario usuario = null;

		try {
			System.out.println("   * Querying a usuario: " + mail);

			tx.begin();
			Query q = em.createQuery("SELECT FROM " + Usuario.class.getName() + " WHERE email == '" + mail + "'");
			usuario = (Usuario) q.getSingleResult();
			tx.commit();

		} catch (Exception ex) {
			System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
			return null;
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			em.close();
		}
		return usuario;
	}

	@Override
	public void updateUsuario(Usuario usuario) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			em.close();
		}
		
	}

	@Override
	public List<Reto> getRetos(Usuario usuario) {
		EntityManager em = emf.createEntityManager();
		/*
		 * By default only 1 level is retrieved from the db so if we wish to fetch more
		 * than one level, we must indicate it
		 */

		EntityTransaction tx = em.getTransaction();
		List<Reto> retos = new ArrayList<>();

		try {
			System.out.println("   * Querying Reto List from: " + usuario.getMail());

			tx.begin();
			Query q = em.createQuery("SELECT retos FROM " + Usuario.class.getName() + " WHERE email == '" + usuario.getMail() + "'");
			retos = (List<Reto>) q.getResultList();
			tx.commit();

		} catch (Exception ex) {
			System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
			return null;
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			em.close();
		}
		return retos;
	}

	@Override
	public List<Sesion> getSesiones(Usuario usuario) {
		EntityManager em = emf.createEntityManager();
		/*
		 * By default only 1 level is retrieved from the db so if we wish to fetch more
		 * than one level, we must indicate it
		 */

		EntityTransaction tx = em.getTransaction();
		List<Sesion> sesiones = new ArrayList<>();

		try {
			System.out.println("   * Querying Reto List from: " + usuario.getMail());

			tx.begin();
			Query q = em.createQuery("SELECT retos FROM " + Usuario.class.getName() + " WHERE email == '" + usuario.getMail() + "'");
			sesiones = (List<Sesion>) q.getResultList();
			tx.commit();

		} catch (Exception ex) {
			System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
			return null;
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			em.close();
		}
		return sesiones;
	}

	@Override
	public List<Reto> getRetosActivos(Usuario usuario) {
		EntityManager em = emf.createEntityManager();
		/*
		 * By default only 1 level is retrieved from the db so if we wish to fetch more
		 * than one level, we must indicate it
		 */

		EntityTransaction tx = em.getTransaction();
		List<Reto> retosA = new ArrayList<>();

		try {
			System.out.println("   * Querying Reto List from: " + usuario.getMail());

			tx.begin();
			Query q = em.createQuery("SELECT retos FROM " + Usuario.class.getName() + " WHERE email == '" + usuario.getMail() + "'");
			retosA = (List<Reto>) q.getResultList();
			tx.commit();

		} catch (Exception ex) {
			System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
			return null;
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			em.close();
		}
		return retosA;
	}

	@Override
	public void deleteAllUsuarios() {
		System.out.println("- Cleaning the DB...");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			
			String jpql = "SELECT u FROM Usuario u";
			TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
			List<Usuario> usuarios = query.getResultList();			
			for(Usuario usuario: usuarios) {
				System.out.println("- Deleted User from DB: " + usuario.getMail());
				em.remove(usuario);
			}
			
			tx.commit();
		} catch (Exception ex) {
			System.err.println(" $ Error cleaning the DB: " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (em != null) {
				em.close();
			}
		}
		
	}

}

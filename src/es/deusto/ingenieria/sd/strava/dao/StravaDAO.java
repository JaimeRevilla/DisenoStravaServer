package es.deusto.ingenieria.sd.strava.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import es.deusto.ingenieria.sd.strava.server.data.domain.Reto;
import es.deusto.ingenieria.sd.strava.server.data.domain.Sesion;
import es.deusto.ingenieria.sd.strava.server.data.domain.Usuario;

public class StravaDAO implements IStravaDAO{
	
	private PersistenceManagerFactory pmf;
	private static StravaDAO instance;

	public StravaDAO() {
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}

	
	public static StravaDAO getInstance() {
		if(instance == null) {
			instance = new StravaDAO();
		}
		return instance;
	}
	@Override
	public void storeUsuario(Usuario usuario) {
	PersistenceManager pm = pmf.getPersistenceManager();
	Transaction tx = pm.currentTransaction();

	try {
		tx.begin();
		System.out.println("   * Storing an usuario: " + usuario);
		pm.makePersistent(usuario);
		tx.commit();
	} catch (Exception ex) {
		System.out.println("   $ Error storing an usuario: " + ex.getMessage());
	} finally {
		if (tx != null && tx.isActive()) {
			tx.rollback();
		}

		pm.close();
	}
		
	}
	

	@Override
	public Usuario getUsuario(String mail, String password) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);

		Transaction tx = pm.currentTransaction();
		Usuario usuario = null;

		try {
			System.out.println("   * Querying a usuario: " + mail);

			tx.begin();
			Query<?> query = pm.newQuery("SELECT FROM " + Usuario.class.getName() + " WHERE email == '" + mail + "' and password == '" + password + "'");
			query.setUnique(true);
			usuario = (Usuario) query.execute();
			tx.commit();

		} catch (Exception ex) {
			System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
			return null;
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		return usuario;
	}

	@Override
	public Usuario getUsuario(String mail) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);

		Transaction tx = pm.currentTransaction();
		Usuario usuario = null;

		try {
			System.out.println("   * Querying a usuario: " + mail);

			tx.begin();
			Query<?> query = pm.newQuery("SELECT FROM " + Usuario.class.getName() + " WHERE email == '" + mail + "'");
			query.setUnique(true);
			usuario = (Usuario) query.execute();
			tx.commit();

		} catch (Exception ex) {
			System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
			return null;
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		return usuario;
	}

	@Override
	public void updateUsuario(Usuario usuario) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			pm.makePersistent(usuario);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		
	}

	@Override
	public List<Reto> getRetos(Usuario usuario) {
		PersistenceManager pm = pmf.getPersistenceManager();
		/*
		 * By default only 1 level is retrieved from the db so if we wish to fetch more
		 * than one level, we must indicate it
		 */
		pm.getFetchPlan().setMaxFetchDepth(3);

		Transaction tx = pm.currentTransaction();
		List<Reto> retos = new ArrayList<>();

		try {
			System.out.println("   * Querying Reto List from: " + usuario.getMail());

			tx.begin();
			Query<?> query = pm.newQuery("SELECT retos FROM " + Usuario.class.getName() + " WHERE email == '" + usuario.getMail() + "'");
			query.setUnique(true);
			retos = (List<Reto>) query.execute();
			tx.commit();

		} catch (Exception ex) {
			System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
			return null;
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		return retos;
	}

	@Override
	public List<Sesion> getSesiones(Usuario usuario) {
		PersistenceManager pm = pmf.getPersistenceManager();
		/*
		 * By default only 1 level is retrieved from the db so if we wish to fetch more
		 * than one level, we must indicate it
		 */
		pm.getFetchPlan().setMaxFetchDepth(3);

		Transaction tx = pm.currentTransaction();
		List<Sesion> sesiones = new ArrayList<>();

		try {
			System.out.println("   * Querying Reto List from: " + usuario.getMail());

			tx.begin();
			Query<?> query = pm.newQuery("SELECT retos FROM " + Usuario.class.getName() + " WHERE email == '" + usuario.getMail() + "'");
			query.setUnique(true);
			sesiones = (List<Sesion>) query.execute();
			tx.commit();

		} catch (Exception ex) {
			System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
			return null;
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		return sesiones;
	}

	@Override
	public List<Reto> getRetosActivos(Usuario usuario) {
		PersistenceManager pm = pmf.getPersistenceManager();
		/*
		 * By default only 1 level is retrieved from the db so if we wish to fetch more
		 * than one level, we must indicate it
		 */
		pm.getFetchPlan().setMaxFetchDepth(3);

		Transaction tx = pm.currentTransaction();
		List<Reto> retosA = new ArrayList<>();

		try {
			System.out.println("   * Querying Reto List from: " + usuario.getMail());

			tx.begin();
			Query<?> query = pm.newQuery("SELECT retos FROM " + Usuario.class.getName() + " WHERE email == '" + usuario.getMail() + "'");
			query.setUnique(true);
			retosA = (List<Reto>) query.execute();
			tx.commit();

		} catch (Exception ex) {
			System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
			return null;
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		return retosA;
	}

	@Override
	public void deleteAllUsuarios() {
		System.out.println("- Cleaning the DB...");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			
			Extent<Usuario> uExtent = pm.getExtent(Usuario.class);
			for(Usuario usuario: uExtent) {
				System.out.println("- Deleted User from DB: " + usuario.getMail());
				pm.deletePersistent(usuario);
			}
			
			tx.commit();
		} catch (Exception ex) {
			System.err.println(" $ Error cleaning the DB: " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		
	}

}

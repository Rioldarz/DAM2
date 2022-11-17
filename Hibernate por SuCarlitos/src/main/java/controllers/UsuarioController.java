package controllers;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import models.Usuario;

public class UsuarioController {

	public String createUsuario(String nombre, String apellido, String direccion) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Usuario.class).buildSessionFactory();

		Session session = sessionFactory.openSession();

		try {
			Usuario usuario = new Usuario(nombre, apellido, direccion);

			session.beginTransaction();

			session.save(usuario);

			session.getTransaction().commit();

			session.close();

			return "Usuario creado";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Error al registrar el usuario";
	}

	public String deleteUsuario(int id) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Usuario.class).buildSessionFactory();

		Session session = sessionFactory.openSession();
		try {

			session.beginTransaction();

			Usuario usuario = session.get(Usuario.class, id);

			session.delete(usuario);

			session.getTransaction().commit();

			session.close();
			return "Usuario borrado";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Error al borrar el usuario";
	}

	public String getUsuario(int id) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Usuario.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		try {

			session.beginTransaction();

			Usuario usuario = session.get(Usuario.class, id);

			session.getTransaction().commit();

			session.close();
			return usuario.toString();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Error al obtener el usuario";

	}

	public void getUsuarios() {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Usuario.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Usuario> criteria = builder.createQuery(Usuario.class);
		criteria.from(Usuario.class);
		List<Usuario> data = session.createQuery(criteria).getResultList();
		 for(Usuario a : data) {
			 System.out.println(a.toString());
		 }

	}

}

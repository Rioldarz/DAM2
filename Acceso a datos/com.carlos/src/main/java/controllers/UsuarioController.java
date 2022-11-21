package controllers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import models.Usuario;
public class UsuarioController {
	
	public EntityManager manager;
	
	public String createUsuario(String nombre, String apellido, String direccion){
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuario.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try {
			Usuario usuario = new Usuario(nombre, apellido, direccion);
			
			session.beginTransaction();
			
			session.save(usuario);
			
			session.getTransaction().commit();
			
			session.close();
			
			return "Usuario Creado";
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return "Error al registrar el usuario";
	}
	public String deleteUsuario(int id) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuario.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try {
			
			
			session.beginTransaction();
			
			Usuario usuario = session.get(Usuario.class, id);
			
			session.delete(usuario);
			
			session.getTransaction().commit();
			
			session.close();
			
			return "Usuario Eliminado";
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return "Error al eliminar el usuario";
	}
	
	public String updateUsuario(int id, String nombre) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuario.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try {
			
			
			session.beginTransaction();
			
			Usuario usuario = session.get(Usuario.class, id);
			
			usuario.setNombre(nombre);
			
			session.update(usuario);
			
			session.getTransaction().commit();
			
			session.close();
			
			return "Usuario Actualizado";
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return "Error al actualizar el usuario";
	}
	
	public String getUsuario(int id) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuario.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try {
			
			
			session.beginTransaction();
			
			Usuario usuario = session.get(Usuario.class, id);
			
			session.getTransaction().commit();
			
			session.close();
			
			return usuario.toString();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return "Error al actualizar el usuario";
	}
	
	public void getUsuarios() {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuario.class).buildSessionFactory();
		
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
	
	



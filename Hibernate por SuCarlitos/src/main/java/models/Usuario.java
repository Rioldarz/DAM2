package models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")

public class Usuario implements Serializable {

	@Id
	@Column(name="id")
	public int id;
	
	@Column(name="nombre")
	public String nombre;
	
	@Column(name="apellido")
	public String apellido;
	
	@Column(name="ciudad")
	public String ciudad;
	
	public Usuario() {
		
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", ciudad=" + ciudad + "]";
	}

	public Usuario(String nombre, String apellido, String ciudad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.ciudad = ciudad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	
}

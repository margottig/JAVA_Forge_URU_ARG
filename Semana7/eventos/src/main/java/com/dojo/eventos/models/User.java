package com.dojo.eventos.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message=" Por favor ingresa un nombre")
	@Size(min=3, max=30, message="Nombre debe ser mayor a 3 caracteres y menor a 30")
	private String nombre;
	
	@NotBlank(message=" Por favor ingresa un apellido")
	@Size(min=3, max=30, message="Apellido debe ser mayor a 3 caracteres y menor a 30")
	private String apellido;
	
	@NotBlank(message=" Por favor ingresa un correo electronico")
	@Email(message="El correo ingresado no es correcto")
	private String email;
	
	@NotBlank(message=" Por favor ingresa una ubicacion")
	@Size(min=3, max=30, message="Ubicacion debe ser mayor a 3 caracteres y menor a 30")
	private String ubicacion;
	
	@NotBlank(message=" Por favor selecciona una provincia")
	private String provincia;
	
	@NotBlank(message="Por favor, ingresa el password")
	@Size(min=8, max=64, message= "Password debe contener minimo 8 caracteres")
	private String password;
	
	@Transient
	@NotBlank(message="Por favor confirma la contrasenia")
	@Size(min=8, message= "Password debe contener minimo 8 caracteres")
	private String passwordConfirmation;
	
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
	//Relacion 1:n hacia Eventos
	@OneToMany(mappedBy="organizador", fetch=FetchType.LAZY)
	private List<EventModel> eventosOrganizados;
	
	//Relacion muchos a muchos de Usuario a Eventos
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="asistentes",
	joinColumns= @JoinColumn(name="user_id"),
	inverseJoinColumns = @JoinColumn(name="event_id"))
	private List<EventModel> eventoAsistir;
	
	
	//Relacion n:n hacia mensajes
		@OneToMany(mappedBy="autor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
		private List<MensajeModel> mensajes;
	
	
	

	public User() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<EventModel> getEventosOrganizados() {
		return eventosOrganizados;
	}

	public void setEventosOrganizados(List<EventModel> eventosOrganizados) {
		this.eventosOrganizados = eventosOrganizados;
	}

	public List<EventModel> getEventoAsistir() {
		return eventoAsistir;
	}

	public void setEventoAsistir(List<EventModel> eventoAsistir) {
		this.eventoAsistir = eventoAsistir;
	}

	public List<MensajeModel> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<MensajeModel> mensajes) {
		this.mensajes = mensajes;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	// otros getters y setters removidos para resumir.
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

}

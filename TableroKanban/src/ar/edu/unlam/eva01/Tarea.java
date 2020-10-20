package ar.edu.unlam.eva01;

public class Tarea {
	private String nombre;
	private EstadoDeLasTareas estado;
	private Usuario creador;
	private Usuario actual;
	
	public Tarea(String nombre, Usuario creador) {
		this.nombre = nombre;
		this.creador = creador;
		estado = EstadoDeLasTareas.PENDIENTE;
	}
	
	public String getNombre() {
		return nombre;
	}
	public EstadoDeLasTareas getEstado() {
		return estado;
	}
	public Usuario getCreador() {
		return creador;
	}
	public Usuario getActual() {
		return actual;
	}
	
	public void setActual(Usuario elQueLaToma) {
		if(this.estado.equals(EstadoDeLasTareas.PENDIENTE)) {
			this.actual = elQueLaToma;
		}
	}
	
	public void setEstado(EstadoDeLasTareas nuevo) {
		this.estado = nuevo;
	}
	
	public String toString() {
		return this.nombre + "(" + this.actual + ")";
	}

}

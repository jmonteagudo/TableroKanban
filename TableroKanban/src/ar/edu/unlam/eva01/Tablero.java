package ar.edu.unlam.eva01;

import java.util.ArrayList;
import java.util.HashSet;

public class Tablero {

	private ArrayList<Tarea> tareas;
	private HashSet<Usuario> usuarios;
	
	public Tablero() {
		tareas = new ArrayList<Tarea>();
		usuarios = new HashSet<Usuario>();
		
	}
	
	public Boolean agregarTarea(Tarea nueva) {
		Boolean seAgrego = false;
		if(usuarios.contains(nueva.getCreador())){
			tareas.add(nueva);
			seAgrego = true;
		}
		return seAgrego;
	}
	
	public Boolean agregarUsuario(Usuario nuevo) {
		return usuarios.add(nuevo);
	}
	
	public ArrayList<Tarea> tareasPendientes(){
		ArrayList<Tarea> pendientes = new ArrayList<Tarea>();
		for(Tarea actual: tareas) {
			if(actual.getEstado().equals(EstadoDeLasTareas.PENDIENTE)) {
				pendientes.add(actual);
			}
		}
		return pendientes;
	}
	
	public ArrayList<Tarea> tareasEnCurso(){
		ArrayList<Tarea> enCurso = new ArrayList<Tarea>();
		for(Tarea actual: tareas) {
			if(actual.getEstado().equals(EstadoDeLasTareas.EN_CURSO)) {
				enCurso.add(actual);
			}
		}
		return enCurso;
	}
	
	public ArrayList<Tarea> tareasFinalizadas(){
		ArrayList<Tarea> finalizadas = new ArrayList<Tarea>();
		for(Tarea actual: tareas) {
			if(actual.getEstado().equals(EstadoDeLasTareas.EN_CURSO)) {
				finalizadas.add(actual);
			}
		}
		return finalizadas;
	}
	
	public String toString() {
		String estadoDelTablero = "Tablero Kanban\n\nPENDIENTES";
		
		for(Tarea actual: tareasPendientes()) {
			estadoDelTablero += "\n" + actual;
		}
		
		estadoDelTablero += "\nEN CURSO";

		for(Tarea actual: tareasEnCurso()) {
			estadoDelTablero += "\n" + actual;
		}
		
		estadoDelTablero += "\nEN CURSO";
		
		for(Tarea actual: tareasFinalizadas()) {
			estadoDelTablero += "\n" + actual;
		}
		
		return estadoDelTablero;
	}
	
	public Boolean tomarTarea(Tarea aModificar, Usuario elQueLaToma) {
		for(Tarea actual: this.tareasPendientes()) {
			if(aModificar.equals(actual)) {
				actual.setActual(elQueLaToma);
				actual.setEstado(EstadoDeLasTareas.EN_CURSO);
				return true;
			}
		}
		return false;
	}
}

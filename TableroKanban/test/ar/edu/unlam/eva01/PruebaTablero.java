package ar.edu.unlam.eva01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PruebaTablero {

	@Test
	void queSePuedanAgregarTareas() {
		Usuario andres = new Usuario("Andres");
		Usuario lucrecia = new Usuario("Lucrecia");
		Usuario juan = new Usuario("Juan");
		Usuario camila = new Usuario("Camila");
		
		Tarea programarElProducto = new Tarea("Programar el Producto", andres);
		Tarea probarElProducto= new Tarea("Probar el Producto", andres);
		Tarea programarElDescuento = new Tarea("Programar el Descuento", andres);
		Tarea probarElDescuento = new Tarea("Probar el Descuento", andres);
		Tarea mergearLosDesarrollos = new Tarea("Hacer el merge", andres);
		
		Tablero tareas = new Tablero();
		tareas.agregarTarea(programarElProducto);
		tareas.agregarTarea(programarElDescuento);
		tareas.agregarTarea(probarElProducto);
		tareas.agregarTarea(probarElDescuento);
		
		System.out.println(tareas);
		
		assertNotNull(tareas.tareasPendientes());
	}
	
	@Test
	void queSePuedanActualizarTareas() {
		Usuario andres = new Usuario("Andres");
		Usuario lucrecia = new Usuario("Lucrecia");
		Usuario juan = new Usuario("Juan");
		Usuario camila = new Usuario("Camila");
		
		Tarea programarElProducto = new Tarea("Programar el Producto", andres);
		Tarea probarElProducto= new Tarea("Probar el Producto", andres);
		Tarea programarElDescuento = new Tarea("Programar el Descuento", andres);
		Tarea probarElDescuento = new Tarea("Probar el Descuento", andres);
		Tarea mergearLosDesarrollos = new Tarea("Hacer el merge", andres);
		
		Tablero tareas = new Tablero();
		
		tareas.agregarUsuario(andres);
		tareas.agregarUsuario(camila);
		tareas.agregarUsuario(juan);
		
		tareas.agregarTarea(programarElProducto);
		tareas.agregarTarea(programarElDescuento);
		tareas.agregarTarea(probarElProducto);
		tareas.agregarTarea(probarElDescuento);
		
		tareas.tomarTarea(probarElDescuento, camila);
		
		assertNotNull(tareas.tareasEnCurso());
		
		System.out.println(tareas);
	}
	
	@Test
	void queNoSePuedanTomarTareasACargoDeOtroUsuario() {
		Usuario andres = new Usuario("Andres");
		Usuario lucrecia = new Usuario("Lucrecia");
		Usuario juan = new Usuario("Juan");
		Usuario camila = new Usuario("Camila");
		
		Tarea programarElProducto = new Tarea("Programar el Producto", andres);
		Tarea probarElProducto= new Tarea("Probar el Producto", andres);
		Tarea programarElDescuento = new Tarea("Programar el Descuento", andres);
		Tarea probarElDescuento = new Tarea("Probar el Descuento", andres);
		Tarea mergearLosDesarrollos = new Tarea("Hacer el merge", andres);
		
		Tablero tareas = new Tablero();
		
		tareas.agregarTarea(programarElProducto);
		tareas.agregarTarea(programarElDescuento);
		tareas.agregarTarea(probarElProducto);
		tareas.agregarTarea(probarElDescuento);
		
		tareas.tomarTarea(probarElDescuento, camila);
		tareas.tomarTarea(probarElDescuento, juan);
		
		assertEquals("Camila", tareas.tareasEnCurso().get(0).getActual().getNombre());
		
		System.out.println(tareas);
	}

}

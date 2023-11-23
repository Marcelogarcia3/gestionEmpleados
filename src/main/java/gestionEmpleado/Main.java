package gestionEmpleado;

import GestorDatos.GestorDatos;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		// Crear una lista de empleados
		List<Empleado> listaEmpleados = new ArrayList<>();

		// Crear instancias de EmpleadoAsalariado y EmpleadoPorHoras
		EmpleadoAsalariado empleadoAsalariado = new EmpleadoAsalariado("Juan", 2000.0);
		EmpleadoPorHoras empleadoPorHoras = new EmpleadoPorHoras("Pablo", 10.0, 40);


		// Agregar empleados a la lista
		listaEmpleados.add(empleadoAsalariado);
		listaEmpleados.add(empleadoPorHoras);

		// Calcular y mostrar el salario de cada empleado
		for (Empleado empleado : listaEmpleados) {
			System.out.println("Nombre del empleado: " + empleado.getNombre());
			System.out.println("Tipo de empleado: " + empleado.getTipo());
			System.out.println("Salario calculado: " + empleado.calcularSalario());
			System.out.println();
		}

		// Crear una instancia del gestor de datos
		GestorDatos gestor = new GestorDatos("empleados.txt");

		// Escribir la lista de empleados en el archivo
		gestor.escribirTxt(listaEmpleados);

		// Leer la lista de empleados desde el archivo
		List<Empleado> empleadosLeidos = gestor.leerTxt();

		// Imprimir los empleados leídos
		for (Empleado empleado : empleadosLeidos) {
			System.out.println(empleado);
		}
	}
}

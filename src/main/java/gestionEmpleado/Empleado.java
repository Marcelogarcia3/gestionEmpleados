package gestionEmpleado;
import java.io.Serializable;

public abstract class Empleado implements Serializable {
	private String nombre;
	private double salarioBase;

	public Empleado(String nombre, double salarioBase) {
		this.nombre = nombre;
		this.salarioBase = salarioBase;
	}

	public String getNombre() {
		return nombre;
	}

	public double getSalarioBase() {
		return salarioBase;
	}


	public abstract double calcularSalario();
	public abstract String getTipo();

}
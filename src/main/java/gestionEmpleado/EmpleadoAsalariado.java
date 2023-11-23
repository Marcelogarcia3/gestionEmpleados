package gestionEmpleado;

import java.io.Serializable;

public class EmpleadoAsalariado extends Empleado implements Serializable {


	public EmpleadoAsalariado(String nombre, double salarioBase) {
		super(nombre, salarioBase);
	}

	@Override
	public double calcularSalario() {
		return getSalarioBase();
	}

	@Override
	public String getTipo() {
		return "Empleado Asalariado";
	}

	@Override
	public String toString() {
		return "EmpleadoAsalariado [nombre=" + getNombre() + ", salarioMensual=" + getSalarioBase() + "]";
	}
}